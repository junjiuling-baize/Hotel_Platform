package com.baize.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("hotel")
public class HotelDTO implements Serializable {

    @TableId("id")
    private Integer hotelId;

    @TableField(value = "hotel_name")
    private String hotelName;

    @TableField(value = "hotel_phone")
    private String hotelPhone;

    @TableField(value = "hotel_address")
    private String hotelAddress;

    @TableField(value = "hotel_remark")
    private String hotelRemark;

    @TableField(value = "status")
    private String status;

    @TableField(value = "createTime")
    private String createTime;
}
