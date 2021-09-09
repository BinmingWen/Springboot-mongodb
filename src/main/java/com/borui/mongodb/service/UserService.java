package com.borui.mongodb.service;

import com.borui.mongodb.common.BaseService;
import com.borui.mongodb.entities.User;

import com.borui.mongodb.utils.Page;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @class: com.borui.mongodb.service.UserService
 * @description: 定义User接口操作类方法
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/7 15:14
 */

public interface UserService extends BaseService<User> {
    /**
     * 增
     * @return
     *//*
    int saveUser(User user);

    *//**
     * 删
     * @return
     *//*
    int deleteUserById(String id);

    *//**
     * 改
     *//*
    void updateUser(User user);

    *//**
     * 查
     * @param id
     *//*
    User findById(String id);

    *//**
     * 查询所有
     * @return
     *//*
    List<User> findAll();

    List<User> queryByUser(String name);

    List<User> queryByUser(String name);*/
    Page queryPage(int pageNo, int pageSize, User user);
    void updateUser(User user);

}
