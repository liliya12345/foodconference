import React, {useState} from "react";
import {Container, Nav, Navbar} from "react-bootstrap";
import Modal from 'react-bootstrap/Modal';
import axios from 'axios';
import Languages from "./Languages";
import AvatarComponent from "./AvatarComponent";
import {eyeOff} from 'react-icons-kit/feather/eyeOff';
import {eye} from 'react-icons-kit/feather/eye'
import RegistrationComponent from "./RegistrationComponent";
import LogginComponent from "./LogginComponent";


export default function MyNavbar() {
    const [show, setShow] = useState(false);
    const [showSecond, setShowSecond] = useState(false);
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const [showPass, setShowPass] = useState(false);
    const clickHandler = () => {
        setShowPass((prev) => !prev);
    };
    const [type, setType] = useState('password');
    const [icon, setIcon] = useState(eyeOff);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleCloseSecond = () => setShowSecond(false);
    const handleShowSecond = () => setShowSecond(true);
    const [isAuth, setIsAuth] = useState("false");
    const [company, setCompany] = useState(false);

    function onOptionChange() {
        setCompany(true);
        console.log(company);
    }
    function uppdateIsAuth(isAuth){
        setIsAuth(isAuth);
        console.log(isAuth);
    }

    const handleToggle = () => {
        if (type === 'password') {
            setIcon(eye);
            setType('text')
        } else {
            setIcon(eyeOff)
            setType('password')
        }
    }


    function handleLogin(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/auth", {
            "username": login, "password": password
        })
            .then(function (response) {
                // console.log(response.data.token)
                localStorage.setItem("token", response.data.token)
                setIsAuth("true");
                localStorage.setItem("auth", isAuth);
                handleClose();
            })
            .catch(function (err) {
                alert("Wrong username or password! ")
            })
    }

    return (<>
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
                                {isAuth === "false"
                                    ?
                                    <>
                                        <div className=" me-3 ">
                                            <button type="submit"
                                                    className="btn border border-secondary rounded-pill px-3 text-primary"
                                                    style={{top: "0", right: "25%"}} onClick={handleShow}>Logga in
                                            </button>
                                        </div>
                                        <div className=" me-3">
                                            <button type="submit"
                                                    className="btn btn-secondary  border-secondary  px-3  rounded-pill text-white"
                                                    style={{top: "0", right: "25%"}}
                                                    onClick={handleShowSecond}>Redistrera dig
                                            </button>
                                        </div>
                                    </>
                                    :
                                    <>
                                        <div className=" me-3">
                                            <AvatarComponent/>
                                        </div>
                                    </>}
                            </div>
                        </Navbar.Collapse>

                    </Navbar>


                </div>

            </Container>
        </div>

        <Modal show={show} onHide={handleClose}>
            <LogginComponent  isAuth ={isAuth} uppdateIsAuth={uppdateIsAuth}/>

        </Modal>
        <Modal show={showSecond} onHide={handleCloseSecond}>
            <RegistrationComponent/>
        </Modal>


    </>)
        ;

}