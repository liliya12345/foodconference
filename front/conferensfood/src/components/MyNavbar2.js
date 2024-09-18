import React from 'react';
import {Container, Row} from "react-bootstrap";
import HeaderComponent2 from "./HeaderComponent2";
import Languages from "./Languages";
import Logo2 from "./Logo2";
import LoginButton2 from "./LoginButton2";

function LoginButton() {
    return null;
}

function MyNavbar2(props) {
    return (
        <>
            <Container>
                <Row>
                    <HeaderComponent2/>
                </Row>
                <Row >
                    <div className="col-md-7 p-1">
                     <Logo2/>
                    </div>
                    <div className="col-md-2 p-2">
                        <Languages/>
                    </div>
                    <div className="col-md-3 p-1">
                        <LoginButton2/>
                    </div>
                </Row>
            </Container>
        </>
    );
}

export default MyNavbar2;