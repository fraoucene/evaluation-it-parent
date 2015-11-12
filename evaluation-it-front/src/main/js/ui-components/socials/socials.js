/**
 * Created by fraoucene on 30/09/15.
 *
 * @jsx React.DOM
 */

"use strict";
var React = require('react/addons');

module.exports = React.createClass({

    render: function() {
        return(
            <div className="socials">
                <p>Nous sommes <strong>disponibles</strong> pour travailler. contactez-nous pour un devis au<span><a href="#">contact [at] websitename [dot] com</a></span></p>

                <ul>
                    <li><a href="#" className="facebook-ico">facebook-ico</a></li>
                    <li><a href="#" className="twitter-ico">twitter-ico</a></li>
                    <li><a href="#" className="skype-ico">skype-ico</a></li>
                    <li><a href="#" className="rss-ico">rss-ico</a></li>
                </ul>
            </div>
        );
    }

});

