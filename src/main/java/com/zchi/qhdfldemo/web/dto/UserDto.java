package com.zchi.qhdfldemo.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class UserDto {

    public interface Create{};

    public interface UpdateAndDelete{};

    @NotBlank(message = "id不能为空", groups = UpdateAndDelete.class)
    private Integer id;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "账号")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    public UserDto(){}

    public UserDto(String username, String password){
        this.username = username;
        this.password = password;
    }
}
