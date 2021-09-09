package com.borui.mongodb.controller;

import com.borui.mongodb.entities.User;
import com.borui.mongodb.service.UserService;
import com.borui.mongodb.utils.FileUtil;
import com.borui.mongodb.utils.NormalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @class: com.borui.mongodb.controller.EasyPOIController
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/9 11:08
 */

@RestController
public class EasyPOIController {
    @Autowired
    private UserService userService;

    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws NormalException {
        List<User> users = userService.selectAll();
        FileUtil.exportExcel(users,User.class,"用户表.xls",response);
    }

    @GetMapping("/importExcel")
    public void importExcel() throws NormalException {
        String fileName = "C:\\Users\\Tom\\Downloads\\用户表.xls";
        List<User> userList = FileUtil.importExcel(fileName, 0, 1, User.class);
        for (User user : userList) {
            userService.insert(user);
        }
        System.out.println("插入数据成功！");

    }
}
