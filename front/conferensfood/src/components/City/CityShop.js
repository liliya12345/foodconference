import React from 'react';
import Shop3 from "../Shop3";
import Bonus from "../Bonus";

function CityShop(props) {
    return (

        <div className="container-fluid ">
            <div className="row ">
            </div>
            <div className="row">

                <div className="col-xl-2 col-md-2  col-sm-12 text-options py-5 ">
                    <div className="container ">
                        <div className="row">
                            <div className="col-12 text-options">
                                <div className="text-options-second p-2">Sortera efter</div>
                                <div className="row">
                                    <div className="form-check">
                                        <ul className=" nav nav-pills d-inline-flex">
                                            <li className="nav-item2 col-sm-12 p-1">
                                                <div className="form-check">
                                                    <input className="form-check-input" type="radio"
                                                           name="flexRadioDefault" id="flexRadioDefault1"/>
                                                    <label className="form-check-label"
                                                           htmlFor="flexRadioDefault1">
                                                        Standard
                                                    </label>
                                                </div>
                                            </li>
                                            <li className="nav-item2 col-sm-12 p-1">
                                                <div className="form-check">
                                                    <input className="form-check-input" type="radio"
                                                           name="flexRadioDefault" id="flexRadioDefault1"/>
                                                    <label className="form-check-label"
                                                           htmlFor="flexRadioDefault1">
                                                        Pris
                                                    </label>
                                                </div>
                                            </li>
                                            <li className="nav-item2 col-sm-12 p-1">
                                                <div className="form-check">
                                                    <input className="form-check-input" type="radio"
                                                           name="flexRadioDefault" id="flexRadioDefault1"/>
                                                    <label className="form-check-label"
                                                           htmlFor="flexRadioDefault1">
                                                        Avstånd
                                                    </label>
                                                </div>
                                            </li>
                                            <li className="nav-item2 col-sm-12 p-1">
                                                <div className="form-check">
                                                    <input className="form-check-input" type="radio"
                                                           name="flexRadioDefault" id="flexRadioDefault1"/>
                                                    <label className="form-check-label"
                                                           htmlFor="flexRadioDefault1">
                                                        Snabbt leverans
                                                    </label>
                                                </div>
                                            </li>

                                        </ul>
                                    </div>


                                </div>


                            </div>


                        </div>

                    </div>
                </div>
                <div className="col-xl-10 col-md-10 col-sm-12 ">
                    <Bonus/>
                    <Shop3/>
                </div>
            </div>

        </div>

    );
}

export default CityShop;