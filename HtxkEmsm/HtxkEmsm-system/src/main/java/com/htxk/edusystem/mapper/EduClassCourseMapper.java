package com.htxk.edusystem.mapper;

import com.htxk.edusystem.domain.EduClassCourse;

import java.util.List;

/**
 * 班级课程Mapper接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface EduClassCourseMapper {
    /**
     * 查询班级课程
     *
     * @param classCourseId 班级课程ID
     * @return 班级课程
     */
    public EduClassCourse selectEduClassCourseById(Long classCourseId);

    /**
     * 查询班级课程列表
     *
     * @param eduClassCourse 班级课程
     * @return 班级课程集合
     */
    public List<EduClassCourse> selectEduClassCourseList(EduClassCourse eduClassCourse);

    /**
     * 新增班级课程
     *
     * @param eduClassCourse 班级课程
     * @return 结果
     */
    public int insertEduClassCourse(EduClassCourse eduClassCourse);

    /**
     * 修改班级课程
     *
     * @param eduClassCourse 班级课程
     * @return 结果
     */
    public int updateEduClassCourse(EduClassCourse eduClassCourse);

    /**
     * 删除班级课程
     *
     * @param classCourseId 班级课程ID
     * @return 结果
     */
    public int deleteEduClassCourseById(Long classCourseId);

    /**
     * 批量删除班级课程
     *
     * @param classCourseIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduClassCourseByIds(String[] classCourseIds);
}
