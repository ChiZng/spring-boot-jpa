package com.zchi.qhdfldemo.model.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description: 公共属性
 * @author: zchi
 * @create: 2020-02-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass //表明这是父类，可以将属性映射到子类中使用JPA生成表
@DynamicUpdate //动态赋值
@DynamicInsert //动态插入
public class BaseDbModel implements Serializable {

    @JSONField(ordinal = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int(30)")
    @ApiModelProperty(value = "自增主键")
    protected Integer id; //自增主键

    @JSONField(ordinal = 2, format = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @OrderBy("DESC")
    @Column(name = "create_time", columnDefinition = "DATETIME")
    @JsonFormat
    @ApiModelProperty(value = "创建时间")
    protected Date createTime;

    @JSONField(ordinal = 2, format = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    @Column(name = "modify_name", columnDefinition = "DATETIME")
    @JsonFormat
    @OrderBy("DESC")
    @ApiModelProperty(value = "修改时间")
    protected Date modifyTime;

    @JSONField(ordinal = 3, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat
    @Column(name = "destroy_name", columnDefinition = "DATETIME")
    @ApiModelProperty(value = "销毁时间")
    protected Date destroyTime;


    @JSONField(ordinal = 4)
    @Version
    @Column(nullable = false, columnDefinition = "int(20)")
    protected Integer version;
}
