import React, {useState} from "react";
import {Container, Nav, Navbar} from "react-bootstrap";
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import axios from 'axios';
import Languages from "./Languages";
import deliveryman from "../img/custom_img_960x1250_crop_center.webp";

export default function MyNavbar() {
    const [show, setShow] = useState(false);
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [auth, setAuth] = useState("false");

    function handleLogin(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/auth", {
            "username": login,
            "password": password
        })
            .then(function (response) {
                // console.log(response.data.token)
                localStorage.setItem("token", response.data.token)
                setAuth("true");
                localStorage.setItem("auth", auth);
                handleClose();
            })
            .catch(function (err) {
                alert("Wrong username or password! ")
            })
    }

    return (
        <>
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
                    <div className="row">
                        <Navbar expand="xl" className="navbar-light bg-white">
                            <Navbar.Brand href="/">
                                <h1 className="text-primary display-6">Events & Konferensmat</h1>
                            </Navbar.Brand>
                            <button
                                className="navbar-toggler py-2 px-3"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#navbarCollapse">
                                <span className="fa fa-bars text-primary"></span>
                            </button>
                            <Navbar.Collapse className="bg-white" id="navbarCollapse">
                                <Nav className="mx-auto">
                                    <div className="nav-item dropdown">
                                        <div className="dropdown-menu m-0 bg-secondary rounded-0">
                                        </div>
                                    </div>
                                </Nav>

                                <div className="d-flex">
                                    <a href="#" className="my-auto">
                                        <Languages/>
                                    </a>
                                    {
                                        auth==="false"
                                        ? <>
                                                <div className=" me-3 ">
                                                    <button type="submit"
                                                            className="btn border border-secondary rounded-pill px-3 text-primary"
                                                            style={{top: "0", right: "25%"}} onClick={handleShow}>Logga in
                                                    </button>
                                                </div>
                                                <div className=" me-3">
                                                    <button type="submit"
                                                            className="btn btn-secondary border-2 border-secondary py-1 px-4  rounded-pill text-white"
                                                            style={{top: "0", right: "25%"}}>Redistrera dig
                                                    </button>
                                                </div>
                                            </>
                                            :
                                            <>
                                                <div className=" me-3">
                                                    <button type="submit"
                                                            className="btn btn-secondary border-2 border-secondary py-1 px-4  rounded-pill text-white"
                                                            style={{top: "0", right: "25%"}}>Hello!
                                                    </button>
                                                </div>
                                            </>


                                    }


                                </div>
                            </Navbar.Collapse>

                        </Navbar>


                    </div>

                </Container>
            </div>
            <div className="container ">
                <div className="row g-5 align-items-center">
                    <Modal show={show} onHide={handleClose}>
                        <div className="col-md-12 col-lg-6">
                            <img src={deliveryman} width="249px" height="450px"/>
                        </div>
                        <div className="col-md-12 col-lg-6">

                            <Modal.Header closeButton>
                                <Modal.Title>Logga in på Conference food</Modal.Title>
                            </Modal.Header>
                            <Modal.Body>
                                <Form>
                                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                                        <Form.Label>Änvändarnamn</Form.Label>
                                        <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                      type="text"
                                                      autoFocus
                                        />
                                    </Form.Group>
                                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                                        <Form.Label>Lösenord</Form.Label>
                                        <Form.Control onChange={(e) => setPassword(e.target.value)}
                                                      type="password"
                                        />
                                    </Form.Group>
                                    <Form.Group>
                                        <div className=" me-3 ">
                                            <button type="submit"
                                                    className="btn border border-secondary rounded-pill px-3 text-primary"
                                                    style={{top: "0", right: "25%"}} onClick={handleLogin}>Logga in
                                            </button>
                                        </div>
                                    </Form.Group>
                                </Form>
                            </Modal.Body>
                            <Modal.Footer>

                            </Modal.Footer>
                        </div>
                    </Modal>

                </div>
            </div>

        </>
    );

}
