package com.baize.order.service;

import com.baize.model.dto.OrderDTO;

import com.baize.model.dto.RoomDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OrderHotelService extends IService<OrderDTO> {
    List<OrderDTO> getHotelOrder(String hotelId);

    String addOrder(RoomDTO  roomDTO, OrderDTO userDto);
}
