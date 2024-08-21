package com.baize.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "订单实体类")
public class OrderEntity {
    @ApiModelProperty(value = "订单id")
    private String orderId;
    @ApiModelProperty(value = "订单创建时间")
    private String createTime;
    @ApiModelProperty(value = "订单备注")
    private String orderRemark;
    @ApiModelProperty(value = "订单状态 /支付情况")
    private String orderStatus;
    @ApiModelProperty(value = "订单用户id")
    private Integer userId;
    @ApiModelProperty(value = "订单酒店id")
    private Integer hotelId;
    @ApiModelProperty(value = "订单房间类型 /网定或柜台")
    private String roomType;
    @ApiModelProperty(value = "总金额")
    private Double totalPrice;
    @ApiModelProperty(value = "房间集")
    private List<RoomEntity> roomList;

}
