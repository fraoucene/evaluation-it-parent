/**
 * Created by fraoucene on 17/12/14.
 *
 * @jsx React.DOM
 */
"use strict";
var domReady = require('domready'),
    React = require('react/addons'),
    Home =  require('../ui-components/home/home'),
    Socials =  require('../ui-components/socials/socials');



domReady(function() {
    React.render(
        <Home key="2" />,
        document.getElementsByClassName("home__rp")[0]
    );

    React.render(
        <Socials key="2" />,
        document.getElementsByClassName("socials__rp")[0]
    );


});
