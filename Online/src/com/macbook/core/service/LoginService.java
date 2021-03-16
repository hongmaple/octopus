package com.macbook.core.service;

import com.macbook.core.pojo.User;

/**
 * @author maweihong
 */
public interface LoginService {
    /**
     * 通过账号、密码查询用户
     * @param sno
     * @param password
     * @return
     */
    public User findUser(String sno,String password);
}
