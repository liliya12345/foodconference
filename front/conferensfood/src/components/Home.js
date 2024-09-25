import React from "react";
import Hero from "./Hero";
import Features from "./Feature/Features";
import Shop2 from "./Shop2";

import Footer from "./Footer";
import Copyright from "./Copyright";
import Banner from "./Feature/Banner";
import MyNavbar3 from "./MyNavbar3";
import ReactTraining from "./reactTraining";

export default function Home() {
    return (
        <>
            <MyNavbar3/>
            <Hero/>
            <Features/>
            <Shop2/>
            <Banner/>
            <Footer/>
            <ReactTraining/>
            <Copyright/>

            {/*<BootstrapTraning/>*/}
        </>
    );
}
