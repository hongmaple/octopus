package com.macbook.core.service;

import com.macbook.core.pojo.User;

/**
 * 
 * @author maweihong
 *
 */
public interface ChangePasswordService {
	/**
	 * 通过学号/工号查询用户
	 * @param sno
	 * @param phone
	 * @return
	 */
	public User findUserBySno(String sno) ;
	/**
	 * 修改用户密码
	 * @param user
	 * @return
	 */
	public int updatePassword(String sno,String password);
}
