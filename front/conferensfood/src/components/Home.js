import React from "react";
import MyNavbar from "./MyNavbar";
import Search from "./Search";
import Hero from "./Hero";
import Features from "./Features";
import Shop from "./Shop";
import Footer from "./Footer";
import Copyright from "./Copyright";
import FreshOrganicShop from "./FreshOrganicShop";
import Banner from "./Banner";
import OrganicShop from "./OrganicShop";
import Bestsaler from "./Bestsaler";
import FactStart from "./FactStart";
import Tastimonial from "./Tastimonial";

export default function Home() {
    return (
        <>
            <MyNavbar/>
            <Search/>
            <Hero/>
            <Features/>
            <Shop/>
            {/*<OrganicShop/>*/}
            <Banner/>
            <Bestsaler/>
            <FactStart/>
            <Tastimonial/>
            <Footer/>
            <Copyright/>
        </>
    );
}
