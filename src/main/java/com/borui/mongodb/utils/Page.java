package com.borui.mongodb.utils;

import lombok.Data;

import java.util.List;

/**
 * 自定义插件
 */
@Data
public class Page {
/*    private Integer currentPage;   //当前页
    private Integer pageSize;     //每页的记录数
    private Integer totalPage;    //总页数*/


    private Integer current;   //当前页
    private Integer size;      //每页的条数
    private Integer pages;     //总页数
    private Integer total;     //总数据量  （总数）
    private List<?> records;  //分页数据集合

    private Integer[] orders;
    private Boolean optimizeCountSql;
    private Boolean hitCount;
    private Integer countId;
    private Integer maxLimit;
    private Boolean searchCount;
}
