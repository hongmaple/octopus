package com.macbook.core.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author maweihong
 */
public interface ManagerChangeDao {
    /**
     * 用户自行修改密码
     * @param sno
     * @param password
     * @return
     */
    public int updatePassword(@Param("sno") String sno,
                              @Param("password") String password);
}
