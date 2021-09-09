package com.borui.mongodb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @class: com.borui.mongodb.entities.JsonResult
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/7 14:51
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    private static final int NO_LOGIN = 400 ;
    private static final int LOGIN_FAILED = 401;
    private static final int TOKEN_EXPIRED = 402;
    private static final int NO_PERMISSION=403;

    private Boolean success;
    private Integer code;
    private String message;
    private T data;

    public JsonResult(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
