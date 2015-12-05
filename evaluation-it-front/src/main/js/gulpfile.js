var gulp = require("gulp"),
        browserify = require("browserify"),
        factor = require("factor-bundle"),
        fs = require("fs"),
        glob = require("glob"),
        lint = require("./npm-components/gulp-jsx-lint/index"),
        less = require("gulp-less"),
        rm = require("gulp-rm"),
        gutil = require("gulp-util"),
        gwatch = require("gulp-watch"),
        merge = require("merge-stream"),
        path = require("path"),
        through = require("through2"),
        watchify = require("watchify"),
        minifyCSS = require("gulp-minify-css");


// -----------------------------------------------------------------------------
// GLOBAL TASKS
// -----------------------------------------------------------------------------
var PRODUCTION = process.env.NODE_ENV === "production";

gulp.task("clean", ["clean-resources", "clean-css", "clean-js"]);

gulp.task("build", ["copy-resources", "build-css", "build-js"]);

gulp.task("watch", ["copy-resources", "build-css", "lint-js", "clean-js"],
        function () {
            watchCommonJs();
            watchJsPages();
            watchCss();
        });


// -----------------------------------------------------------------------------
// GLOBAL VARS & FUNCTIONS
// -----------------------------------------------------------------------------

var JS_SRC_FILES = ["./ui-components/**/*.js", "./pages/**/*.js", "./common/**/*.js"];
var JS_DST_DIR = path.resolve("../webapp/js");

var CSS_SRC_DIR = path.resolve("../webapp/WEB-INF/less");
var CSS_DST_DIR = path.resolve("../webapp/css");


// Helper function to execute a function on files passing through the stream
function spyfile(fileFn) {
    return through.obj(function (file, _, next) {
        try {
            fileFn(file);
        } catch (e) {
        }
        this.push(file);
        next();
    });
}

function onStreamError(arg) {
    if (arg) {
        console.log(arg.toString());
        if (this.emit) {
            this.emit("end");
        }
    }
}

function removeFilesSync(srcArgs) {
    glob.sync(srcArgs).forEach(function (file) {
        console.log("  Delete: " + file);
        fs.unlinkSync(file);
    });
}

function copyFilesTask(srcArg, dstArg) {
    return gulp.src(srcArg)
            .pipe(spyfile(function (file) {
                console.log("  Copy: " + path.basename(file.path));
            }))
            .pipe(gulp.dest(dstArg));
}


// -----------------------------------------------------------------------------
// STATIC RESOURCES
// -----------------------------------------------------------------------------

// External libs
var externalLibs = [
    {
        srcDir: "external-libs",
        srcFiles: "*.js",
        dstDir: JS_DST_DIR
    }
];

// Magnific Popup
var magnificPopup = [
    {
        srcDir: "node_modules/magnific-popup/dist",
        srcFiles: "magnific-popup.css",
        dstDir: CSS_DST_DIR
    }
];

// Slick Carousel
var slickCarousel = [
    {
        srcDir: "node_modules/slick-carousel/slick",
        srcFiles: ["slick.css", "slick-theme.css", "ajax-loader.gif"],
        dstDir: CSS_DST_DIR
    }, {
        srcDir: "node_modules/slick-carousel/slick",
        srcFiles: "slick.js",
        dstDir: JS_DST_DIR
    }, {
        srcDir: "node_modules/slick-carousel/slick/fonts",
        srcFiles: "slick.*",
        dstDir: CSS_DST_DIR + "/fonts"
    }
];

var RESOURCES = [externalLibs, magnificPopup, slickCarousel];

// CLEAN & COPY RESOURCES
function forEachFileGroup(resources, fn) {
    resources.forEach(function (resource) {
        resource.forEach(fn);
    });
}

function forEachSrcDst(resources, fn) {
    resources.forEach(function (resource) {
        resource.forEach(function (fileGroup) {
            if (Array.isArray(fileGroup.srcFiles)) {
                fileGroup.srcFiles.forEach(function (srcFile) {
                    fn(fileGroup.srcDir, srcFile, fileGroup.dstDir);
                });
            } else {
                fn(fileGroup.srcDir, fileGroup.srcFiles, fileGroup.dstDir);
            }
        });
    });
}

