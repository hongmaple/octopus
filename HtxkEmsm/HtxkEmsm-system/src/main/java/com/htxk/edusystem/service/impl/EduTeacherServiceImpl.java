package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.EduTeacher;
import com.htxk.edusystem.mapper.EduTeacherMapper;
import com.htxk.edusystem.service.IEduTeacherService;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.system.domain.SysUser;
import com.htxk.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 教师信息Service业务层处理
 *
 * @author maple
 * @date 2020-01-11
 */
@Service("EduTeacher")
public class EduTeacherServiceImpl implements IEduTeacherService {
    @Autowired
    private EduTeacherMapper eduTeacherMapper;

    /**
     * 查询教师信息
     *
     * @param teacherId 教师信息ID
     * @return 教师信息
     */
    @Override
    public EduTeacher selectEduTeacherById(Long teacherId) {
        return eduTeacherMapper.selectEduTeacherById(teacherId);
    }

    /**
     * 查询教师信息列表
     *
     * @param eduTeacher 教师信息
     * @return 教师信息
     */
    @Override
    public List<EduTeacher> selectEduTeacherList(EduTeacher eduTeacher) {
        return eduTeacherMapper.selectEduTeacherList(eduTeacher);
    }

    /**
     * 新增教师信息
     *
     * @param eduTeacher 教师信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertEduTeacher(EduTeacher eduTeacher) {
        return eduTeacherMapper.insertEduTeacher(eduTeacher);
    }

    /**
     * 修改教师信息
     *
     * @param eduTeacher 教师信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateEduTeacher(EduTeacher eduTeacher) {
        return eduTeacherMapper.updateEduTeacher(eduTeacher);
    }

    /**
     * 删除教师信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteEduTeacherByIds(String ids) {
        return eduTeacherMapper.deleteEduTeacherByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教师信息信息
     *
     * @param teacherId 教师信息ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteEduTeacherById(Long teacherId) {
        return eduTeacherMapper.deleteEduTeacherById(teacherId);
    }
}
