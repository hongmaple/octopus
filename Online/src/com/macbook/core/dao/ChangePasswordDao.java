package com.macbook.core.dao;
/**
 * 
 * @author maweihong
 *
 */

import com.macbook.core.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface ChangePasswordDao {
	/**
	 * 通过学号/工号查询用户
	 * @param sno
	 * @param phone
	 * @return
	 */
	public User findUserBySno(@Param("sno") String sno) ;
	/**
	 * 修改用户密码
	 * @param user
	 * @return
	 */
	public int updatePassword(@Param("sno") String sno,
												@Param("password") String password);
}
