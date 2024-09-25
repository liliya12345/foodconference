import React from "react";


export default  function AllaKok(props) {
    return (

        <li className="nav-item">
            <div className=" me-3 ">
                <button type="submit"
                        className="btn border border-third rounded-pill px-4 mb-2 text-dark"
                        style={{top: "0", right: "25%"}}> {props.title}
                </button>
            </div>
        </li>
    );
}
