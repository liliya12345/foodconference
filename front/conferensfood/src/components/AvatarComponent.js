import React, {useState} from 'react';
import {Container, Row} from "react-bootstrap";

function AvatarComponent(props) {
    const [auth, setAuth] = useState("false");

    function handelLogOut() {
        localStorage.setItem("token", "")
        setAuth("false");
        localStorage.setItem("auth", auth);
        window.location.reload();

    }

    return (

        <>
            <Container>
                <Row>
                    <div className="dropdown">
                        <button className="dropdown-toggle-avatar" type="button" id="dropdownMenuButton1"
                                data-bs-toggle="dropdown" aria-expanded="false"
                                style={{
                                    borderRadius: "50%",
                                    width: "35px",
                                    height: "35px",
                                    borderColor: "gray",
                                    backgroundImage: "url('../img/avatar.jpg')"
                                }}>

                        </button>
                        <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a className="dropdown-item">Mina sidor</a></li>
                            <li>
                                <button className=" btn dropdown-item" onClick={handelLogOut}>Logga ut</button>
                            </li>
                        </ul>
                    </div>
                </Row>
            </Container></>
    );
}

export default AvatarComponent;