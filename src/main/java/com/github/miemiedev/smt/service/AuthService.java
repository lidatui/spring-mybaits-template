package com.github.miemiedev.smt.service;


import com.github.miemiedev.smt.entity.User;
import com.github.miemiedev.smt.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthService {

    private UserDao userDao;


    public User getUserById(Long id){
        return userDao.get(id);
    }

    public List<User> findUserAll(){
        return userDao.findAll();
    }


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
