package com.github.miemiedev.smt.web;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
public class BaseController {

    protected static final String sortExpression = "nlssort( ? ,'NLS_SORT=SCHINESE_PINYIN_M')";

    public PageBounds getPageBounds(){
        return getPageBounds(null);
    }

    public PageBounds getPageBounds(String defaultSort){
        Integer page = Integer.valueOf(getParameter("page", "1"));
        Integer limit =  Integer.valueOf(getParameter("limit", "15"));
        String sort = getParameter("sort", defaultSort);

        PageBounds pageBounds = new PageBounds(page, limit);

        List<Order> orders = getSortInfos(sort);
        pageBounds.getOrders().addAll(orders);

        return pageBounds;
    }

    protected List<Order> getSortInfos(String sort){
        return Order.formString(sort);
    }

    protected String getParameter(String name){
        return getParameter(name,"");
    }

    protected String getParameter(String name, String defaultValue){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        String value = request.getParameter(name);
        if(value == null || value.equals("")){
            return defaultValue;
        }
        return value;
    }
}
