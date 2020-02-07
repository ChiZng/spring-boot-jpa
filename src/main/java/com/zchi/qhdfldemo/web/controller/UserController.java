package com.zchi.qhdfldemo.web.controller;

import com.zchi.qhdfldemo.entity.Result;
import com.zchi.qhdfldemo.model.UserDbModel;
import com.zchi.qhdfldemo.service.UserService;
import com.zchi.qhdfldemo.web.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "UserController", description = "RestTemplate示例")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="登录")
    @PostMapping("/login")
    public Result<UserDto> login(@Validated @RequestBody UserDto userdto){
        UserDto userDtoRes = userService.createUser(userdto);
        return new Result<UserDto>("200", "success", userDtoRes);
    }
}
