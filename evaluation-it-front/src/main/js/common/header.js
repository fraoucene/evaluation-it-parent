/**
 * Code lié au header inclus dans toutes les pages
 *
 * @module common/header
 * @jsx React.DOM
 */

var React = require("react/addons"),
    domReady = require("domready");

function noop(){}
noop(domReady);

React.initializeTouchEvents(true);
