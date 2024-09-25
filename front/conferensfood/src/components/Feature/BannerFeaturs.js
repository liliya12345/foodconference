import React from 'react';

export default function BannerFeaturs(props) {
    return (
        <div className=" col-md-6 col-lg-3">
            <div className="featurs-item text-center rounded">
                <div className="featurs-icon btn-square rounded-circle bg-secondary mb-4 mx-auto">
                    <i className={props.icon}></i>
                </div>
                <div className="featurs-content text-center">
                    <h6>{props.title}</h6>
                    <p className="mb-2">{props.description}</p>
                </div>
            </div>
        </div>
    );
}

