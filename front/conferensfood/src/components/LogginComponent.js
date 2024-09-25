import React, {useState} from "react";
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import axios from 'axios';
import deliveryman from "../img/custom_img_960x1250_crop_center.webp";


export default function LogginComponent( {uppdateIsAuth}) {
    const [show, setShow] = useState(false);
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const handleClose = () => setShow(false);

    function  authControl(){
        localStorage.setItem("auth", "true");
        uppdateIsAuth("true");

    }


    function handleLogin(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/auth", {
            "username": login, "password": password
        })
            .then(function (response) {
                localStorage.setItem("token", response.data.token)
                // console.log(response.data.token)
                authControl();
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

