import React from 'react'


export default function CityComponetInfo(props) {
    return (

        <div className="col-md-6 col-lg-4 col-xl-3 h-25">
            <div className="rounded position-relative fruite-item">
                <div className="fruite-img">
                    <img src={props.img}
                         className="img-fluid w-100 rounded-top " alt={"image"}/>
                </div>
                <div
                    className="text-white bg-secondary px-3 py-1 rounded position-absolute"
                    style={{top: "10px", left: "10px"}}
                >
                    {props.star}
                </div>
                <div
                    className="p-4 border border-secondary border-top-0 rounded-bottom">
                    <h4>{props.title}</h4>
                    <p>
                        {props.description}
                    </p>

                </div>
            </div>
        </div>

    );
}
