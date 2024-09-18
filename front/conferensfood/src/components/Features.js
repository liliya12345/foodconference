import React from 'react'

export default function Features() {
  return (
    <div className="container-fluid featurs py-4 ">
            <div className="container py-4">
                <div className="row g-4">
                    <div className=" col-md-6 col-lg-3">
                        <div className="featurs-item text-center rounded">
                            <div className="featurs-icon btn-square rounded-circle bg-secondary mb-4 mx-auto">
                                <i className="fas fa-car-side fa-2x text-white"></i>
                            </div>
                            <div className="featurs-content text-center">
                            <h6>Free Shipping</h6>
                                <p className="mb-2">Free on order over $300</p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-6 col-lg-3">
                        <div className="featurs-item text-center rounded">
                            <div className="featurs-icon btn-square rounded-circle bg-secondary mb-4 mx-auto">
                                <i className="fas fa-user-shield fa-2x text-white"></i>
                            </div>
                            <div className="featurs-content text-center">
                                <h6>Security Payment</h6>
                                <p className="mb-2">100% security payment</p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-6 col-lg-3">
                        <div className="featurs-item text-center rounded">
                            <div className="featurs-icon btn-square rounded-circle bg-secondary mb-4 mx-auto">
                                <i className="fas fa-exchange-alt fa-2x text-white"></i>
                            </div>
                            <div className="featurs-content text-center">
                                <h6>30 Day Return</h6>
                                <p className="mb-2">30 day money guarantee</p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-6 col-lg-3">
                        <div className="featurs-item text-center rounded">
                            <div className="featurs-icon btn-square rounded-circle bg-secondary mb-4 mx-auto">
                                <i className="fa fa-phone-alt fa-2x text-white"></i>
                            </div>
                            <div className="featurs-content text-center">
                                <h6>24/7 Support</h6>
                                <p className="mb-2">Support every time fast</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  )
}
