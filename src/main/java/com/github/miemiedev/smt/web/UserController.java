package com.github.miemiedev.smt.web;


import com.github.miemiedev.mybatis.paginator.PageQuery;
import com.github.miemiedev.mybatis.paginator.SortInfo;
import com.github.miemiedev.smt.entity.User;
import com.github.miemiedev.smt.service.AuthService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account/user")
public class UserController {
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "")
    public String listView() {
        return "account/userList";
    }

    @ResponseBody
    @RequestMapping(value = "/list.json")
    public List list(@RequestParam(required = false,defaultValue = "0") int page,
                     @RequestParam(required = false,defaultValue = "30") int limit,
                     @RequestParam(required = false) String sort) throws ParseException {
        return authService.queryByDeptCode("", new PageQuery(page, limit, SortInfo.parseSortColumn(sort)));
    }

    @ResponseBody
    @RequestMapping(value = "/search.json")
    public List search(@RequestParam(required = false,defaultValue = "0") int page,
                     @RequestParam(required = false,defaultValue = "30") int limit,
                     @RequestParam(required = false) String sort) throws ParseException {
        Map<String,Object> params = Maps.newHashMap();
        params.put("realName", "李");
        return authService.search(params, new PageQuery(page, limit, SortInfo.parseSortColumn(sort)));
    }

}
