package com.macbook.core.service;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.User;

/**
 * @author maweihong
 */
public interface ManagerUserService {
    /**
     * 查询用户列表
     * @param page
     * @param rows
     * @param sno
     * @param name
     * @param identity
     * @param college
     * @return
     */
    public Page<User> findUserList(Integer page,Integer rows,String sno,
                                   String name, String identity,String college);

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
     * 更新前查询用户
     * @param sno
     * @return
     */
    public User findManagerUserBySno(String sno);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public int updateManagerUser(User user);

}
