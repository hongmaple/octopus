package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduClassroom;

import java.util.List;

/**
 * 教室Service接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface IEduClassroomService {
    /**
     * 查询教室
     *
     * @param classroomId 教室ID
     * @return 教室
     */
    public EduClassroom selectEduClassroomById(Long classroomId);

    /**
     * 查询教室列表
     *
     * @param eduClassroom 教室
     * @return 教室集合
     */
    public List<EduClassroom> selectEduClassroomList(EduClassroom eduClassroom);

    /**
     * 新增教室
     *
     * @param eduClassroom 教室
     * @return 结果
     */
    public int insertEduClassroom(EduClassroom eduClassroom);

    /**
     * 修改教室
     *
     * @param eduClassroom 教室
     * @return 结果
     */
    public int updateEduClassroom(EduClassroom eduClassroom);

    /**
     * 批量删除教室
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduClassroomByIds(String ids);

    /**
     * 删除教室信息
     *
     * @param classroomId 教室ID
     * @return 结果
     */
    public int deleteEduClassroomById(Long classroomId);
}
