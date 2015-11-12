var gulp = require("gulp"),
        browserify = require("browserify"),
        fs = require("fs"),
        FileCache = require("gulp-file-cache"),
        less = require("gulp-less"),
        plumber = require("gulp-plumber"),
        rm = require("gulp-rm"),
        gwatch = require('gulp-watch'),
        globmatch = require("minimatch"),
        path = require("path"),
        runseq = require("run-sequence"),
        through = require("through2"),
        File = require("vinyl"),
        lint = require("./npm-components/gulp-jsx-lint/index");


// Helper function to execute a function on files passing through the stream
function spyfile(fileFn) {
    return through.obj(function(file, _, next) {
        try { fileFn(file); } catch (e) {}
        this.push(file);
        next();
    });
}


// ---------------------------------------------------------------------------
// GLOBAL TASKS AND VARS
// ---------------------------------------------------------------------------
var JS_DST_DIR  = path.resolve("../webapp/js");
var JS_SRC_DIR = ["./ui-components/**/*.js", "./pages/**/*.js", "./common/**/*.js", "./data-api/**/*.js"];
var CSS_SRC_DIR = path.resolve("../webapp/WEB-INF/less");
var CSS_DST_DIR = path.resolve("../webapp/css");

var XTRN_CSS_SRC_DIR     = path.resolve("../../../../integration-html/final/less");
var SOCIETAIRES_LESS_DIR  = path.resolve("../../../../webmo-societaire-front/src/main/webapp/WEB-INF/less");
var XTRN_CMN_IMG_SRC_DIR = path.resolve("../../../../integration-html/final/img/common");
var XTRN_IMG_SRC_DIR     = path.resolve("../../../../integration-html/final/img/sample");
var XTRN_FNT_SRC_DIR     = path.resolve("../../../../integration-html/final/webfont");

var IMG_CMN_DST_DIR = path.resolve("../webapp/img/common");
var IMG_DST_DIR     = path.resolve("../webapp/img");
var FNT_DST_DIR     = path.resolve("../webapp/webfont");

var SLICK_SRC = path.resolve("./node_modules/slick-carousel/slick");

var DEBUG = false;

gulp.task("default", ["rebuild"]);

gulp.task("clean", ["clean-cache", "clean-js", "clean-css", "clean-extern-slick-carousel-css"]);
gulp.task("build", ["build-js", "build-css", "copy-extern-slick-carousel-css"]);
gulp.task("rebuild", ["clean"], function(done) { runseq("build", done); });

gulp.task("watch", ["rebuild"], function() { cssWatcher(); jsWatcher(); });


gulp.task("copy-extern", ["copy-extern-css", "copy-extern-societaires-css", "copy-extern-common-img", "copy-extern-img", "copy-extern-font"]);
gulp.task("clean-extern", ["clean-extern-css", "clean-extern-common-img", "clean-extern-img", "clean-extern-font"]);
gulp.task("recopy-extern", ["clean-extern"], function(done) { runseq("copy-extern", done); });

gulp.task("watch-extern", ["recopy-extern"], function() {
    externCssWatcher(); externCommonImgWatcher(); externImgWatcher(); externFontWatcher(); });

gulp.task("watch-all", ["clean-extern", "clean"], function() {
    runseq("copy-extern", "build", function() {
        console.log("Start watchers !!");
        cssWatcher(); jsWatcher(); externCssWatcher(); externCommonImgWatcher(); externImgWatcher(); externFontWatcher();
    });
});

gulp.task("lint", lint(JS_SRC_DIR));

// ---------------------------------------------------------------------------
// MANAGE CACHE FILE
// ---------------------------------------------------------------------------
var cacheFileName = ".gulp-cache";
var fileCache = new FileCache(cacheFileName);

function resetFilesInCache(fileCache, pattern, options) {
    var opts = options || {};
    Object.keys(fileCache._cache).forEach(function(filepath) {
        if (globmatch(filepath, pattern)) {
            if (opts.debug) {
                console.log("[resetCache] " + filepath);
            }
            fileCache._cache[filepath] = 0;
        }
    });
    try {
        fs.writeFileSync(fileCache._filename, JSON.stringify(fileCache._cache));
    } catch (e) { /* ignored */ }
}

gulp.task("clean-cache", function (done) {
    fileCache.clear();
    try { fs.unlinkSync(cacheFileName); } catch (e) { /* ignored */ }
    done();
});

// ---------------------------------------------------------------------------
// BUILD CSS FILES
// ---------------------------------------------------------------------------
gulp.task("build-css", function() {
    return gulp.src(CSS_SRC_DIR + "/*.less")
            .pipe(plumber())
            .pipe(fileCache.filter())
            .pipe(fileCache.cache())
            .pipe(spyfile(function(file) {
                console.log("  Less: " + path.basename(file.path));
            }))
            .pipe(less())
            .pipe(gulp.dest(CSS_DST_DIR));
});