gulp.task("clean-resources", function (done) {
    forEachSrcDst(RESOURCES, function (_, srcFile, dstDir) {
        removeFilesSync(dstDir + "/" + srcFile);
    });
    done();
});

gulp.task("copy-resources", ["clean-resources"], function () {
    var copyStreams = [];
    forEachSrcDst(RESOURCES, function (srcDir, srcFile, dstDir) {
        copyStreams.push(copyFilesTask(srcDir + "/" + srcFile, dstDir));
    });
    return merge(copyStreams);
});


// -----------------------------------------------------------------------------
// CSS
// -----------------------------------------------------------------------------

// CLEAN CSS
gulp.task("clean-css", function (done) {
    removeFilesSync(CSS_DST_DIR + "/client.css");
    done();
});

// BUILD CSS
function buildCssTask() {
    return gulp.src(CSS_SRC_DIR + "/*.less")
            .pipe(spyfile(function (file) {
                console.log("  Less: " + path.basename(file.path));
            }))
            .pipe(less().on("error", onStreamError))
            //.pipe(minifyCSS())
            .pipe(gulp.dest(CSS_DST_DIR));
}

function watchCss() {
    gwatch(CSS_SRC_DIR + "/**/*.less", buildCssTask);
}

gulp.task("build-css", ["clean-css", "copy-resources"], buildCssTask);
gulp.task("watch-css", ["build-css"], watchCss);


// -----------------------------------------------------------------------------
// JAVASCRIPT
// -----------------------------------------------------------------------------
var BROWSERIFY_ARGS = { cache: {}, packageCache: {}, fullPaths: true};

// CLEAN JS
gulp.task("clean-js", function (done) {
    removeFilesSync(JS_DST_DIR + "/*.js");
    done();
});

// LINT JS
gulp.task("lint-js", lint(JS_SRC_FILES));

// BUILD JS
function minifyBundle(bundle) {
    if (PRODUCTION) {
        console.log("  JS Minification");
        bundle.plugin('minifyify', {map: false, minify: PRODUCTION});
    }
    return bundle;
}

function browserifyCommonJs() {
    var b = browserify("./common/header.js", BROWSERIFY_ARGS);
    b.require("react/addons");
    b.require("domready");
    b.require("jquery");
    return minifyBundle(b);
}

function bundleCommonJs(browserified) {
    return browserified.bundle()
            .on("error", onStreamError)
            .pipe(fs.createWriteStream(JS_DST_DIR + "/common.js"));
}

function browserifyPages() {
    var pages = fs.readdirSync("./pages");

    var b = browserify(pages.map(function (p) {
        return "./pages/" + p;
    }), BROWSERIFY_ARGS);
    b.external("react/addons");
    b.external("domready");
    b.external("jquery");

    b = minifyBundle(b);
    return b.plugin("factor-bundle", {outputs: pages.map(function (p) {
            return JS_DST_DIR + "/" + p;
        })});
}

function bundlePages(browserified) {
    return browserified.bundle()
            .on("error", onStreamError)
            .pipe(fs.createWriteStream(JS_DST_DIR + "/pages-common.js"));
}

function watchCommonJs() {
    var browserified = browserifyCommonJs();
    var w = watchify(browserified);

    bundleCommonJs(browserified);

    w.on("update", function(files) {
        lint(files)().on("error", onStreamError);
        bundleCommonJs(browserified);
    });

    w.on("time", function(time) {
        gutil.log("Regenerated files in", gutil.colors.magenta(time / 1000 + " s"));
    });
}

function watchJsPages() {
    var browserified = browserifyPages();
    var w = watchify(browserified);

    bundlePages(browserified);

    w.on("update", function (files) {
        lint(files)().on("error", onStreamError);
        bundlePages(browserified);
    });

    w.on("time", function (time) {
        gutil.log("Regenerated files in", gutil.colors.magenta(time / 1000 + " s"));
    });
}

gulp.task("build-common-js", ["lint-js", "clean-js", "copy-resources"], function() {
    return bundleCommonJs(browserifyCommonJs());
});

gulp.task("build-js", ["lint-js", "clean-js", "copy-resources", "build-common-js"], function() {
    return bundlePages(browserifyPages());
});
gulp.task("watch-js", ["lint-js", "clean-js", "copy-resources"], function() {
    watchCommonJs();
    watchJsPages();
});
