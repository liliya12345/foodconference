import React from "react";
import Search from "./Search";
import Hero from "./Hero";
import Features from "./Features";
import Shop2 from "./Shop2";

import Footer from "./Footer";
import Copyright from "./Copyright";
import Banner from "./Banner";
import MyNavbar3 from "./MyNavbar3";

export default function Home() {
    return (
        <>
            <MyNavbar3/>
            <Search/>
            <Hero/>
            <Features/>
            <Shop2/>
            <Banner/>
            <Footer/>
            <Copyright/>

            {/*<BootstrapTraning/>*/}
        </>
    );
}
