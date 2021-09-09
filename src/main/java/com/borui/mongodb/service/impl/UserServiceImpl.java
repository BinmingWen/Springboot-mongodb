package com.borui.mongodb.service.impl;

import com.borui.mongodb.common.BaseServiceImpl;
;
import com.borui.mongodb.entities.User;
import com.borui.mongodb.service.UserService;
import com.borui.mongodb.utils.Page;
import com.borui.mongodb.utils.PagesUtils;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @class: com.borui.mongodb.service.impl.UserServiceImpl
 * @description: UserService接口实现类
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/7 15:14
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page queryPage(int pageNo, int pageSize, User user) {
        Query query = new Query();
        //Criteria criteria = new Criteria();
        Page page = new com.borui.mongodb.utils.Page();
        page.setSize(pageSize);
        page.setCurrent(pageNo);
        List<User> users = new ArrayList<>();
        if (user != null) {
            if (user.getId() != null && !user.getId().equals("")) {
                Criteria criteria = Criteria.where("_id").is(user.getId());
                query.addCriteria(criteria);
            }
            if (user.getName() != null && !user.getName().equals("")) {
                //使用模糊查询
                Pattern pattern=Pattern.compile("^.*"+user.getName()+".*$", Pattern.CASE_INSENSITIVE);
                query.addCriteria(Criteria.where("name").regex(pattern));
            }
            if (user.getAddress() != null && !user.getAddress().equals("")) {
                Criteria criteria = Criteria.where("address").is(user.getAddress());
                query.addCriteria(criteria);
            }
            if (user.getPassword() != null && !user.getPassword().equals("")) {
                Criteria criteria = Criteria.where("password").is(user.getPassword());
                query.addCriteria(criteria);
            }

            users = mongoTemplate.find(query, User.class);
        } else {
            users = mongoTemplate.findAll(User.class);
        }
        PagesUtils<User> pagesUtils = new PagesUtils<>();
        Page newPage = pagesUtils.getPage(users, page);
        return newPage;
    }

    @Override
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("_id").is(user.getId()));
        Update update = new Update().set("name",user.getName()).set("password",user.getPassword()).set("address",user.getAddress())
                .set("creat_time",new Date()).set("last_update_time",new Date());
        mongoTemplate.updateFirst(query,update,User.class);


    }
   /* @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public int saveUser(User user) {
        if (user != null) {
            userRepository.insert(user);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteUserById(String id) {
        if (id != null) {
            userRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public void updateUser(User user) {
        if (user != null) {
            //userRepository.
        }
    }

    @Override
    public User findById(String id) {
        if (id != null) {
            User user = userRepository.findById(id).get();
            return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


   @Override
   public List<User> queryByUser(String name) {

       Query query = new Query(Criteria.where("name").is(name));
      // Criteria criteria = new Criteria();
       //criteria.where("name").is(name);
       //query.addCriteria(criteria);
       List<User> users = mongoTemplate.find(query, User.class);
       return users;
   }*/
}
