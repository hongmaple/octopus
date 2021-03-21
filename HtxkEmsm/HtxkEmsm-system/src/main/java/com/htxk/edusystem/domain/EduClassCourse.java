package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 班级课程对象 edu_class_course
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduClassCourse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级课程ID
     */
    private Long classCourseId;

    /**
     * 班级名
     */
    @Excel(name = "班级名")
    private Long classCourseClassId;

    /**
     * 任课教师
     */
    @Excel(name = "任课教师")
    private Long classCourseTeacherid;

    /**
     * 课程名
     */
    @Excel(name = "课程名")
    private Long classCourseCourseId;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public Long getClassCourseId() {
        return classCourseId;
    }

    public void setClassCourseId(Long classCourseId) {
        this.classCourseId = classCourseId;
    }

    public Long getClassCourseClassId() {
        return classCourseClassId;
    }

    public void setClassCourseClassId(Long classCourseClassId) {
        this.classCourseClassId = classCourseClassId;
    }

    public Long getClassCourseTeacherid() {
        return classCourseTeacherid;
    }

    public void setClassCourseTeacherid(Long classCourseTeacherid) {
        this.classCourseTeacherid = classCourseTeacherid;
    }

    public Long getClassCourseCourseId() {
        return classCourseCourseId;
    }

    public void setClassCourseCourseId(Long classCourseCourseId) {
        this.classCourseCourseId = classCourseCourseId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("classCourseId", getClassCourseId())
                .append("classCourseClassId", getClassCourseClassId())
                .append("classCourseTeacherid", getClassCourseTeacherid())
                .append("classCourseCourseId", getClassCourseCourseId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
