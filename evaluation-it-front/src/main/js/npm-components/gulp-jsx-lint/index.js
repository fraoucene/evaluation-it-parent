var gulp = require("gulp"),
    jshint = require("gulp-jshint"),
    react = require("gulp-react");

module.exports = function(path) {
    return function() {
        return gulp.src(path)
             .pipe(react())
             .on("error", function(err){
                console.error(err.fileName + ": line " + err.lineNumber + ", col " + err.column + ", '" + err.description + "' (Error Reactify)");
             })
             .pipe(jshint())
             .pipe(jshint.reporter("default", {verbose: true}))
             .pipe(jshint.reporter("fail"));
    };
};
