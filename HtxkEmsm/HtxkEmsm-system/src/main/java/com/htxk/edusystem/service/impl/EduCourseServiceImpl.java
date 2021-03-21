package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.EduCourse;
import com.htxk.edusystem.mapper.EduCourseMapper;
import com.htxk.edusystem.service.IEduCourseService;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程Service业务层处理
 *
 * @author maple
 * @date 2020-01-08
 */
@Service("Course")
public class EduCourseServiceImpl implements IEduCourseService {
    @Autowired
    private EduCourseMapper eduCourseMapper;

    /**
     * 查询课程
     *
     * @param courseId 课程ID
     * @return 课程
     */
    @Override
    public EduCourse selectEduCourseById(Long courseId) {
        return eduCourseMapper.selectEduCourseById(courseId);
    }

    /**
     * 查询课程列表
     *
     * @param eduCourse 课程
     * @return 课程
     */
    @Override
    public List<EduCourse> selectEduCourseList(EduCourse eduCourse) {
        return eduCourseMapper.selectEduCourseList(eduCourse);
    }

    /**
     * 新增课程
     *
     * @param eduCourse 课程
     * @return 结果
     */
    @Override
    public int insertEduCourse(EduCourse eduCourse) {
        eduCourse.setCreateTime(DateUtils.getNowDate());
        return eduCourseMapper.insertEduCourse(eduCourse);
    }

    /**
     * 修改课程
     *
     * @param eduCourse 课程
     * @return 结果
     */
    @Override
    public int updateEduCourse(EduCourse eduCourse) {
        return eduCourseMapper.updateEduCourse(eduCourse);
    }

    /**
     * 删除课程对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduCourseByIds(String ids) {
        return eduCourseMapper.deleteEduCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程信息
     *
     * @param courseId 课程ID
     * @return 结果
     */
    @Override
    public int deleteEduCourseById(Long courseId) {
        return eduCourseMapper.deleteEduCourseById(courseId);
    }
}
