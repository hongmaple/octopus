package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 专业对象 edu_major
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduMajor extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 专业id
     */
    private Long majorStudiedid;

    /**
     * 专业名
     */
    @Excel(name = "专业名")
    private String majorStudiedname;

    /**
     * 专业描述
     */
    @Excel(name = "专业描述")
    private String describe;

    /**
     * 更新者
     */
    private String updataBy;

    /**
     * 更新时间
     */
    private Date updataTime;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 存储有此专业的班级
     */
    private List<EduClass> eduClasses;


    public List<EduClass> getEduClasses() {
        return eduClasses;
    }

    public void setEduClasses(List<EduClass> eduClasses) {
        this.eduClasses = eduClasses;
    }

    public Long getMajorStudiedid() {
        return majorStudiedid;
    }

    public void setMajorStudiedid(Long majorStudiedid) {
        this.majorStudiedid = majorStudiedid;
    }

    public String getMajorStudiedname() {
        return majorStudiedname;
    }

    public void setMajorStudiedname(String majorStudiedname) {
        this.majorStudiedname = majorStudiedname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUpdataBy() {
        return updataBy;
    }

    public void setUpdataBy(String updataBy) {
        this.updataBy = updataBy;
    }

    public Date getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(Date updataTime) {
        this.updataTime = updataTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EduMajor{");
        sb.append("majorStudiedid=").append(majorStudiedid);
        sb.append(", majorStudiedname='").append(majorStudiedname).append('\'');
        sb.append(", describe='").append(describe).append('\'');
        sb.append(", updataBy='").append(updataBy).append('\'');
        sb.append(", updataTime=").append(updataTime);
        sb.append(", delFlag='").append(delFlag).append('\'');
        sb.append(", eduClasses=").append(eduClasses);
        sb.append('}');
        return sb.toString();
    }
}
