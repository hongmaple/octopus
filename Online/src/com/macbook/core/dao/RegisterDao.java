package com.macbook.core.dao;

import com.macbook.core.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author maweihong
 */
public interface RegisterDao {
	/**
	 * 通过学号/工号查询用户
	 * @param phone
	 * @param sno
	 * @return
	 */
	public User findUserBySno(@Param("sno") String sno) ;
    /**
     * 该方法用来注册用户
     * @param user
     * @return
     */
    public int createUser(User user);
}
