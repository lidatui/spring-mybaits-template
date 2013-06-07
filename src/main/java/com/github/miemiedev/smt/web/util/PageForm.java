package com.github.miemiedev.smt.web.util;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class PageForm {

    public static final String CHINESE_PINYIN = "nlssort(? ,'NLS_SORT=SCHINESE_PINYIN_M')";

    private int page = 1;
    private int limit = 30;
    private String sort;

    private Map<String,String> orderExprs = new HashMap<String, String>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void addOrderExpr(String property, String expr){
        this.orderExprs.put(property,expr);
    }

    public PageBounds toPageBounds(){
        List<Order> orders = Order.formString(sort);
        for (int i = 0; i < orders.size(); i++) {
            Order order =  orders.get(i);
            if(orderExprs.get(order.getProperty()) != null){
                orders.set(i, new Order(
                        order.getProperty(),
                        order.getDirection(),
                        orderExprs.get(order.getProperty()))
                );
            }
        }
        return new PageBounds(page, limit, orders);
    }
}
