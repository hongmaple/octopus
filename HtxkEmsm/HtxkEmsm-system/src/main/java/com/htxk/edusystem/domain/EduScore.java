package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 课程分数对象 edu_score
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduScore extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程分数ID
     */
    private Long scoreId;

    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名")
    private Long scoreStudentid;

    /**
     * 课程名
     */
    @Excel(name = "课程名")
    private Long classCourseCourseId;

    /**
     * 分数
     */
    @Excel(name = "分数")
    private Double score;

    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private String updataBy;

    /**
     * 更新时间
     */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updataTime;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 考试描述（比如期末测评 等等）
     */
    @Excel(name = "考试描述", readConverterExp = "比=如期末测评,等=等")
    private String describe;

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getScoreStudentid() {
        return scoreStudentid;
    }

    public void setScoreStudentid(Long scoreStudentid) {
        this.scoreStudentid = scoreStudentid;
    }

    public Long getClassCourseCourseId() {
        return classCourseCourseId;
    }

    public void setClassCourseCourseId(Long classCourseCourseId) {
        this.classCourseCourseId = classCourseCourseId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("scoreId", getScoreId())
                .append("scoreStudentid", getScoreStudentid())
                .append("classCourseCourseId", getClassCourseCourseId())
                .append("score", getScore())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updataBy", getUpdataBy())
                .append("updataTime", getUpdataTime())
                .append("delFlag", getDelFlag())
                .append("describe", getDescribe())
                .toString();
    }
}
