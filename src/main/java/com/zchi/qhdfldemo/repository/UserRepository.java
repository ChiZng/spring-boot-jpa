package com.zchi.qhdfldemo.repository;

import com.zchi.qhdfldemo.model.UserDbModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 用户数据层操作
 * @author: zchi
 * @create: 2020-02-07
 */
public interface UserRepository extends JpaRepository<UserDbModel, Long> {
}
