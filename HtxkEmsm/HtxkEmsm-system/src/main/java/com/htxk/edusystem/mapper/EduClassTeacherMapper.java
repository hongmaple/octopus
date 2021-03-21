package com.htxk.edusystem.mapper;

import com.htxk.edusystem.domain.EduClassTeacher;

import java.util.List;

/**
 * 班级教师Mapper接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface EduClassTeacherMapper {
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
     * 删除班级教师
     *
     * @param classTeacherId 班级教师ID
     * @return 结果
     */
    public int deleteEduClassTeacherById(Long classTeacherId);

    /**
     * 批量删除班级教师
     *
     * @param classTeacherIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduClassTeacherByIds(String[] classTeacherIds);
}
