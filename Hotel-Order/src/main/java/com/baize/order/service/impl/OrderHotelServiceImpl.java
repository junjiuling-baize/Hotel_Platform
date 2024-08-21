package com.baize.order.service.impl;

import com.baize.model.dto.OrderDTO;
import com.baize.order.mapper.OrderHotelMapper;
import com.baize.order.service.OrderHotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderHotelServiceImpl extends ServiceImpl<OrderHotelMapper, OrderDTO> implements OrderHotelService {

}
