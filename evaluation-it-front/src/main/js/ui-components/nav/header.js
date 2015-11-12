/**
 * Created by fraoucene on 30/09/15.
 *
 * @jsx React.DOM
 */

"use strict";
var React = require('react/addons'),
    Nav =  require('react-bootstrap/lib/Nav'),
    Navbar =  require('react-bootstrap/lib/Navbar'),
    NavItem =  require('react-bootstrap/lib/NavItem'),
    NavBrand =  require('react-bootstrap/lib/NavBrand'),
    MenuItem =  require('react-bootstrap/lib/MenuItem'),
    NavDropdown =  require('react-bootstrap/lib/NavDropdown');

module.exports = React.createClass({

    render: function() {
        return(
            <Navbar inverse toggleNavKey={9}>
                <NavBrand>My-Project</NavBrand>
                <Nav right eventKey={0}> {/* This is the eventKey referenced */}
                    <NavItem eventKey={1} href="#">Profile</NavItem>
                    <NavItem eventKey={2} href="#">EspacePerso</NavItem>
                    <NavDropdown eventKey={3} title="Mon Compte" id="collapsible-navbar-dropdown">
                        <MenuItem eventKey="21">Mes Commandes</MenuItem>
                        <MenuItem eventKey="22">Mes Favorie</MenuItem>
                        <MenuItem eventKey="23">Espace VIP</MenuItem>
                        <MenuItem divider />
                        <MenuItem eventKey="42">Se Deconnecter</MenuItem>
                    </NavDropdown>
                </Nav>
            </Navbar>
        );
    }

});

