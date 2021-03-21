package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduCourse;

import java.util.List;

/**
 * 课程Service接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface IEduCourseService {
    /**
     * 查询课程
     *
     * @param courseId 课程ID
     * @return 课程
     */
    public EduCourse selectEduCourseById(Long courseId);

    /**
     * 查询课程列表
     *
     * @param eduCourse 课程
     * @return 课程集合
     */
    public List<EduCourse> selectEduCourseList(EduCourse eduCourse);

    /**
     * 新增课程
     *
     * @param eduCourse 课程
     * @return 结果
     */
    public int insertEduCourse(EduCourse eduCourse);

    /**
     * 修改课程
     *
     * @param eduCourse 课程
     * @return 结果
     */
    public int updateEduCourse(EduCourse eduCourse);

    /**
     * 批量删除课程
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduCourseByIds(String ids);

    /**
     * 删除课程信息
     *
     * @param courseId 课程ID
     * @return 结果
     */
    public int deleteEduCourseById(Long courseId);
}
