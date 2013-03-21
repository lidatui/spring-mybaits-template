package com.github.miemiedev.smt.repository;


import com.github.miemiedev.smt.entity.User;

import java.util.List;

@MyBatisRepository
public interface UserDao {

    public User get(Long id);


    public List<User> findAll();
}
