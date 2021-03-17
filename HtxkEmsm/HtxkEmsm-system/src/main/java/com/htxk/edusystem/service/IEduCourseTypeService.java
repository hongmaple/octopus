package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduCourseType;

import java.util.List;

/**
 * 课程类型Service接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface IEduCourseTypeService {
    /**
     * 查询课程类型
     *
     * @param courseTypeId 课程类型ID
     * @return 课程类型
     */
    public EduCourseType selectEduCourseTypeById(Long courseTypeId);

    /**
     * 查询课程类型列表
     *
     * @param eduCourseType 课程类型
     * @return 课程类型集合
     */
    public List<EduCourseType> selectEduCourseTypeList(EduCourseType eduCourseType);

    /**
     * 新增课程类型
     *
     * @param eduCourseType 课程类型
     * @return 结果
     */
    public int insertEduCourseType(EduCourseType eduCourseType);

    /**
     * 修改课程类型
     *
     * @param eduCourseType 课程类型
     * @return 结果
     */
    public int updateEduCourseType(EduCourseType eduCourseType);

    /**
     * 批量删除课程类型
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduCourseTypeByIds(String ids);

    /**
     * 删除课程类型信息
     *
     * @param courseTypeId 课程类型ID
     * @return 结果
     */
    public int deleteEduCourseTypeById(Long courseTypeId);
}
