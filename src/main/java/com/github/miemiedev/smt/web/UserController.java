package com.github.miemiedev.smt.web;


import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.smt.service.AuthService;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account/user")
public class UserController extends BaseController{
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "")
    public String listView() {
        return "account/userList";
    }

    @ResponseBody
    @RequestMapping(value = "/list.json")
    public List list() throws ParseException {
        return authService.queryByDeptCode("", getPageBounds());
    }

    @ResponseBody
    @RequestMapping(value = "/search.json")
    public List search() throws ParseException {
        Map<String,Object> params = Maps.newHashMap();
        params.put("realName", "李");
        return authService.search(params, getPageBounds());
    }

    @Override
    protected List<Order> getSortInfos(String sort) {
        if(!Strings.isNullOrEmpty(sort)){
            if(sort.trim().toLowerCase().startsWith("name")){
                return Order.formString(sort, sortExpression);
            }else{
                return Order.formString(sort);
            }
        }
        return new ArrayList();
    }
}
