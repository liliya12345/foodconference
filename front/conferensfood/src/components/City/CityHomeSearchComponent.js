import React from 'react';

function CityHomeSearchComponent(props) {
    return (
        <div className="container-fluid py-5">
                <div className="container your-place">
                    <div className="row g-5 align-items-center">
                        <div className="col-12 text-start pl-4 " >
                            <i className="fas fa-map-marker-alt me-2 text-secondary "></i>{" "}
                            Ny adress Kungstorget 6, 252 24 Helsingborg
                        </div>
                    </div>
                </div>
                <div className="container-fluid search-container">
                    <div className="row g-5 align-items-center mt-1">
                        <div className="col-12  ">
                            <div className="position-relative mx-auto du search-city">
                                <input className="form-control  border-2 border-secondary search-city-text  rounded-pill"
                                       type="search" placeholder="Sök efter restaraugen eller adressen"/>
                                <button type="submit"
                                        className="btn btn-primary border-2 border-secondary search-city-text px-4 position-absolute rounded-pill text-white h-100"
                                        style={{top: "0", right: "0"}}>Sök
                                </button>
                            </div>
                        </div>
                    </div>
                </div>


        </div>
    );
}

export default CityHomeSearchComponent;