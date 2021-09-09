package com.borui.mongodb.utils;

import java.util.List;

/**
 * @class: com.borui.mongodb.utils.PagesUtils
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/8 16:39
 */


public class PagesUtils<T> {
    public  Page getPage(List<T> list,Page page) {
        int total = list.size();
        page.setTotal(total);
        int pageSize = page.getSize();
        int pageStart = (page.getCurrent() -1) * page.getSize();
        //设置总页数
        page.setPages((total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1));
        //page.setTotalPage();

        //不使用自定义的分页方法
        page.setHitCount(false);
        page.setOptimizeCountSql(true);
        page.setSearchCount(true);
        //截取数据信息
        page.setRecords(list.subList(pageStart, (total - pageStart) > pageSize ? pageStart + pageSize : total));
        return page;
    }
}
