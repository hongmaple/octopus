package com.macbook.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.macbook.core.dao.ChangePasswordDao;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ChangePasswordService;
/**
 * 
 * @author maweihong
 *
 */
@Service("changePasswordService")
@Transactional
public class ChangePasswordServiceImpl implements ChangePasswordService {
	/**
	 * 注入ChangePasswordService
	 */
	@Autowired
	private ChangePasswordDao changePasswordDao;
	@Override
	public User findUserBySno(String sno) {
		// TODO Auto-generated method stub
		User user = this.changePasswordDao.findUserBySno(sno);
		return user;
	}

	@Override
	public int updatePassword(String sno,String password) {
		// TODO Auto-generated method stub
		return this.changePasswordDao.updatePassword(sno,password);
	}

}
