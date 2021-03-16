package com.macbook.core.dao;

import com.macbook.core.pojo.User;

import java.util.List;

/**
 * @author maweihong
 */
public interface ManagerUserDao {
    /**
     * 用户列表
     * @param user
     * @return
     */
    public List<User> selectUserList(User user);

    /**
     * 用户数量
     * @param user
     * @return
     */
    public Integer selectUserListCount(User user);

    /**
     * 删除用户
     * @param sno
     * @return
     */
    public int deleteUser(String sno);

    /**
     * 创建用户
     * @param user
     * @return
     */
    public int createManagerUser(User user);

    /**
     * 修改前查询用户
     * @param sno
     * @return
     */
    public User findManagerUserBySno(String sno);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateManagerUser(User user);
}
