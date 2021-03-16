package com.macbook.core.service.impl;

import com.macbook.core.dao.ManagerChangeDao;
import com.macbook.core.service.ManagerChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author maweihong
 */
@Service("managerChangeService")
public class ManagerChangeServiceImpl implements ManagerChangeService {
    @Autowired
    private ManagerChangeDao managerChangeDao;

    @Override
    public int updatePassword(String sno, String password) {
        return managerChangeDao.updatePassword(sno,password);
    }
}