gulp.task("clean-css", function() {
    resetFilesInCache(fileCache, CSS_SRC_DIR + "/*.less", {debug: DEBUG});
    return gulp.src(CSS_DST_DIR + "/evaluation-it.css", {read: false}).pipe(rm());
});

gulp.task("rebuild-css", ["clean-css"], function() {
    runseq("build-css");
});

function cssWatcher() {
    gwatch({glob: CSS_SRC_DIR + "/*.less", emitOnGlob: false, name: "[CSS]"}, ["build-css"]);
    gwatch({glob: CSS_SRC_DIR + "/*/*.less", emitOnGlob: false, name: "[CSS]"}, ["rebuild-css"]);
}

gulp.task("watch-css", ["rebuild-css"], function () {
    cssWatcher();
});


// ---------------------------------------------------------------------------
// COPY EXTERNAL RESOURCES
// ---------------------------------------------------------------------------
function addCopyExternTask(opts) {
    if (!opts.name || !opts.sources || !opts.outdirpath) {
        throw "addCopyExternTask: name, sources, outdirpath options are required";
    }
    gulp.task("copy-extern-" + opts.name, function() {
        return gulp.src(opts.sources)
                .pipe(fileCache.filter())
                .pipe(fileCache.cache())
                .pipe(spyfile(function(file) {
                    console.log("  Copy extern " + opts.name + ": " + path.basename(file.path));
                }))
                .pipe(gulp.dest(opts.outdirpath));
    });
}

function addCleanExternTask(opts) {
    if (!opts.name || !opts.sources || !opts.outfiles) {
        throw "addCleanExternTask: name, sources, outfiles options are required";
    }
    gulp.task("clean-extern-" + opts.name, function() {
        resetFilesInCache(fileCache, opts.sources, {debug: DEBUG});
        return gulp.src(opts.outfiles, {read: false})
                .pipe(spyfile(function(file) {
                    console.log("  Remove extern " + opts.name + ": " + path.basename(file.path));
                })).pipe(rm());
    });
}

function addRecopyExternTask(opts) {
    if (!opts.name) {
        throw "addRecopyExternTask: name option is required";
    }
    gulp.task("recopy-extern-" + opts.name, ["clean-extern-" + opts.name], function(done) {
        runseq("copy-extern-" + opts.name, done);
    });
}

function addWatchExternTask(opts) {
    if (!opts.name || !opts.watchfn) {
        throw "addRecopyExternTask: name and watchfn options are required";
    }
    gulp.task("watch-extern-" + opts.name, ["recopy-extern-" + opts.name], function() {
        opts.watchfn();
    });
}


// CUSTOM WATCHERS
function externCssWatcher() {
    gwatch({glob: XTRN_CSS_SRC_DIR + "/*.less", emitOnGlob: false, name: "[Extern CSS]"}, ["copy-extern-css"]);
}

function societairesCssWatcher() {
    gwatch({glob: SOCIETAIRES_LESS_DIR + "/societaires.less", emitOnGlob: false, name: "[Societaires CSS]"}, ["copy-extern-societaires-css"])
}

function externCommonImgWatcher() {
    gwatch({glob: XTRN_CMN_IMG_SRC_DIR + "/*.*", emitOnGlob: false, name: "[Extern CMN IMG]"}, ["copy-extern-common-img"]);
}

function externImgWatcher() {
    gwatch({glob: XTRN_IMG_SRC_DIR + "/*.*", emitOnGlob: false, name: "[Extern IMG]"}, ["copy-extern-img"]);
}

function externFontWatcher() {
    gwatch({glob: XTRN_FNT_SRC_DIR + "/*.*", emitOnGlob: false, name: "[Extern FONT]"}, ["copy-extern-font"]);
}

// ADD EXTERN RESOURCES TASKS
[
    {name: "css",
        sources: XTRN_CSS_SRC_DIR + "/*.less",
        outdirpath: CSS_SRC_DIR + "/common",
        outfiles: CSS_SRC_DIR + "/common/*.*",
        watchfn: externCssWatcher},

    {name: "societaires-css",
        sources: SOCIETAIRES_LESS_DIR + "/societaires.less",
        outdirpath: CSS_SRC_DIR + "/common",
        outfiles: CSS_SRC_DIR + "/common/*.*",
        watchfn: externCssWatcher},

    {name: "common-img",
        sources: XTRN_CMN_IMG_SRC_DIR + "/*.*",
        outdirpath: IMG_CMN_DST_DIR,
        outfiles: IMG_CMN_DST_DIR + "/*.*",
        watchfn: externCommonImgWatcher},

    {name: "img",
        sources: XTRN_IMG_SRC_DIR + "/*.*",
        outdirpath: IMG_DST_DIR,
        outfiles: IMG_DST_DIR + "/*.*",
        watchfn: externImgWatcher},

    {name: "font",
        sources: XTRN_FNT_SRC_DIR + "/*.*",
        outdirpath: FNT_DST_DIR,
        outfiles: FNT_DST_DIR + "/*.*",
        watchfn: externFontWatcher},

    {name: "slick-carousel-css",
        sources: [SLICK_SRC + "/slick.css", SLICK_SRC + "/slick.css.map", SLICK_SRC + "/ajax-loader.gif"],
        outdirpath: CSS_DST_DIR,
        outfiles: [CSS_DST_DIR + "/slick.css", CSS_DST_DIR + "/slick.css.map", CSS_DST_DIR + "/ajax-loader.gif"],
        watchfn: function() {}}

].forEach(function(opts) {
    addCopyExternTask(opts);
    addCleanExternTask(opts);
    addRecopyExternTask(opts);
    addWatchExternTask(opts);
});


