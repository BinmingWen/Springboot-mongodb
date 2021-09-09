package com.borui.mongodb.common;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @class: com.borui.mongodb.common.BaseServiceImpl
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/8 10:20
 */


public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoRepository<T,String> mongoRepository;

    /**
     * 创建一个 Class 的对象来获取泛型的 Class
     */
    private Class<T> clazz ;

    public Class<T> getClazz() {
        if (clazz == null) {
            clazz = ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        }
        return clazz;
    }



    @Override
    public T selectOne(String id) {
        Optional<T> byId = mongoRepository.findById(id);
        return byId.orElse(null);
    }


    @Override
    public T insert(T t) {
        T save = mongoRepository.save(t);
        return save;
    }



    @Override
    public void removeById(String[] ids) {
        for (String id : ids) {
            mongoRepository.deleteById(id);
        }
    }

    @Override
    public void removeById(String id) {
        mongoRepository.deleteById(id);

    }

    @Override
    public List<T> selectAll() {
        List<T> all = mongoRepository.findAll();
        return all;
    }

    @Override
    public List<T> queryAll(Query query,Class<T> c) {
        List<T> list = mongoTemplate.find(query, c);
        return list;
    }

    @Override
    public T queryOne(Query query,Class<T> c) {
        T t = mongoTemplate.findOne(query, c);
        return t;
    }
}
