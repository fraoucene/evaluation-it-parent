/**
 * Created by fraoucene on 18/03/15.
 */
'use strict';

module.exports.getParameterByName = function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
};

module.exports.formatIdOeuvre = function(id) {
    if(!id) { return; }
    return id.substring(0,2) + '.' + id.substring(2,5) + '.' + id.substring(5,8) + '.' + id.substring(8);
};
