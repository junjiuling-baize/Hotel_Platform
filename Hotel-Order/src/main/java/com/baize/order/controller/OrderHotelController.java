package com.baize.order.controller;

import com.baize.model.dto.OrderDTO;
import com.baize.model.dto.RoomDTO;
import com.baize.order.service.OrderHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 酒店订单服务接口
 */
@RestController
@RequestMapping("/hotel")
public class OrderHotelController {
    @Autowired
    private OrderHotelService orderHotelService;

    /**
     * 根据订单号查询订单
     *
     * @param orderId 订单号
     * @return 返回订单数据
     */
    @GetMapping("/{orderId}")
    public OrderDTO getHotelOrderByOrderId(@PathVariable String orderId) {
        return orderHotelService.getById(orderId);
    }


    /**
     * 根据酒店id查询该酒店的平台订单
     *
     * @param hotelId 酒店id
     * @return 返回订单数据集
     */
    @GetMapping("/hotel/{hotelId}")
    public List<OrderDTO> getHotelOrderByHotelId(@PathVariable String hotelId) {

        return orderHotelService.getHotelOrder(hotelId);
    }

    /**
     * 订单的生成
     *
     * @param RoomDTOList 房间 信息集
     * @Param UserDto 用户信息
     */
    @PostMapping("/createOrder")
    public void createOrder(@RequestBody List<RoomDTO> RoomDTOList, @RequestBody OrderDTO UserDto) {
        String orderId = orderHotelService.addOrder(RoomDTOList, UserDto);
        //TODO 后续添加订单生成
    }

}
