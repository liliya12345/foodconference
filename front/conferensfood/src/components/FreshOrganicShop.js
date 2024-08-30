import React from 'react';
import "../lib/owlcarousel/assets/owl.carousel.min.css";

function FreshOrganicShop(props) {
    return (
        <div className="container-fluid vesitable py-5">
            <div className="container py-5">
                <h1 className="mb-0">Fresh Organic Vegetables</h1>
                <div className="owl-carousel vegetable-carousel justify-content-center">
                {/*<Carousel className=" justify-content-center">*/}
                    <div className="border border-primary rounded position-relative vesitable-item">
                        <div className="vesitable-img">
                            <img src="img/vegetable-item-6.jpg" className="img-fluid w-50 rounded-top" alt=""/>
                        </div>
                        <div className="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}}>Vegetable</div>
                        <div className="p-4 rounded-bottom">
                            <h4>Parsely</h4>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                            <div className="d-flex justify-content-between flex-lg-wrap">
                                <p className="text-dark fs-5 fw-bold mb-0">$4.99 / kg</p>
                                <a href="#" className="btn border border-secondary rounded-pill px-3 text-primary"><i className="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                            </div>
                        </div>
                    </div>

                    <div className="border border-primary rounded position-relative vesitable-item">
                        <div className="vesitable-img">
                            <img src="img/vegetable-item-1.jpg" className="img-fluid w-50 rounded-top" alt=""/>
                        </div>
                        <div className="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}} >Vegetable</div>
                        <div className="p-4 rounded-bottom">
                            <h4>Parsely</h4>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                            <div className="d-flex justify-content-between flex-lg-wrap">
                                <p className="text-dark fs-5 fw-bold mb-0">$4.99 / kg</p>
                                <a href="#" className="btn border border-secondary rounded-pill px-3 text-primary"><i className="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                            </div>
                        </div>
                    </div>
                    {/*<div class="border border-primary rounded position-relative vesitable-item">*/}
                    {/*    <div class="vesitable-img">*/}
                    {/*        <img src="img/vegetable-item-3.png" class="img-fluid w-100 rounded-top bg-light" alt=""/>*/}
                    {/*    </div>*/}
                    {/*    <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}}>Vegetable</div>*/}
                    {/*    <div class="p-4 rounded-bottom">*/}
                    {/*        <h4>Banana</h4>*/}
                    {/*        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>*/}
                    {/*        <div class="d-flex justify-content-between flex-lg-wrap">*/}
                    {/*            <p class="text-dark fs-5 fw-bold mb-0">$7.99 / kg</p>*/}
                    {/*            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    {/*<div class="border border-primary rounded position-relative vesitable-item">*/}
                    {/*    <div class="vesitable-img">*/}
                    {/*        <img src="img/vegetable-item-4.jpg" class="img-fluid w-100 rounded-top" alt=""/>*/}
                    {/*    </div>*/}
                    {/*    <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}}>Vegetable</div>*/}
                    {/*    <div class="p-4 rounded-bottom">*/}
                    {/*        <h4>Bell Papper</h4>*/}
                    {/*        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>*/}
                    {/*        <div class="d-flex justify-content-between flex-lg-wrap">*/}
                    {/*            <p class="text-dark fs-5 fw-bold mb-0">$7.99 / kg</p>*/}
                    {/*            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    {/*<div class="border border-primary rounded position-relative vesitable-item">*/}
                    {/*    <div class="vesitable-img">*/}
                    {/*        <img src="img/vegetable-item-5.jpg" class="img-fluid w-100 rounded-top" alt=""/>*/}
                    {/*    </div>*/}
                    {/*    <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}}>Vegetable</div>*/}
                    {/*    <div class="p-4 rounded-bottom">*/}
                    {/*        <h4>Potatoes</h4>*/}
                    {/*        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>*/}
                    {/*        <div class="d-flex justify-content-between flex-lg-wrap">*/}
                    {/*            <p class="text-dark fs-5 fw-bold mb-0">$7.99 / kg</p>*/}
                    {/*            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    {/*<div class="border border-primary rounded position-relative vesitable-item">*/}
                    {/*    <div class="vesitable-img">*/}
                    {/*        <img src="img/vegetable-item-6.jpg" class="img-fluid w-100 rounded-top" alt=""/>*/}
                    {/*    </div>*/}
                    {/*    <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}}>Vegetable</div>*/}
                    {/*    <div class="p-4 rounded-bottom">*/}
                    {/*        <h4>Parsely</h4>*/}
                    {/*        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>*/}
                    {/*        <div class="d-flex justify-content-between flex-lg-wrap">*/}
                    {/*            <p class="text-dark fs-5 fw-bold mb-0">$7.99 / kg</p>*/}
                    {/*            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    {/*<div class="border border-primary rounded position-relative vesitable-item">*/}
                    {/*    <div class="vesitable-img">*/}
                    {/*        <img src="img/vegetable-item-5.jpg" class="img-fluid w-100 rounded-top" alt=""/>*/}
                    {/*    </div>*/}
                    {/*    <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}}>Vegetable</div>*/}
                    {/*    <div class="p-4 rounded-bottom">*/}
                    {/*        <h4>Potatoes</h4>*/}
                    {/*        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>*/}
                    {/*        <div class="d-flex justify-content-between flex-lg-wrap">*/}
                    {/*            <p class="text-dark fs-5 fw-bold mb-0">$7.99 / kg</p>*/}
                    {/*            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    {/*<div class="border border-primary rounded position-relative vesitable-item">*/}
                    {/*    <div class="vesitable-img">*/}
                    {/*        <img src="img/vegetable-item-6.jpg" class="img-fluid w-100 rounded-top" alt=""/>*/}
                    {/*    </div>*/}
                    {/*    <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style={{top: "10px", right:"10px"}}>Vegetable</div>*/}
                    {/*    <div class="p-4 rounded-bottom">*/}
                    {/*        <h4>Parsely</h4>*/}
                    {/*        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>*/}
                    {/*        <div class="d-flex justify-content-between flex-lg-wrap">*/}
                    {/*            <p class="text-dark fs-5 fw-bold mb-0">$7.99 / kg</p>*/}
                    {/*            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                </div>
                {/*</Carousel>*/}
            </div>
        </div>
    );
}

export default FreshOrganicShop;