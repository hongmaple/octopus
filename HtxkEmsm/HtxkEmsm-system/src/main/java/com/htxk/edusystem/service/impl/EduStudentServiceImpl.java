package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.EduStudent;
import com.htxk.edusystem.mapper.EduStudentMapper;
import com.htxk.edusystem.service.IEduStudentService;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学生信息Service业务层处理
 *
 * @author maple
 * @date 2020-01-03
 */
@Service("Student")
public class EduStudentServiceImpl implements IEduStudentService {
    @Autowired
    private EduStudentMapper eduStudentMapper;

    /**
     * 查询学生信息
     *
     * @param studentId 学生信息ID
     * @return 学生信息
     */
    @Override
    public EduStudent selectEduStudentById(Long studentId) {
        return eduStudentMapper.selectEduStudentById(studentId);
    }

    /**
     * 查询学生信息列表
     *
     * @param eduStudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<EduStudent> selectEduStudentList(EduStudent eduStudent) {
        return eduStudentMapper.selectEduStudentList(eduStudent);
    }

    /**
     * 新增学生信息
     *
     * @param eduStudent 学生信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertEduStudent(EduStudent eduStudent) {
        return eduStudentMapper.insertEduStudent(eduStudent);
    }

    /**
     * 修改学生信息
     *
     * @param eduStudent 学生信息
     * @return 结果
     */
    @Override
    public int updateEduStudent(EduStudent eduStudent) {
        return eduStudentMapper.updateEduStudent(eduStudent);
    }

    /**
     * 删除学生信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduStudentByIds(String ids) {
        return eduStudentMapper.deleteEduStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息信息
     *
     * @param studentId 学生信息ID
     * @return 结果
     */
    @Override
    public int deleteEduStudentById(Long studentId) {
        return eduStudentMapper.deleteEduStudentById(studentId);
    }
}
