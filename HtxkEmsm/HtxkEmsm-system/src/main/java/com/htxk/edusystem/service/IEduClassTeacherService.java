package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduClassTeacher;

import java.util.List;

/**
 * 班级教师Service接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface IEduClassTeacherService {
    /**
     * 查询班级教师
     *
     * @param classTeacherId 班级教师ID
     * @return 班级教师
     */
    public EduClassTeacher selectEduClassTeacherById(Long classTeacherId);

    /**
     * 查询班级教师列表
     *
     * @param eduClassTeacher 班级教师
     * @return 班级教师集合
     */
    public List<EduClassTeacher> selectEduClassTeacherList(EduClassTeacher eduClassTeacher);

    public List<EduClassTeacher> queryEduTeacherList(EduClassTeacher eduClassTeacher);
    /**
     * 新增班级教师
     *
     * @param eduClassTeacher 班级教师
     * @return 结果
     */
    public int insertEduClassTeacher(EduClassTeacher eduClassTeacher);

    /**
     * 修改班级教师
     *
     * @param eduClassTeacher 班级教师
     * @return 结果
     */
    public int updateEduClassTeacher(EduClassTeacher eduClassTeacher);

    /**
     * 批量删除班级教师
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduClassTeacherByIds(String ids);

    /**
     * 删除班级教师信息
     *
     * @param classTeacherId 班级教师ID
     * @return 结果
     */
    public int deleteEduClassTeacherById(Long classTeacherId);
}
