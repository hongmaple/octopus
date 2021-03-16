package com.macbook.core.service.impl;

import com.macbook.common.utils.Page;
import com.macbook.core.dao.ManagerUserDao;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManagerUserServiceImpl  implements ManagerUserService {
    @Autowired
    private ManagerUserDao managerUserDao;
    @Override
    public Page<User> findUserList(Integer page, Integer rows, String sno, String name, String identity, String college) {
        User user = new User();
        //判断学号
        if(StringUtils.isNotBlank(sno)){
            user.setSno(sno);
        }
        //判断姓名
        if(StringUtils.isNotBlank(name)){
            user.setName(name);
        }
        //判断身份
        if (StringUtils.isNotBlank(identity)){
            user.setIdentity(identity);
        }
        //判断学院
        if (StringUtils.isNotBlank(college)){
            user.setCollege(college);
        }
        //当前页
        user.setStart((page-1) * rows);
        //每页数
        user.setRows(rows);
        //查询用户列表
        List<User> users = managerUserDao.selectUserList(user);
        //查询用户数量
        Integer count = managerUserDao.selectUserListCount(user);
        //创建page返回对象
        Page<User> result = new Page<>();
        result.setPage(page);
        result.setRows(users);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    /**
     * 删除用户
     * @param sno
     * @return
     */
    @Override
    public int deleteUser(String sno) {
        return managerUserDao.deleteUser(sno);
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @Override
    public int createManagerUser(User user) {
        return managerUserDao.createManagerUser(user);
    }

    @Override
    public User findManagerUserBySno(String sno) {
        return managerUserDao.findManagerUserBySno(sno);
    }

    @Override
    public int updateManagerUser(User user) {
        return managerUserDao.updateManagerUser(user);
    }
}
