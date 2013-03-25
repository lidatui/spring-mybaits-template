package com.github.miemiedev.smt.service;


import com.github.miemiedev.mybatis.paginator.PageQuery;
import com.github.miemiedev.smt.entity.User;
import com.github.miemiedev.smt.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class AuthService {

    private UserDao userDao;


    public User getUserById(Long id){
        return userDao.get(id);
    }

    public List<User> queryByDeptCode(String deptCode, PageQuery pq) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return userDao.queryByDeptCode(deptCode, sdf.parse("2010-03-02"), pq);
    }

    public List<Map<String, Object>> search(Map params ,PageQuery pq){
        return userDao.search(params, pq);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
