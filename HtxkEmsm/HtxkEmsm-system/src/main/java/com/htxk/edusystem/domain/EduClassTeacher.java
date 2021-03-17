package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 班级教师对象 edu_class_teacher
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduClassTeacher extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级教师ID
     */
    private Long classTeacherId;

    /**
     * 班级名
     */
    @Excel(name = "班级名")
    private Long classTeacherClassId;

    private String class_name;
    /**
     * 教师名
     */
    @Excel(name = "教师名")
    private Long classTeacherTeacherId;

    private String teacher_name;
    //创建者
    private String createBy;
    //更新者
    private String updateBy;

    private Date update_time;
    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "EduClassTeacher{" +
                "classTeacherId=" + classTeacherId +
                ", classTeacherClassId=" + classTeacherClassId +
                ", class_name='" + class_name + '\'' +
                ", classTeacherTeacherId=" + classTeacherTeacherId +
                ", teacher_name='" + teacher_name + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", update_time=" + update_time +
                ", eduTeacherList=" + eduTeacherList +
                ", eduClassList=" + eduClassList +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /***
     * 储存教师信息
     */
    private List<EduTeacher> eduTeacherList;

    /***
     * 储存班级信息
     */
    private List<EduClass> eduClassList;
    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public Long getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(Long classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public Long getClassTeacherClassId() {
        return classTeacherClassId;
    }

    public void setClassTeacherClassId(Long classTeacherClassId) {
        this.classTeacherClassId = classTeacherClassId;
    }

    public Long getClassTeacherTeacherId() {
        return classTeacherTeacherId;
    }

    public void setClassTeacherTeacherId(Long classTeacherTeacherId) {
        this.classTeacherTeacherId = classTeacherTeacherId;
    }

    public List<EduTeacher> getEduTeacherList() {
        return eduTeacherList;
    }

    public void setEduTeacherList(List<EduTeacher> eduTeacherList) {
        this.eduTeacherList = eduTeacherList;
    }

    public List<EduClass> getEduClassList() {
        return eduClassList;
    }

    public void setEduClassList(List<EduClass> eduClassList) {
        this.eduClassList = eduClassList;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}
