package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduClass;
import com.htxk.edusystem.domain.EduMajor;
import com.htxk.edusystem.domain.EduStudent;
import com.htxk.edusystem.service.IEduClassService;
import com.htxk.edusystem.service.IEduMajorService;
import com.htxk.edusystem.service.IEduStudentService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.constant.UserConstants;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.DateUtils;
import com.htxk.ruoyi.common.utils.StringUtils;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.shiro.service.SysPasswordService;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import com.htxk.ruoyi.system.domain.SysUser;
import com.htxk.ruoyi.system.service.ISysRoleService;
import com.htxk.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生信息Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/student")
public class EduStudentController extends BaseController {
    private String prefix = "edusystem/student";

    @Autowired
    private IEduStudentService eduStudentService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private IEduMajorService eduMajorService;

    @Autowired
    private IEduClassService eduClassService;

    @RequiresPermissions("edusystem:student:view")
    @GetMapping()
    public String student(ModelMap mmap) {
        mmap.put("classList",eduClassService.selectEduClassList(new EduClass()));
        mmap.put("majorList",eduMajorService.selectEduMajorList(new EduMajor()));
        return prefix + "/student";
    }

    /**
     * 查询学生信息列表
     */
    @RequiresPermissions("edusystem:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduStudent eduStudent) {
        startPage();
        List<EduStudent> list = eduStudentService.selectEduStudentList(eduStudent);
        for (EduStudent student : list){
              student.setSysUser(sysUserService.selectUserById(student.getSysUserId()));
        }
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @RequiresPermissions("edusystem:student:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduStudent eduStudent) {
        List<EduStudent> list = eduStudentService.selectEduStudentList(eduStudent);
        for (EduStudent student:list){
            SysUser user = sysUserService.selectUserById(student.getSysUserId());
            student.setSysUser(user);
        }
        ExcelUtil<EduStudent> util = new ExcelUtil<>(EduStudent.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 新增学生信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("roles", roleService.selectRoleAll());
        mmap.put("classTrees",eduMajorService.selectEduMajorAllList(new EduMajor()));
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息
     */
    @RequiresPermissions("edusystem:student:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Transactional
    public AjaxResult addSave(EduStudent eduStudent) {
        System.out.println(eduStudent);
        SysUser user = eduStudent.getSysUser();
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(sysUserService.checkLoginNameUnique(user.getLoginName()))) {
            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        } else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserService.checkPhoneUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserService.checkEmailUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        //设置学号和登录账号
        String loginname_studenNo = DateUtils.parseDateToStr("yyyyMMddmmss",DateUtils.getNowDate());
        user.setSalt(ShiroUtils.randomSalt());
        user.setLoginName(loginname_studenNo);
        user.setPassword(StringUtils.substring(user.getPhonenumber(),5));
        user.setPassword(passwordService.encryptPassword(user.getLoginName(),user.getPassword() , user.getSalt()));
        user.setCreateBy(ShiroUtils.getLoginName());
        //把账号类型设置为学生类型
        user.setUserType("02");
        sysUserService.insertUser(user);
        EduClass eduClass = eduClassService.selectEduClassById(eduStudent.getStudentClassID());
        eduStudent.setStudentNo(loginname_studenNo);
        eduStudent.setStudentMajorstudiedid(eduClass.getClassMajor());
        eduStudent.setSysUserId(sysUserService.selectOidBySELECT_LAST_INSERT_ID());
        return toAjax(eduStudentService.insertEduStudent(eduStudent));
    }

    /**
     * 修改学生信息
     */
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") Long studentId, ModelMap mmap) {
        EduStudent eduStudent = eduStudentService.selectEduStudentById(studentId);
        eduStudent.setSysUser(sysUserService.selectUserById(eduStudent.getSysUserId()));
        //查询角色
        mmap.put("roles", roleService.selectRolesByUserId(eduStudent.getSysUserId()));
        //查询班级与专业
        mmap.put("classTrees",eduMajorService.selectEduMajorAllList(new EduMajor()));
        mmap.put("eduStudent", eduStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @RequiresPermissions("edusystem:student:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Transactional
    public AjaxResult editSave(EduStudent eduStudent) {
        SysUser user = eduStudent.getSysUser();
        sysUserService.checkUserAllowed(user);//校验用户是否允许操作
        System.out.println(eduStudent);
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserService.checkPhoneUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserService.checkEmailUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(ShiroUtils.getLoginName());
        sysUserService.updateUser(user);
        EduClass eduClass = eduClassService.selectEduClassById(eduStudent.getStudentClassID());
        eduStudent.setStudentMajorstudiedid(eduClass.getClassMajor());
        return toAjax(eduStudentService.updateEduStudent(eduStudent));
    }

    /**
     * 删除学生信息
     */
    @RequiresPermissions("edusystem:student:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        for (String sid:Convert.toStrArray(ids)){
            //根据用户账号id删除账号信息
            sysUserService.deleteUserById(eduStudentService.selectEduStudentById(Convert.toLong(sid)).getSysUserId());
        }
        return toAjax(eduStudentService.deleteEduStudentByIds(ids));
    }
}
