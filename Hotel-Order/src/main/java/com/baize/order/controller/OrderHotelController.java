package com.baize.order.controller;

import com.baize.order.service.OrderHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class OrderHotelController {
    @Autowired
    private OrderHotelService orderHotelService;

    @GetMapping("/{hotelId}")
    public String getHotelOrder(@PathVariable String hotelId) {
//        orderHotelService.getHotelOrder(hotelId);
        return "hotelId:" + hotelId;
    }
}