// ---------------------------------------------------------------------------
// BUILD JS FILES
// ---------------------------------------------------------------------------

gulp.task("copy-external-js", function() {
    return gulp.src("external-libs/**/*.js")
                .pipe(fileCache.filter())
                .pipe(fileCache.cache())
                .pipe(spyfile(function(file) {
                    console.log("  Copy external js: " + path.basename(file.path));
                }))
                .pipe(gulp.dest(JS_DST_DIR));
});

// Gulp friendly function to browserify only once when some files have changed
function browserifyOnce(opts) {
    if (!opts.outfilename || (!opts.entries && !opts.requires)) {
        throw "[browserifyOnce] outfilename, entries or requires options are required";
    }
    var once = false;
    return through.obj(function(file, _, next) {
        console.log("  Browserify: " + path.basename(file.path));
        if (!once) {
            once = true;
            var builder = browserify();
            if (opts.entries) {
                opts.entries.map(function(e) {
                    builder.add(e);
                });
            }
            if (opts.requires) {
                opts.requires.map(function(r) {
                    builder.require(r);
                });
            }
            if (opts.externals) {
                opts.externals.map(function(e) {
                    builder.external(e);
                });
            }

            var bundleCallback = function (err, src) {
                if (err) {
                    console.error("[browserify] " + err);
                } else {
                    var bfile = new File({path: opts.outfilename, contents: new Buffer(src)});
                    this.push(bfile);
                }
                next();
            }.bind(this);

            builder.bundle(bundleCallback);

        } else {
            next();
        }
    });
}

// Helper function to add browserify task
function addBrowserifyTask(opts) {
    if (!opts.taskname || !opts.sources || !opts.outdirpath) {
        throw "addBrowserifyTask: taskname, sources, outdirpath options required";
    }
    gulp.task(opts.taskname, opts.deps, function() {
        return gulp.src(opts.sources, {read: false})
                .pipe(fileCache.filter())
                .pipe(fileCache.cache())
                .pipe(browserifyOnce(opts))
                .pipe(gulp.dest(opts.outdirpath));
    });
}

// Define page build properties
var common_dependencies = ["react/addons", "domready"];

var page_infos = [
    {name: "common", sources: ["./common/header.js"], outfilename: "common.js",
        noentries: true, requires: common_dependencies},

    {name: "index", deps:["build-common"], externals: common_dependencies}
];

// Add JS tasks to build a page
page_infos.forEach(function(opts) {
    if (!opts.name) {
        throw "add JS page task: name options is required";
    }

    var pagepath = "./pages/" + opts.name + ".js";
    if (!opts.taskname) {
        opts.taskname = "build-" + opts.name;
    }
    if (!opts.deps) {
        opts.deps = [];
    }
    if (!opts.sources) {
        opts.sources = [pagepath];
    }
    if (!opts.outdirpath) {
        opts.outdirpath = JS_DST_DIR;
    }
    if (!opts.outfilename) {
        opts.outfilename = opts.name + ".js";
    }
    if (!opts.entries && !opts.noentries) {
        opts.entries = [pagepath];
    }

    addBrowserifyTask(opts);
});

// Add JS tasks to clean and build all pages
gulp.task("build-js", function(done) { runseq("lint", page_infos.map(function(infos) { return "build-" + infos.name; }).concat("copy-external-js"), done); });

gulp.task("clean-js", function() {
    resetFilesInCache(fileCache, "**/*.js", {debug: DEBUG});
    return gulp.src(JS_DST_DIR + "/*.js", {read: false}).pipe(rm());
});

gulp.task("rebuild-js", ["clean-js"], function(done) {
    runseq("build-js", done);
});

// Add JS task to watch JS files
function jsWatcher() {
    gwatch({glob: ["./common/**/*.js", "./pages/**/*.js"], emitOnGlob: false, name: "[JS]"}, ["build-js"]);
    gwatch({glob: "./ui-components/**/*.js", emitOnGlob: false, name: "[JS]"}, function(_, done) {
        resetFilesInCache(fileCache, "**/*.js", {debug: DEBUG});
        runseq("build-js", done);
    });
}

gulp.task("watch-js", ["rebuild-js"], function () {
    jsWatcher();
});
