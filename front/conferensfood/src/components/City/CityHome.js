import React from 'react';
import Banner from "../Feature/Banner";
import Footer from "../Footer";
import Copyright from "../Copyright";
import CityHomeSearchComponent from "./CityHomeSearchComponent";
import MyNavbar2 from "../MyNavbar2";
import CityShop from "./CityShop";


function CityHome(props) {
    return (
        <>
            <MyNavbar2/>
            <CityHomeSearchComponent/>
            <CityShop/>
            <Banner/>
            <Footer/>
            <Copyright/>
        </>
    );
}

export default CityHome;