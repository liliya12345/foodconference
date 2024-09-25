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
            <Modal.Body className="modal-body skor ">
                <div className="container-fluid ">

                    <div className="row skor">
                        <div className="col-12">
                            <img src={deliveryman} width="80%" height="80%" className="mx-5"/>
                        </div>
                        <div className="col-sm-12">
                            <Modal.Header closeButton>
                                <Modal.Title>REGISTRERA DIG!</Modal.Title>
                            </Modal.Header>
                            <div className="row">
                                <div className="col-12  me-3 mt-3">
                                    <Form>
                                        <div className="form-check d-inline-block">
                                            <input className="form-check-input" type="radio"
                                                   name="flexRadioDefault" id="flexRadioDefault1"
                                                   onChange={onOptionChange}/>
                                            <label className="form-check-label"
                                                   htmlFor="flexRadioDefault1">
                                                Privat person
                                            </label>
                                        </div>
                                        <div className="form-check d-inline-block m-2">
                                            <input className="form-check-input" type="radio"
                                                   name="flexRadioDefault" id="flexRadioDefault1"
                                                   onChange={onOptionChange2}/>
                                            <label className="form-check-label"
                                                   htmlFor="flexRadioDefault1">
                                                Företag
                                            </label>
                                        </div>
                                        {company === false ?
                                            <>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label className="text-label">Företagsnamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus

                                                    />
                                                    <Form.Label className="text-label">Adress</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />


                                                    <div className="row">
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Postnummer</Form.Label>
                                                            <Form.Control
                                                                type="text"
                                                                autoFocus
                                                            />
                                                        </div>
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Stad</Form.Label>
                                                            <Form.Control
                                                                type="text"
                                                                autoFocus
                                                            />
                                                        </div>
                                                    </div>


                                                    <Form.Label className="text-label">Bransch</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Förnamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Efternamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Änvänsnamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Efternamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Enter your email</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Telefonummer</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                </Form.Group>
                                            </> :
                                            <>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label className="text-label">Förnamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Efternamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Adress</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <div className="row">
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Postnummer</Form.Label>
                                                            <Form.Control
                                                                type="text"
                                                                autoFocus
                                                            />
                                                        </div>
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Stad</Form.Label>
                                                            <Form.Control
                                                                type="text"
                                                                autoFocus
                                                            />
                                                        </div>
                                                    </div>

                                                    <Form.Label className="text-label">Änvänsnamn</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />

                                                    <Form.Label className="text-label">Enter your email</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                    <Form.Label className="text-label">Telefonummer</Form.Label>
                                                    <Form.Control
                                                        type="text"
                                                        autoFocus
                                                    />
                                                </Form.Group>
                                            </>}
                                        <Form.Group className="mb-1" controlId="exampleForm.ControlInput2">
                                            <Form.Label className="text-label">Lösenord</Form.Label>

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
                                            <div className=" deliverys">
                                                <button type=" submit"
                                                        className=" btn btn-primary border-secondary py-1  rounded-pill text-white
                                                text-primary"
                                                        style={{top: "0", right: "25%",}}>
                                                    REGISTRERA
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

