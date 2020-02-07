package com.zchi.qhdfldemo.service.Impl;

import com.zchi.qhdfldemo.model.UserDbModel;
import com.zchi.qhdfldemo.repository.UserRepository;
import com.zchi.qhdfldemo.service.UserService;
import com.zchi.qhdfldemo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户操作service实现
 * @author: zchi
 * @create: 2020-02-07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // 将dto转化为dbModel
        UserDbModel userDbModel = new UserDbModel();
        userDbModel.setUsername(userDto.getUsername());
        userDbModel.setPassword(userDbModel.getPassword());
        userRepository.save(userDbModel);
        UserDto userDtoRes = new UserDto();
        userDtoRes.setId(userDbModel.getId());
        userDtoRes.setUsername(userDbModel.getUsername());
        return userDtoRes;
    }
}
