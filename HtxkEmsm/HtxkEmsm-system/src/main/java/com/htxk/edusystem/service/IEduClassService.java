package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduClass;

import java.util.List;

/**
 * 班级信息Service接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface IEduClassService {
    /**
     * 查询班级信息
     *
     * @param classId 班级信息ID
     * @return 班级信息
     */
    public EduClass selectEduClassById(Long classId);

    /**
     * 查询班级信息列表
     *
     * @param eduClass 班级信息
     * @return 班级信息集合
     */
    public List<EduClass> selectEduClassList(EduClass eduClass);

    /**
     * 新增班级信息
     *
     * @param eduClass 班级信息
     * @return 结果
     */
    public int insertEduClass(EduClass eduClass);

    /**
     * 修改班级信息
     *
     * @param eduClass 班级信息
     * @return 结果
     */
    public int updateEduClass(EduClass eduClass);

    /**
     * 批量删除班级信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduClassByIds(String ids);

    /**
     * 删除班级信息信息
     *
     * @param classId 班级信息ID
     * @return 结果
     */
    public int deleteEduClassById(Long classId);
}
