package com.borui.mongodb.dao;

import com.borui.mongodb.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @class: com.borui.mongodb.dao.UserRepository
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/7 15:12
 */

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
