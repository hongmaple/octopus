package com.macbook.core.dao;

import com.macbook.core.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author maweihong
 */
public interface LoginDao {
    /**
     * 通过账号、密码查询用户
     * @param sno
     * @param password
     * @return
     */
    public User findUser(@Param("sno") String sno,
                         @Param("password") String password);
}
