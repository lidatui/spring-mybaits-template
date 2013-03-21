package com.github.miemiedev.smt.web;


import com.github.miemiedev.smt.entity.User;
import com.github.miemiedev.smt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/account/user")
public class UserController {
    @Autowired
    private AuthService authService;

    @ResponseBody
    @RequestMapping(value = "")
    public List<User> list() {
        return authService.findUserAll();
    }

}
