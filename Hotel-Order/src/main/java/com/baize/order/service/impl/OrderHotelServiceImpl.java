package com.baize.order.service.impl;

import com.baize.model.dto.OrderDTO;
import com.baize.model.dto.RoomDTO;
import com.baize.order.mapper.OrderHotelMapper;
import com.baize.order.service.OrderHotelService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHotelServiceImpl extends ServiceImpl<OrderHotelMapper, OrderDTO> implements OrderHotelService {
    @Autowired
    private OrderHotelMapper orderHotelMapper;

    //TODO 后续添加分页
    @Override
    public List<OrderDTO> getHotelOrder(String hotelId) {
        return orderHotelMapper.selectList(new LambdaQueryWrapper<OrderDTO>().eq(OrderDTO::getHotelId, hotelId));
    }

    /**
     * //生成订单
     *
     * @param roomDTO 房间 信息
     * @param userDto
     * @return
     */
    @Override
    public String addOrder(RoomDTO roomDTO, OrderDTO userDto) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(userDto.getUserId());
        orderDTO.setHotelId(roomDTO.getHotelId());
        orderDTO.setRoomDTO(roomDTO);
        orderDTO.setOrderStatus("待支付");
        orderDTO.setRoomType("实体店");
        orderDTO.setOrderRemark(userDto.getOrderRemark());
        orderHotelMapper.insert(orderDTO);
        return orderDTO.getOrderId();
    }

    /**
     * @param orderId 订单id
     * @return
     */
    public void deleteOrder(String orderId) {
        orderHotelMapper.deleteById(orderId);
//        TODO 后续添加返回
    }
}
