import React from 'react'
import {banners} from "./banners";
import BannerFeaturs from "./BannerFeaturs";

export default function Features(props) {
  return (
    <div className="container-fluid featurs py-4 ">
            <div className="container py-4">
                <div className="row g-4">
                    {banners.map((banner)=>(<BannerFeaturs{...banner}/>))}
                </div>
            </div>
        </div>
  )
}
