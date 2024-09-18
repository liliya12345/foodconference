import React from 'react';
import {Button, Container} from "react-bootstrap";

function LoginButton2(props) {
    return (
        <>
            <Container>

                {/*<Col md-8>*/}
                {/*        <Button variant="secondary" >*/}
                {/*            Close*/}
                {/*        </Button>*/}
                {/*    </Col>*/}
                {/*<Col md-8>*/}
                {/*        <Button variant="primary">*/}
                {/*            Logga in*/}
                {/*        </Button>*/}
                {/*</Col>*/}

                <div className="container">
                    <div className="d-flex justify-content-end">
                        <div className="p-1">
                            <Button variant="primary">
                                Loggin
                            </Button>
                        </div>
                        <div className="p-1">
                            <Button variant="secondary">
                                Registrera dig
                            </Button>
                        </div>
                    </div>
                </div>

            </Container>

        </>
    );
}

export default LoginButton2;