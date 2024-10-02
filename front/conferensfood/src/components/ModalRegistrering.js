import React, {useState} from 'react';
import Modal from "react-bootstrap/Modal";
import deliveryman from "../img/custom_img_960x1250_crop_center.webp";
import Form from "react-bootstrap/Form";
import axios from "axios";

export default function ModalRegistrering(props) {

    const [show, setShow] = useState(false);
    const [showSecond, setShowSecond] = useState(false);
    const [login, setLogin] = useState("");
    const [name, setName]=useState("");
    const [password, setPassword] = useState("");
    const [showPass, setShowPass] = useState(false);
    const clickHandler = () => {
        setShowPass((prev) => !prev);
    };
    const [type, setType] = useState('password');
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleCloseSecond = () => setShowSecond(false);
    const handleShowSecond = () => setShowSecond(true);
    const[company, setCompany]= useState(false)


    function onOptionChange(){
        setCompany(true);
        console.log(company);

    }
    function onOptionChange2(){
        setCompany(false);
        console.log(company);

    }

    function handleRegistration() {
       console.log("this is...")
        axios.post("http://localhost:8080/api/registration/client", {
            "username": login, "password": password, "name":name
        })
            .then(function (response) {

                handleCloseSecond();
            })
            .catch(function (err) {
                alert("Wrong username or password! ")
            })
    }

    return (
        <Modal show={showSecond} onHide={handleCloseSecond}>

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
                                                    <Form.Control onChange={(e) => setName(e.target.value)}
                                                                  type="text"
                                                                  autoFocus

                                                    />
                                                    <Form.Label className="text-label">Adress</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />


                                                    <div className="row">
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Postnummer</Form.Label>
                                                            <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                          type="text"
                                                                          autoFocus
                                                            />
                                                        </div>
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Stad</Form.Label>
                                                            <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                          type="text"
                                                                          autoFocus
                                                            />
                                                        </div>
                                                    </div>


                                                    <Form.Label className="text-label">Bransch</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Förnamn</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Efternamn</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Änvänsnamn</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Efternamn</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Enter your email</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Telefonummer</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                </Form.Group>
                                            </> :
                                            <>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label className="text-label">Förnamn</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Efternamn</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Adress</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <div className="row">
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Postnummer</Form.Label>
                                                            <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                          type="text"
                                                                          autoFocus
                                                            />
                                                        </div>
                                                        <div className="col-6">
                                                            <Form.Label className="text-label">Stad</Form.Label>
                                                            <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                          type="text"
                                                                          autoFocus
                                                            />
                                                        </div>
                                                    </div>

                                                    <Form.Label className="text-label">Änvänsnamn</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />

                                                    <Form.Label className="text-label">Enter your email</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
                                                                  type="text"
                                                                  autoFocus
                                                    />
                                                    <Form.Label className="text-label">Telefonummer</Form.Label>
                                                    <Form.Control onChange={(e) => setLogin(e.target.value)}
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


                                        </Form.Group>
                                        <Form.Group className="mb-1" controlId="exampleForm.ControlInput3">
                                            <Form.Label className="text-label">Ladda din bild</Form.Label>

                                            <Form.Control

                                                type="file">

                                            </Form.Control>


                                        </Form.Group>
                                        <Form.Group>
                                            <div className=" deliverys">
                                                <button
                                                        className=" btn btn-primary border-secondary py-1  rounded-pill text-white
                                                text-primary"
                                                        style={{top: "0", right: "25%",}} onClick={handleRegistration} >
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


        </Modal>
    );
}

