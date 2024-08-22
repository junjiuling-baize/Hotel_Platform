package com.baize.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "用户实体类")
public class UserDTO implements Serializable {
    //    用户id
    @TableId(value = "user_id")
    private Integer userId;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "real_name")
    private String realName;
    @TableField(value = "user_phone")
    private String UserPhone;
    @TableField(value = "avatar")
    private String avatar;
    @TableField(value = "password")
    private String password;
    @TableField(value = "role")
    private String role;
    @TableField(value = "status")
    private String status;
    @TableField(value = "user_remark")
    private String UserRemark;
    @TableField(value = "create_time")
    private String createTime;
    @TableField(value = "update_time")
    private String updateTime;
}
