package com.borui.mongodb.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @class: com.borui.mongodb.common.PageData
 * @description: 接收分页数据
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/8 10:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {
    private Long total;
    private List<T> list;
}
