package com.macbook.core.service;

/**
 * @author maweihong
 */
public interface ManagerChangeService {
    /**
     * 用户自行修改密码
     * @param sno
     * @param password
     * @return
     */
    public int updatePassword(String sno,String password);
}
