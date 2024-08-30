import React from "react";
import {NavLink} from "react-router-dom";
import {Link} from "react-router-dom";
import {Container, Nav, Navbar} from "react-bootstrap";

export default function MyNavbar() {
    return (
        <div className="container-fluid fixed-top">
            <div className="container topbar bg-primary d-none d-lg-block">
                <div className="d-flex justify-content-between">
                    <div className="top-info ps-2">
                        <small className="me-3">
                            <i className="fas fa-map-marker-alt me-2 text-secondary"></i>{" "}
                            <a href="#" className="text-white">
                                123 Street, New York
                            </a>
                        </small>
                        <small className="me-3">
                            <i className="fas fa-envelope me-2 text-secondary"></i>
                            <a href="#" className="text-white">
                                Email@Example.com
                            </a>
                        </small>
                    </div>
                    <div className="top-link pe-2">
                        <a href="#" className="text-white">
                            <small className="text-white mx-2">Privacy Policy</small>/
                        </a>
                        <a href="#" className="text-white">
                            <small className="text-white mx-2">Terms of Use</small>/
                        </a>
                        <a href="#" className="text-white">
                            <small className="text-white ms-2">Sales and Refunds</small>
                        </a>
                    </div>
                </div>
            </div>
            <Container className="px-0">
                <Navbar expand="xl" className="navbar-light bg-white">
                    <Navbar.Brand href="/">
                        <h1 className="text-primary display-6">Fruitables</h1>
                    </Navbar.Brand>
                    <button
                        className="navbar-toggler py-2 px-3"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarCollapse"
                    >
                        <span className="fa fa-bars text-primary"></span>
                    </button>
                    <Navbar.Collapse className="bg-white" id="navbarCollapse">
                        <Nav className="mx-auto">
                            <Link to="/" class="nav-item nav-link active">Home</Link>
                            <a href="#shop" class="nav-item nav-link">Shop</a>
                            <a href="shop-detail.html" class="nav-item nav-link">Shop Detail</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="cart.html" class="dropdown-item">Cart</a>
                                    <a href="chackout.html" class="dropdown-item">Chackout</a>
                                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                    <a href="404.html" class="dropdown-item">404 Page</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>

                        </Nav>
                        <div className="d-flex m-3 me-0">
                            <button
                                className="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4"
                                data-bs-toggle="modal"
                                data-bs-target="#searchModal"
                            >
                                <i className="fas fa-search text-primary"></i>
                            </button>
                            <a href="#" className="position-relative me-4 my-auto">
                                <i className="fa fa-shopping-bag fa-2x"></i>
                                {/* <span
                className="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                 style="top: -5px; left: 15px; height: 20px; min-width: 20px;"
                >
                  3
                </span> */}
                            </a>
                            <a href="#" className="my-auto">
                                <i className="fas fa-user fa-2x"></i>
                            </a>
                        </div>
                    </Navbar.Collapse>
                </Navbar>
            </Container>
        </div>
    );
}
