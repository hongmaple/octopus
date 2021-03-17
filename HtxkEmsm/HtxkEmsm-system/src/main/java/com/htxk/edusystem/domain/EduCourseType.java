package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 课程类型对象 edu_course_type
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduCourseType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程类型ID
     */
    private Long courseTypeId;

    /**
     * 课程类型名
     */
    @Excel(name = "课程类型名")
    private String courseTypeName;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public Long getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Long courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
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
                .append("courseTypeId", getCourseTypeId())
                .append("courseTypeName", getCourseTypeName())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
