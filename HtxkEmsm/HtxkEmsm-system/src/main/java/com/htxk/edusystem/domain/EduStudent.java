package com.htxk.edusystem.domain;

import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.annotation.Excels;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import com.htxk.ruoyi.system.domain.SysUser;
import com.htxk.ruoyi.common.annotation.Excel.Type;
/**
 * 学生信息对象 edu_student
 *
 * @author maple
 * @date 2020-01-03
 */
public class EduStudent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学生信息ID
     */
    private Long studentId;

    /**
     * 学号（格式：年号+开班时间+报名序号）
     */
    @Excel(name = "学号", readConverterExp = "格=式：年号+开班时间+报名序号")
    private String studentNo;

    /**
     * 学生名（学生真实姓名）
     */
    @Excel(name = "学生名", readConverterExp = "学=生真实姓名")
    private String studentName;

    /**
     * 用户id
     */
    @Excel(name = "用户id",type = Type.IMPORT)
    private Long sysUserId;

    /**
     * 所属班级
     */
    @Excel(name = "所属班级",type = Type.IMPORT)
    private Long studentClassID;

    /**
     * 状态（0.在籍1:毕业 2:休学 3:退学）
     */
    @Excel(name = "状态", readConverterExp = "0=在籍,1=毕业,2=休学,3=退学")
    private String status;

    /**
     * 所学专业
     */
    @Excel(name = "所学专业",type = Type.IMPORT)
    private Long studentMajorstudiedid;

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
     * 所学专业名
     */
    @Excel(name = "所学专业名",type = Type.EXPORT)
    private String majorstudiedName;

    /**
     * 所属班级名
     */
    @Excel(name = "所属班级名",type = Type.EXPORT)
    private String className;

    public String getMajorstudiedName() {
        return majorstudiedName;
    }

    public void setMajorstudiedName(String majorstudiedName) {
        this.majorstudiedName = majorstudiedName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getStudentClassID() {
        return studentClassID;
    }

    public void setStudentClassID(Long studentClassID) {
        this.studentClassID = studentClassID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStudentMajorstudiedid() {
        return studentMajorstudiedid;
    }

    public void setStudentMajorstudiedid(Long studentMajorstudiedid) {
        this.studentMajorstudiedid = studentMajorstudiedid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EduStudent{");
        sb.append("studentId=").append(studentId);
        sb.append(", studentNo='").append(studentNo).append('\'');
        sb.append(", studentName='").append(studentName).append('\'');
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", studentClassID=").append(studentClassID);
        sb.append(", status='").append(status).append('\'');
        sb.append(", studentMajorstudiedid=").append(studentMajorstudiedid);
        sb.append(", sysUser=").append(sysUser);
        sb.append(", majorstudiedName='").append(majorstudiedName).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
