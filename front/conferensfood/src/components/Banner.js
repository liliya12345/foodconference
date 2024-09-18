import React from 'react';

function Banner(props) {
    return (
        <div className="container-fluid banner bg-secondary mt-5">
            <div className="container py-5">
                <div className="row g-4 align-items-center">
                    <div className="col-lg-12 ">
                        <div className="py-4">
                            <h3 className="display-5 text-white ">Vi jobbar för att leverera inte bara mat</h3>
                            <p className="fw-normal display-6 text-dark mb-4">för företagskunder och privata personer</p>
                            <p className="mb-4 text-dark">The generated Lorem Ipsum is therefore always free from repetition injected humour, or non-characteristic words etc.</p>
                            <a href="#" className="banner-btn btn border-2 border-white rounded-pill text-dark py-3 px-5">Hör av dig!!</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    );
}

export default Banner;