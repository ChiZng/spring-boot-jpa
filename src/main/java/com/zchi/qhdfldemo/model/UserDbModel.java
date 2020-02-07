package com.zchi.qhdfldemo.model;

import com.zchi.qhdfldemo.model.common.BaseDbModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @description: 用户表
 * @author: zchi
 * @create: 2020-02-07
 */
@Data
@Setter
@Entity
@Table(name = "user")
public class UserDbModel extends BaseDbModel implements Serializable {

    private static final long serialVersionUID = 5072086687425694514L;

    @Column
    @ApiModelProperty(value = "账号")
    private String username;

    @Column
    @ApiModelProperty(value = "密码")
    private String password;

    @Column
    @ApiModelProperty(value = "头像")
    private String icon;

    @Column
    @ApiModelProperty(value = "邮箱")
    private String email;

    @Column(name = "nick_name")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @Column
    @ApiModelProperty(value = "备注")
    private String note;

    @Column
    @ApiModelProperty(value = "启用状态： 0-禁用；1-启用")
    private int status;

    @Column(name = "login_name")
    @ApiModelProperty(value = "最后登录时间")
    private Date loginName;
}
