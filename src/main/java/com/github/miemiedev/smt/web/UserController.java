package com.github.miemiedev.smt.web;


import com.github.miemiedev.mybatis.paginator.PageQuery;
import com.github.miemiedev.mybatis.paginator.SortInfo;
import com.github.miemiedev.smt.entity.User;
import com.github.miemiedev.smt.service.AuthService;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        PageQuery pageQuery = getPageQuery();
        return authService.queryByDeptCode("",pageQuery);
    }

    @ResponseBody
    @RequestMapping(value = "/search.json")
    public List search() throws ParseException {
        Map<String,Object> params = Maps.newHashMap();
        params.put("realName", "李");
        return authService.search(params, getPageQuery());
    }

    @Override
    protected List<SortInfo> getSortInfos(String sort) {
        if(!Strings.isNullOrEmpty(sort)){
            if(sort.trim().toLowerCase().startsWith("name")){
                return SortInfo.parseSortColumns(sort, sortExpression);
            }else{
                return SortInfo.parseSortColumns(sort);
            }
        }
        return new ArrayList();
    }
}
