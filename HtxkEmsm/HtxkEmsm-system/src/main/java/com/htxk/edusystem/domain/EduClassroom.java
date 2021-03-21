package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教室对象 edu_classroom
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduClassroom extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 教室ID
     */
    private Long classroomId;

    /**
     * 教室地址
     */
    @Excel(name = "教室地址")
    private String classroomAddress;

    /**
     * 教室容量 单位人
     */
    @Excel(name = "教室容量 单位人")
    private Long classroomCapacity;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomAddress() {
        return classroomAddress;
    }

    public void setClassroomAddress(String classroomAddress) {
        this.classroomAddress = classroomAddress;
    }

    public Long getClassroomCapacity() {
        return classroomCapacity;
    }

    public void setClassroomCapacity(Long classroomCapacity) {
        this.classroomCapacity = classroomCapacity;
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
                .append("classroomId", getClassroomId())
                .append("classroomAddress", getClassroomAddress())
                .append("classroomCapacity", getClassroomCapacity())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
