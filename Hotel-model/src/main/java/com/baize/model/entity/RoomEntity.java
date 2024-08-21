package com.baize.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "房间实体类")
public class RoomEntity implements Serializable {
    @ApiModelProperty(value = "房间id")
    private Integer roomId;
    @ApiModelProperty(value = "房间名称")
    private String roomName;
    @ApiModelProperty(value = "房间价格")
    private Double roomPrice;
    @ApiModelProperty(value = "房间状态")
    private String status;
    @ApiModelProperty(value = "房间类型/如单双房，")
    private String roomType;
    @ApiModelProperty(value = "酒店id")
    private Integer hotelId;
    @ApiModelProperty(value = "房间描述")
    private String remark;

}
