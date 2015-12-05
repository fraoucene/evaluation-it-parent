/**
 * Created by fraoucene on 17/12/14.
 *
 * @jsx React.DOM
 */
"use strict";
var domReady = require("domready"),
    ReactDom = require('react-dom'),
    Home =  require('../ui-components/home/home'),
    Socials =  require('../ui-components/socials/socials');



domReady(function() {

var s = "ddddddd";
            console.log("ssssss = ",s);
    ReactDom.render(
        <Home key="2" />,
        document.getElementsByClassName("home__rp")[0]
    );

    ReactDom.render(
        <Socials key="2" />,
        document.getElementsByClassName("socials__rp")[0]
    );


});
