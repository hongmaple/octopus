package com.macbook.core.service.impl;

import com.macbook.core.dao.RegisterDao;
import com.macbook.core.pojo.User;
import com.macbook.core.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author maweihong
 */
@Service("registerService")
@Transactional
public class RegisterServiceImpl implements RegisterService {
    /**
     * 注入RegisterDao
     */
    @Autowired
    private RegisterDao registerDao;
    @Override
	public User findUserBySno(String sno) {
		// TODO Auto-generated method stub
       User user = this.registerDao.findUserBySno(sno);
//		User user = this.registerDao.findUserBySno(sno);
		return user;
	}
    @Override
    public int createUser(User user) {
        return this.registerDao.createUser(user);
    }
}