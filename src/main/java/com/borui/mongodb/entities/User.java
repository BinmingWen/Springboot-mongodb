package com.borui.mongodb.entities;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @class: com.borui.mongodb.entities.User
 * @description: user实体类
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/7 14:46
 */

@Document("user")
@Data
public class User {
    @Id
    private String id;
    @Field("name")
    @Excel(name = "用户名",width = 20)
    private String name;
    @Field("password")
    @Excel(name = "用户密码",width = 20)
    private String password;
    @Field("address")
    @Excel(name = "地址",width = 20)
    private String address;
    @Field("creat_time")
    @Excel(name = "创建时间",width = 20,format = "yyy-MM-dd HH:mm:ss")
    private Date creatTime;
    @Field("last_update_time")
    @Excel(name = "更新时间",width = 20,format = "yyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
