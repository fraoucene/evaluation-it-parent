/**
 * Created by fraoucene on 30/09/15.
 *
 * @jsx React.DOM
 */

"use strict";
var React = require('react/addons'),
    Button =  require('react-bootstrap/lib/button');

module.exports = React.createClass({

    render: function() {
        var wellStyles = {maxWidth: 400, margin: '0 auto 10px'};
        return(

        <div className="contentCenter page-demo">
            <h1 className="myClass">HOME PAGE </h1>

              <div className="well" style={wellStyles}>
                <Button bsStyle="primary" bsSize="large" block>Block level button</Button>
                <Button bsSize="large" block>Block level button</Button>
              </div>
        </div>
        );
    }

});