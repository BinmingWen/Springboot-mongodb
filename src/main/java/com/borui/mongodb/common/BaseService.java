package com.borui.mongodb.common;


import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @class: com.borui.mongodb.common.BaseService
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/8 10:10
 */


public interface BaseService<T> {

    /**
     * 根据id插叙数据
     * @param id
     * @return
     */
    T selectOne(String id);

    /**
     * 新增数据
     * @param t
     * @return
     */
    T insert(T t);

    /**
     * 删除数据
     * @param id
     */
    void removeById(String id);

    /**
     * 批量删除
     * @param ids
     */
    void removeById(String[] ids);

    /**
     * 查询所有数据
     * @return
     */
    List<T> selectAll();


    /**
     * 查询符合条件的所有列表数据
     * @param query
     * @return
     */
    List<T> queryAll(Query query,Class<T> c);

    /**
     * 查询符合条件的某一个对象
     * @param query
     * @return
     */
    T queryOne(Query query,Class<T> c);

}
