import React, {useState} from 'react';
import Modal from "react-bootstrap/Modal";
import deliveryman from "./img/custom_img_960x1250_crop_center.webp";
import Form from "react-bootstrap/Form";
import {Icon} from "react-icons-kit";
import axios from "axios";
import {eyeOff} from 'react-icons-kit/feather/eyeOff';
import {eye} from 'react-icons-kit/feather/eye'

export default function RegistrationComponent(props) {
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

    const [auth, setAuth] = useState("false");
    const [company, setCompany] = useState(false)


    function onOptionChange() {
        setCompany(true);
        console.log(company);

    }

    function onOptionChange2() {
        setCompany(false);
        console.log(company);

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
            <Modal.Body className="modal-body">
                <div className="container-fluid">

                    <div className="row">
                        <div className="col-sm-12">
                            <Modal.Header closeButton>
                                <Modal.Title>Logga in på Conference food</Modal.Title>
                            </Modal.Header>
                            <div className="row">
                                <div className="col-4 col-sm-6 mt-3">
                                    <img src={deliveryman} width="100%" height="100%"/>
                                </div>
                                <div className="col-8 col-sm-6">
                                    <Form>
                                        <Form.Group className=" mt-3 py-2 me-3" controlId="exampleForm.ControlInput1">
                                            <Form.Label>Änvändarnamn</Form.Label>
                                            <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                          type="text"
                                                          autoFocus
                                            />
                                        </Form.Group>
                                        <Form.Group className="me-3" controlId="exampleForm.ControlInput2">
                                            <Form.Label>Lösenord</Form.Label>

                                            <Form.Control

                                                onChange={(e) => setPassword(e.target.value)}
                                                type="password">

                                            </Form.Control>
                                            <span className=" flex justify-around items-center"
                                                  onClick={handleToggle}>
                                                <Icon class=" absolute mr-10" icon={icon} size={25}/>
                                                </span>


                                        </Form.Group>
                                        <Form.Group>
                                            <div className=" mt-4 py-2 me-3">
                                                <button type=" submit"
                                                        className=" btn border border-secondary rounded-pill px-3
                                                text-primary"
                                                        style={{top: "0", right: "25%"}} onClick={handleLogin}>Logga
                                                    in
                                                </button>
                                            </div>
                                        </Form.Group>
                                    </Form>
                                </div>

                            </div>
                        </div>

                    </div>

                </div>


            </Modal.Body>
            <Modal.Footer>

            </Modal.Footer>


        </>

    )
}

