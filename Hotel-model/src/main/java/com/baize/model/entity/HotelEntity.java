package com.baize.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "商户实体类")
public class HotelEntity implements Serializable {

    @ApiModelProperty(value = "商户id")
    private Integer hotelId;
    @ApiModelProperty(value = "商户名称")
    private String hotelName;
    @ApiModelProperty(value = "商户手机号")
    private String hotelPhone;
    @ApiModelProperty(value = "商户地址")
    private String hotelAddress;
    @ApiModelProperty(value = "商户备注")
    private String hotelRemark;
    @ApiModelProperty(value = "商户状态")
    private String status;
    @ApiModelProperty(value = "商户入平台时间")
    private String createTime;
}
