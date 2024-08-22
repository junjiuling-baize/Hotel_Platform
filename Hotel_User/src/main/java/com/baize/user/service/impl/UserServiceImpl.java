package com.baize.user.service.impl;

import com.baize.model.dto.UserDTO;
import com.baize.user.mapper.UserMapper;
import com.baize.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDTO> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        UserDTO user = userMapper.selectOne(new LambdaQueryWrapper<UserDTO>().eq(UserDTO::getUserPhone, userDTO.getUserPhone()));
        if (user != null) {
            return user;
        }
        userMapper.insert(userDTO);
        return userDTO;
    }

}
