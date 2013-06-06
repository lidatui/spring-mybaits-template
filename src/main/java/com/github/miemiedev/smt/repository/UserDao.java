package com.github.miemiedev.smt.repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.smt.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface UserDao {

    public User get(Long id);

    public List<User> queryByDeptCode(@Param("deptCode")String deptCode,
                                      @Param("createDate")Date createDate,
                                      PageBounds pageBounds);

    public List<Map<String, Object>> search(Map params ,PageBounds pageBounds);

    public List<Map<String, Object>> find(PageBounds pageBounds);
}
