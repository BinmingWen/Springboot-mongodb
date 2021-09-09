package com.borui.mongodb.controller;

import com.borui.mongodb.entities.JsonResult;
import com.borui.mongodb.entities.User;
import com.borui.mongodb.service.UserService;
import com.borui.mongodb.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @class: com.borui.mongodb.controller.UserController
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/7 15:27
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUserById")
    public JsonResult<User> getUserById(String id) {
        JsonResult<User> jsonResult = new JsonResult<>();
        User user = userService.selectOne(id);
        jsonResult.setData(user);
        jsonResult.setSuccess(true);
        jsonResult.setMessage("操作成功");
        return jsonResult;
    }

    @PostMapping("/addUser")
    public JsonResult addUser(User user) {
        JsonResult jsonResult = new JsonResult<>();
        user.setCreatTime(new Date());
        user.setLastUpdateTime(new Date());
        User u = userService.insert(user);
        if (u != null ) {
            jsonResult.setMessage("添加数据成功");
            jsonResult.setSuccess(true);
        }
        jsonResult.setSuccess(false);
        jsonResult.setMessage("添加数据失败");
        return jsonResult;
    }

    @GetMapping("/Hello")
    public String helloMongodb() {
        return "Hello mongodb";
    }
    @GetMapping("/getUsers")
    public JsonResult<List<User>> getUsers() {
        JsonResult<List<User>> jsonResult = new JsonResult<>();
        List<User> userList = userService.selectAll();
        if (userList.size() > 0) {
            jsonResult.setSuccess(true);
            jsonResult.setMessage("操作成功!");
            jsonResult.setData(userList);
        } else {
            jsonResult.setMessage("操作失败");
            jsonResult.setSuccess(false);
        }
        return jsonResult;
    }

    @GetMapping("/getUsersByUsername")
    public JsonResult<List<User>> getUsersByUsername(String name) {
        JsonResult<List<User>> jsonResult = new JsonResult<>();
        Query query = new Query(Criteria.where("name").is(name));
        //Class<User> userClass = User.class;
        List<User> users = userService.queryAll(query,User.class);
        if (users.size() > 0) {
            jsonResult.setSuccess(true);
            jsonResult.setMessage("操作成功");
            jsonResult.setData(users);
        } else {
            jsonResult.setSuccess(false);
            jsonResult.setMessage("操作失败！");
        }
        return jsonResult;
    }

    @PostMapping("/updateUser")
    public JsonResult updateUser(User user) {
        userService.updateUser(user);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMessage("操作成功！");
        return jsonResult;
    }
    @PostMapping("/page")
    public Page page(User user,
                     @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                     @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                     HttpServletRequest req) {
        return userService.queryPage(pageNo,pageSize,user);

    }


}
