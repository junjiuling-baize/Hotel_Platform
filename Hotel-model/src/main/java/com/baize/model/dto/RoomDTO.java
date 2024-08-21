package com.baize.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("room")
public class RoomDTO implements Serializable {
    @TableId("room_id")
    private Integer roomId;
    @TableField(value = "room_name")
    private String roomName;
    @TableField(value = "room_price")
    private Double roomPrice;
    @TableField(value = "status")
    private String status;
    @TableField(value = "room_type")
    private String roomType;
    @TableField(value = "hotel_id")
    private Integer hotelId;
    @TableField(value = "remark")
    private String remark;

}
