package com.macbook.core.service;


import com.macbook.core.pojo.User;

/**
 * @author maweihong
 */
public interface RegisterService {
	/**
	 * 通过学号/工号查询用户
	 * @param sno
	 * @param phone
	 * @return
	 */
	public User findUserBySno(String sno) ;
    /**
     * 服务层添加用户
     * @param user
     * @return
     */
    public int createUser(User user);
}
