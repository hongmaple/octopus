package com.ruoyi.edu.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.edu.domain.EduCourseType;
import com.ruoyi.edu.mapper.EduCourseTypeMapper;
import com.ruoyi.edu.service.IEduCourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 课程类型Service业务层处理
 *
 * @author maple
 * @date 2020-01-03
 */
@Service("CourseType")
public class EduCourseTypeServiceImpl implements IEduCourseTypeService {
    @Autowired
    private EduCourseTypeMapper eduCourseTypeMapper;

    /**
     * 查询课程类型
     *
     * @param courseTypeId 课程类型ID
     * @return 课程类型
     */
    @Override
    public EduCourseType selectEduCourseTypeById(Long courseTypeId) {
        return eduCourseTypeMapper.selectEduCourseTypeById(courseTypeId);
    }

    /**
     * 查询课程类型列表
     *
     * @param eduCourseType 课程类型
     * @return 课程类型
     */
    @Override
    public List<EduCourseType> selectEduCourseTypeList(EduCourseType eduCourseType) {
        return eduCourseTypeMapper.selectEduCourseTypeList(eduCourseType);
    }

    /**
     * 新增课程类型
     *
     * @param eduCourseType 课程类型
     * @return 结果
     */
    @Override
    public int insertEduCourseType(EduCourseType eduCourseType) {
        eduCourseType.setCreateTime(DateUtils.getNowDate());
        return eduCourseTypeMapper.insertEduCourseType(eduCourseType);
    }

    /**
     * 修改课程类型
     *
     * @param eduCourseType 课程类型
     * @return 结果
     */
    @Override
    public int updateEduCourseType(EduCourseType eduCourseType) {
        eduCourseType.setUpdateTime(DateUtils.getNowDate());
        return eduCourseTypeMapper.updateEduCourseType(eduCourseType);
    }

    /**
     * 删除课程类型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduCourseTypeByIds(String ids) {
        return eduCourseTypeMapper.deleteEduCourseTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程类型信息
     *
     * @param courseTypeId 课程类型ID
     * @return 结果
     */
    @Override
    public int deleteEduCourseTypeById(Long courseTypeId) {
        return eduCourseTypeMapper.deleteEduCourseTypeById(courseTypeId);
    }
}
