package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.annotation.Excels;
import com.htxk.ruoyi.common.annotation.Excel.Type;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 班级信息对象 edu_class
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 班级名
     */
    @Excel(name = "班级名")
    private String className;

    /**
     * 开班时间
     */
    @Excel(name = "开班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date classDate;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 班级专业
     */
    private Long classMajor;

    @Excels({
        @Excel(name = "班级专业", targetAttr = "majorStudiedname", type = Type.EXPORT)
    })
    private EduMajor eduMajor;

    public EduMajor getEduMajor() {
        return eduMajor;
    }

    public void setEduMajor(EduMajor eduMajor) {
        this.eduMajor = eduMajor;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getClassMajor() {
        return classMajor;
    }

    public void setClassMajor(Long classMajor) {
        this.classMajor = classMajor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("classId", getClassId())
                .append("className", getClassName())
                .append("classDate", getClassDate())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("classMajor", getClassMajor())
                .toString();
    }
}
