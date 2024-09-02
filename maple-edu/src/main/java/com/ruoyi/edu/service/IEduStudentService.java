package com.ruoyi.edu.service;


import com.ruoyi.edu.domain.EduStudent;

import java.util.List;
/**
 * 学生信息Service接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface IEduStudentService {
    /**
     * 查询学生信息
     *
     * @param studentId 学生信息ID
     * @return 学生信息
     */
    public EduStudent selectEduStudentById(Long studentId);

    /**
     * 查询学生信息列表
     *
     * @param eduStudent 学生信息
     * @return 学生信息集合
     */
    public List<EduStudent> selectEduStudentList(EduStudent eduStudent);

    /**
     * 新增学生信息
     *
     * @param eduStudent 学生信息
     * @return 结果
     */
    public int insertEduStudent(EduStudent eduStudent);

    /**
     * 修改学生信息
     *
     * @param eduStudent 学生信息
     * @return 结果
     */
    public int updateEduStudent(EduStudent eduStudent);

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduStudentByIds(String ids);

    /**
     * 删除学生信息
     * @param studentId 学生信息ID
     * @return 结果
     */
    public int deleteEduStudentById(Long studentId);
}
