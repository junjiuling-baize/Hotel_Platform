package com.baize.hotelrecption.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelOrder {
    //    查询酒店的订单情况

    /**
     * @api {GET} /hotel/getHotelOrder 查询酒店的订单情况
     * @param hotelId   酒店id
     * @return
     */
    @GetMapping("/")
    public String getHotelOrder(String hotelId) {
        return "hotelOrder";
    }
}
