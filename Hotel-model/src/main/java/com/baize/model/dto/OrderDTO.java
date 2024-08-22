package com.baize.model.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


@Data
@TableName("t_order")
public class OrderDTO {
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    private String orderId;

    @TableField(value = "create_time")
    private String createTime;

    @TableField(value = "order_remark")
    private String orderRemark;

    @TableField(value = "order_status")
    private String orderStatus;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "hotel_id")
    private Integer hotelId;

    @TableField(value = "room_type")
    private String roomType;

    @TableField(value = "total_price")
    private Double totalPrice;

    @TableLogic
    @TableField(value = "is_exist")
    private Integer isExist;

    @TableField(exist = false)
    private RoomDTO roomDTO;
}
