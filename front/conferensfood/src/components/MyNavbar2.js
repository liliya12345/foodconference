import React from 'react';
import {Col, Container, Row} from "react-bootstrap";
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
                <Row className="my-3 justify-content-center" >
                    <Col sm="5">
                     <Logo2/>
                    </Col>
                    <Col sm="3">
                        <Languages/>
                    </Col>
                    <Col sm="4">
                        <LoginButton2/>
                    </Col>
                </Row>
            </Container>
        </>
    );
}

export default MyNavbar2;