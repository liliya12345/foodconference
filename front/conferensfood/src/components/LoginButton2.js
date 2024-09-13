import React from 'react';
import {Button, Container} from "react-bootstrap";

function LoginButton2(props) {
    return (
        <>
            <Container>
                <div className="row justify-content-end">
                    <div className="col">
                        <Button variant="secondary" className="mx-2">
                            Close
                        </Button>
                    </div>
                    <div className="col">
                        <Button variant="primary">
                            Logga in
                        </Button>
                    </div>
                </div>



            </Container>

        </>
    );
}

export default LoginButton2;