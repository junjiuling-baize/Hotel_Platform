package com.baize.order.mapper;

import com.baize.model.dto.OrderDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderHotelMapper extends BaseMapper<OrderDTO> {
}
