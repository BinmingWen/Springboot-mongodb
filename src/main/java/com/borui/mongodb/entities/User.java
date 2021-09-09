package com.borui.mongodb.entities;

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
    private String name;
    @Field("password")
    private String password;
    @Field("address")
    private String address;
    @Field("creat_time")
    private Date creatTime;
    @Field("last_update_time")
    private Date lastUpdateTime;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
