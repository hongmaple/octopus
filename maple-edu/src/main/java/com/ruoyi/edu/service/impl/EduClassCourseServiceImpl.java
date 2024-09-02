package com.ruoyi.edu.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.edu.domain.EduClassCourse;
import com.ruoyi.edu.mapper.EduClassCourseMapper;
import com.ruoyi.edu.service.IEduClassCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级课程Service业务层处理
 *
 * @author maple
 * @date 2020-01-03
 */
@Service
public class EduClassCourseServiceImpl implements IEduClassCourseService {
    @Autowired
    private EduClassCourseMapper eduClassCourseMapper;

    /**
     * 查询班级课程
     *
     * @param classCourseId 班级课程ID
     * @return 班级课程
     */
    @Override
    public EduClassCourse selectEduClassCourseById(Long classCourseId) {
        return eduClassCourseMapper.selectEduClassCourseById(classCourseId);
    }

    /**
     * 查询班级课程列表
     *
     * @param eduClassCourse 班级课程
     * @return 班级课程
     */
    @Override
    public List<EduClassCourse> selectEduClassCourseList(EduClassCourse eduClassCourse) {
        return eduClassCourseMapper.selectEduClassCourseList(eduClassCourse);
    }

    /**
     * 新增班级课程
     *
     * @param eduClassCourse 班级课程
     * @return 结果
     */
    @Override
    public int insertEduClassCourse(EduClassCourse eduClassCourse) {
        eduClassCourse.setCreateTime(DateUtils.getNowDate());
        return eduClassCourseMapper.insertEduClassCourse(eduClassCourse);
    }

    /**
     * 修改班级课程
     *
     * @param eduClassCourse 班级课程
     * @return 结果
     */
    @Override
    public int updateEduClassCourse(EduClassCourse eduClassCourse) {
        eduClassCourse.setUpdateTime(DateUtils.getNowDate());
        return eduClassCourseMapper.updateEduClassCourse(eduClassCourse);
    }

    /**
     * 删除班级课程对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduClassCourseByIds(String ids) {
        return eduClassCourseMapper.deleteEduClassCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级课程信息
     *
     * @param classCourseId 班级课程ID
     * @return 结果
     */
    @Override
    public int deleteEduClassCourseById(Long classCourseId) {
        return eduClassCourseMapper.deleteEduClassCourseById(classCourseId);
    }
}
