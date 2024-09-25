import React from 'react';
import bonus1 from "../img/bonus1.png";
import bonus2 from "../img/bonus2.png";
import bonus3 from "../img/bonus3.png";

function Bonus(props) {
    return (
        <div>
            <div className="container-fluid">
                    <div className="row g-4">
                        <div className="col-lg-12">
                            <div className="row g-4 p-5">
                                <div className="col-lg-12 text-center">Dina erbjdande</div>
                            </div>
                            <div className="row g-4">
                                <div className="col-12 container-fluid px-5" >
                                    <ul className="nav2 nav-pills2 d-inline-flex p-0">
                                        <li className="nav-item col-2">
                                            <img src={bonus1} className="w-75"/>
                                        </li>
                                        <li className="nav-item col-2">
                                            <img src={bonus2} className="w-75"/>
                                        </li>
                                        <li className="nav-item col-2">
                                            <img src={bonus2} className="w-75"/>
                                        </li>
                                        <li className="nav-item col-2">
                                            <img src={bonus2} className="w-75"/>
                                        </li>

                                        <li className="nav-item col-2 ">
                                            <img src={bonus3} className="w-75"/>
                                        </li>
                                        <li className="nav-item col-2 ">
                                            <img src={bonus1} className="w-75"/>
                                        </li>
                                        <li className="nav-item col-2 ">
                                            <img src={bonus1} className="w-75"/>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>
            </div>
        </div>
);
}

export default Bonus;