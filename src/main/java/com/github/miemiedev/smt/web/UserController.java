package com.github.miemiedev.smt.web;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.github.miemiedev.smt.entity.User;
import com.github.miemiedev.smt.service.AuthService;
import com.github.miemiedev.smt.web.util.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/account/user")
public class UserController{
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "")
    public String listView() {
        return "account/userList";
    }

    @ResponseBody
    @RequestMapping(value = "/list.json")
    public List list(PageForm pageForm) throws ParseException {
        pageForm.addOrderExpr("REAL_NAME", "nlssort(? ,'NLS_SORT=SCHINESE_PINYIN_M') ? nulls last");
        return authService.queryByDeptCode("", pageForm.toPageBounds());
    }


    @RequestMapping(value = "/jstl.action")
    public Object usersView(PageForm pageForm, HttpServletRequest request) throws ParseException {
        List users = list(pageForm);
        return new ModelAndView( "account/jstl","users", users);
    }


}
