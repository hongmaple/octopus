package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.annotation.Excels;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import com.htxk.ruoyi.system.domain.SysDept;
import com.htxk.ruoyi.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.htxk.ruoyi.common.annotation.Excel.Type;

/**
 * 教师信息对象 edu_teacher
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduTeacher extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 教师信息ID
     */
    private Long teacherId;

    /**
     * 用户名（老师真实姓名）
     */
    @Excel(name = "教师名")
    private String teacherName;

    /**
     * 用户id
     */
    private Long sysUserId;

    /**
     * 学历（0.高中1.大专.2.本科3.研究生）
     */
    @Excel(name = "学历", readConverterExp = "0=高中,1=大专,2=本科,3=研究生")
    private String education;

    /**
     * 职称（0.一级教师，1.二级教师，2.三级教师）
     */
    @Excel(name = "职称", readConverterExp = "0=一级教师,1=二级教师,2=三级教师")
    private String academicTitle;

    /**
     * 状态（0.在职 1.离职）
     */
    @Excel(name = "状态", readConverterExp = "0=在职,1=离职")
    private String status;

    /**
     * 用户账号信息
     */
    @Excels({
            @Excel(name = "登录名称",targetAttr = "loginName",type = Type.EXPORT),
            @Excel(name = "昵称",targetAttr = "userName",type = Type.EXPORT),
            @Excel(name = "邮箱",targetAttr = "email",type = Type.EXPORT),
            @Excel(name = "手机号码",targetAttr = "phonenumber",type = Type.EXPORT),
            @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知",targetAttr = "sex",type = Type.EXPORT),
            @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用",targetAttr = "status",type = Type.EXPORT),
    })
    private SysUser sysUser;

    /**
     * 部门信息
     */
    /**
     * 部门对象
     */
    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept sysDept;

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("teacherId", getTeacherId())
                .append("teacherName", getTeacherName())
                .append("sysUserId", getSysUserId())
                .append("education", getEducation())
                .append("academicTitle", getAcademicTitle())
                .append("status", getStatus())
                .toString();
    }
}
