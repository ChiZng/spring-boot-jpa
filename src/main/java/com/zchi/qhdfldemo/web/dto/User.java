//package com.zchi.qhdfldemo.web.dto;
//
//import com.fasterxml.jackson.annotation.JsonView;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Past;
//import java.util.Date;
//
//@Getter
//@Setter
//@ToString
//public class User {
//
//    public interface UserSimpleView { };
//
//    public interface UserDetailView extends UserSimpleView { };
//
//    public interface Create{};
//
//    public interface UpdateAndDelete{};
//
//
//    @JsonView(UserSimpleView.class)
//    @NotBlank(message = "id不能为空", groups = UpdateAndDelete.class)
//    private String id;
//
//    //    @MyConstraint(message = "这是一个测试")
//    @ApiModelProperty(value = "用户名")
//    private String username;
//
//    @NotBlank(message = "密码不能为空")
//    @JsonView(UserDetailView.class)
//    private String password;
//
//    //    @Past(message = "生日必须是过去的时间")
////    @JsonView(UserSimpleView.class)
////    private Date birthday;
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public User(){}
//}
