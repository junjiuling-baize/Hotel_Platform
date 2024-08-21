package com.baize.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用户实体类")
public class UserEntity implements Serializable {
    //    用户id
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "真实名称")
    private String realName;
    @ApiModelProperty(value = "用户手机号")
    private String UserPhone;
    @ApiModelProperty(value = "用户头像")
    private String avatar;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户角色")
    private String role;
    @ApiModelProperty(value = "用户状态")
    private String status;
    @ApiModelProperty(value = "用户备注")
    private String UserRemark;
    @ApiModelProperty(value = "用户创建时间")
    private String createTime;
    @ApiModelProperty(value = "用户更新时间")
    private String updateTime;
}
