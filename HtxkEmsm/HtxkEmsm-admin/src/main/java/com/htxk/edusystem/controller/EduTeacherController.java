package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduStudent;
import com.htxk.edusystem.domain.EduTeacher;
import com.htxk.edusystem.service.IEduTeacherService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.constant.UserConstants;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.shiro.service.SysPasswordService;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import com.htxk.ruoyi.system.domain.SysUser;
import com.htxk.ruoyi.system.service.ISysDeptService;
import com.htxk.ruoyi.system.service.ISysPostService;
import com.htxk.ruoyi.system.service.ISysRoleService;
import com.htxk.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教师信息Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/teacher")
public class EduTeacherController extends BaseController {
    private String prefix = "edusystem/teacher";

    @Autowired
    private IEduTeacherService eduTeacherService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("edusystem:teacher:view")
    @GetMapping()
    public String teacher() {
        return prefix + "/teacher";
    }

    /**
     * 查询教师信息列表
     */
    @RequiresPermissions("edusystem:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduTeacher eduTeacher) {
        startPage();
        List<EduTeacher> list = eduTeacherService.selectEduTeacherList(eduTeacher);
        for (EduTeacher teacher : list) {
            teacher.setSysUser(sysUserService.selectUserById(teacher.getSysUserId()));
        }
        return getDataTable(list);
    }

    /**
     * 导出教师信息列表
     */
    @RequiresPermissions("edusystem:teacher:export")
    @Log(title = "教师信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduTeacher eduTeacher) {
        List<EduTeacher> list = eduTeacherService.selectEduTeacherList(eduTeacher);
        for (EduTeacher teacher:list){
            SysUser user = sysUserService.selectUserById(teacher.getSysUserId());
            teacher.setSysUser(user);
            teacher.setSysDept(deptService.selectDeptById(user.getDeptId()));
        }
        ExcelUtil<EduTeacher> util = new ExcelUtil<>(EduTeacher.class);
        return util.exportExcel(list, "teacher");
    }

    /**
     * 新增教师信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("roles", roleService.selectRoleAll());
        mmap.put("posts", postService.selectPostAll());
        return prefix + "/add";
    }

    /**
     * 新增保存教师信息
     */
    @RequiresPermissions("edusystem:teacher:add")
    @Log(title = "教师信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    //事务注解
    @Transactional
    public AjaxResult addSave(@Validated EduTeacher eduTeacher) {
        SysUser user = eduTeacher.getSysUser();
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(sysUserService.checkLoginNameUnique(user.getLoginName()))) {
            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        } else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserService.checkPhoneUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserService.checkEmailUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        user.setCreateBy(ShiroUtils.getLoginName());
        //把账号类型设置为教师类型
        user.setUserType("03");
        sysUserService.insertUser(user);
        eduTeacher.setSysUserId(sysUserService.selectOidBySELECT_LAST_INSERT_ID());
        return toAjax(eduTeacherService.insertEduTeacher(eduTeacher));
    }

    /**
     * 修改教师信息
     */
    @GetMapping("/edit/{teacherId}")
    public String edit(@PathVariable("teacherId") Long teacherId, ModelMap mmap) {
        EduTeacher eduTeacher = eduTeacherService.selectEduTeacherById(teacherId);
        eduTeacher.setSysUser(sysUserService.selectUserById(eduTeacher.getSysUserId()));
        mmap.put("eduTeacher", eduTeacher);
        mmap.put("roles", roleService.selectRolesByUserId(eduTeacher.getSysUserId()));
        mmap.put("posts", postService.selectPostsByUserId(eduTeacher.getSysUserId()));
        return prefix + "/edit";
    }

    /**
     * 修改保存教师信息
     */
    @RequiresPermissions("edusystem:teacher:edit")
    @Log(title = "教师信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    //事务注解
    @Transactional
    public AjaxResult editSave(EduTeacher eduTeacher) {
        SysUser user = eduTeacher.getSysUser();
        sysUserService.checkUserAllowed(user);//校验用户是否允许操作
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserService.checkPhoneUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserService.checkEmailUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(ShiroUtils.getLoginName());
        sysUserService.updateUser(user);
        return toAjax(eduTeacherService.updateEduTeacher(eduTeacher));
    }

    /**
     * 删除教师信息
     */
    @RequiresPermissions("edusystem:teacher:remove")
    @Log(title = "教师信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        for (String tid : Convert.toStrArray(ids)){
            sysUserService.deleteUserById(eduTeacherService.selectEduTeacherById(Long.valueOf(tid)).getSysUserId());
        }
        return toAjax(eduTeacherService.deleteEduTeacherByIds(ids));
    }
}
