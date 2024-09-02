package com.ruoyi.edu.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.edu.domain.EduClassTeacher;
import com.ruoyi.edu.mapper.EduClassTeacherMapper;
import com.ruoyi.edu.service.IEduClassTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 班级教师Service业务层处理
 *
 * @author maple
 * @date 2020-01-03
 */
@Service("classTeacher")
public class EduClassTeacherServiceImpl implements IEduClassTeacherService {
    @Autowired
    private EduClassTeacherMapper eduClassTeacherMapper;

    /**
     * 查询班级教师
     *
     * @param classTeacherId 班级教师ID
     * @return 班级教师
     */
    @Override
    public EduClassTeacher selectEduClassTeacherById(Long classTeacherId) {
        return eduClassTeacherMapper.selectEduClassTeacherById(classTeacherId);
    }

    /**
     * 查询班级教师列表
     *
     * @param eduClassTeacher 班级教师
     * @return 班级教师
     */
    @Override
    public List<EduClassTeacher> selectEduClassTeacherList(EduClassTeacher eduClassTeacher) {
        return eduClassTeacherMapper.selectEduClassTeacherList(eduClassTeacher);
    }

    @Override
    public List<EduClassTeacher> queryEduTeacherList(EduClassTeacher eduClassTeacher) {
        return eduClassTeacherMapper.queryEduTeacherList(eduClassTeacher);
    }


    /**
     * 新增班级教师
     *
     * @param eduClassTeacher 班级教师
     * @return 结果
     */
    @Override
    public int insertEduClassTeacher(EduClassTeacher eduClassTeacher) {
        return eduClassTeacherMapper.insertEduClassTeacher(eduClassTeacher);
    }

    /**
     * 修改班级教师
     *
     * @param eduClassTeacher 班级教师
     * @return 结果
     */
    @Override
    public int updateEduClassTeacher(EduClassTeacher eduClassTeacher) {
        eduClassTeacher.setUpdateTime(DateUtils.getNowDate());
        return eduClassTeacherMapper.updateEduClassTeacher(eduClassTeacher);
    }

    /**
     * 删除班级教师对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduClassTeacherByIds(String ids) {
        return eduClassTeacherMapper.deleteEduClassTeacherByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级教师信息
     *
     * @param classTeacherId 班级教师ID
     * @return 结果
     */
    @Override
    public int deleteEduClassTeacherById(Long classTeacherId) {
        return eduClassTeacherMapper.deleteEduClassTeacherById(classTeacherId);
    }
}
