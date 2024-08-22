package com.baize.user.service;

import com.baize.model.dto.UserDTO;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<UserDTO> {
    UserDTO registerUser(UserDTO userDTO);

}
