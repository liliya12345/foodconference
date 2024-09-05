import React, {useState} from "react";
import {Link} from "react-router-dom";
import {Button, Container, Nav, Navbar} from "react-bootstrap";
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import axios from 'axios';

export default function MyNavbar() {
    const [show, setShow] = useState(false);
    const [login,setLogin]= useState("");
    const [password,setPassword]= useState("");


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [auth,setAuth]= useState("false");

    function handleLogin(e) {
      e.preventDefault();
      axios.post("http://localhost:8080/auth",{
          "username":login,
          "password":password
      })
          .then(function (response){
              // console.log(response.data.token)
              localStorage.setItem("token",response.data.token)
              setAuth("true");
              localStorage.setItem("auth",auth);
              handleClose();
          })
          .catch(function (err){
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
                                <Link to="/" className="nav-item nav-link active">Home</Link>
                                <a href="#shop" className="nav-item nav-link">Shop</a>
                                <a href="shop-detail.html" className="nav-item nav-link">Shop Detail</a>
                                <div className="nav-item dropdown">
                                    <a href="#" className="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                    <div className="dropdown-menu m-0 bg-secondary rounded-0">
                                        <a href="cart.html" className="dropdown-item">Cart</a>
                                        <a href="chackout.html" className="dropdown-item">Chackout</a>
                                        <a href="testimonial.html" className="dropdown-item">Testimonial</a>
                                        <a href="404.html" className="dropdown-item">404 Page</a>
                                    </div>
                                </div>
                                <a href="contact.html" className="nav-item nav-link">Contact</a>

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
                                {/*<a href="#" className="my-auto">*/}

                                <button className=" my-auto fas fa-user fa-2x" onClick={handleShow}></button>

                                {/*</a>*/}
                            </div>
                        </Navbar.Collapse>
                    </Navbar>
                </Container>
            </div>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Logga in på Conference food</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Änvändarnamn</Form.Label>
                            <Form.Control onChange={(e)=>setLogin(e.target.value)}
                                type="text"
                                autoFocus
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                            <Form.Label>Lösenord</Form.Label>
                            <Form.Control onChange={(e)=>setPassword(e.target.value)}
                                type="password"
                            />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleLogin}>
                        Logga in
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );

}
