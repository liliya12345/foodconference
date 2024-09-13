import React from "react";
import Search from "./Search";
import Hero from "./Hero";
import Features from "./Features";
import Shop from "./Shop";
import Footer from "./Footer";
import Copyright from "./Copyright";
import Banner from "./Banner";
import Bestsaler from "./Bestsaler";
import FactStart from "./FactStart";
import Tastimonial from "./Tastimonial";
import MyNavbar2 from "./MyNavbar2";

export default function Home() {
    return (
        <>
            <MyNavbar2/>
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
