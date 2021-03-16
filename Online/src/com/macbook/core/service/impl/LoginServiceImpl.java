package com.macbook.core.service.impl;

import com.macbook.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.macbook.core.dao.LoginDao;
import com.macbook.core.pojo.User;

/**
 * @author maweihong
 */
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
    /**
     * 注入UserDao
     */
    @Autowired
    private LoginDao loginDao;

    /**
     * 通过账号、密码、身份查询用户
     * @param sno
     * @param password
     * @return
     */
    @Override
    public User findUser(String sno, String password) {
        User user = this.loginDao.findUser(sno, password);
        return user;
    }
}

