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
     * @param RoomDTOList 房间信息集
     * @param userDto
     * @return
     */
    @Override
    public String addOrder(List<RoomDTO> RoomDTOList, OrderDTO userDto) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(userDto.getUserId());
        orderDTO.setHotelId(RoomDTOList.get(0).getHotelId());
        orderDTO.setRoomList(RoomDTOList);
        orderDTO.setRoomType("实体店");
        orderDTO.setOrderRemark(userDto.getOrderRemark());
        orderHotelMapper.insert(orderDTO);
        return "";
    }
}
