package com.ruoyi.web.controller.edu;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduTeacher;
import com.ruoyi.edu.service.IEduTeacherService;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 教师信息Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edu/teacher")
public class EduTeacherController extends BaseController {
    private String prefix = "edu/teacher";

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

    @RequiresPermissions("edu:teacher:view")
    @GetMapping()
    public String teacher() {
        return prefix + "/teacher";
    }

    /**
     * 查询教师信息列表
     */
    @RequiresPermissions("edu:teacher:list")
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
    @RequiresPermissions("edu:teacher:export")
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
    @RequiresPermissions("edu:teacher:add")
    @Log(title = "教师信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addSave(@Validated EduTeacher eduTeacher) {
        SysUser user = eduTeacher.getSysUser();
        if (sysUserService.checkLoginNameUnique(user)) {
            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        } else if (sysUserService.checkPhoneUnique(user)) {
            return error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (sysUserService.checkEmailUnique(user)) {
            return error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        //设置修改时间
        user.setCreateTime(new Date());
        user.setCreateBy(ShiroUtils.getLoginName());
        //把账号类型设置为教师类型
        user.setUserType("03");
        sysUserService.insertUser(user);
        eduTeacher.setSysUserId(user.getUserId());
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
    @RequiresPermissions("edu:teacher:edit")
    @Log(title = "教师信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult editSave(EduTeacher eduTeacher) {
        SysUser user = eduTeacher.getSysUser();
        //校验用户是否允许操作
        sysUserService.checkUserAllowed(user);
        if (sysUserService.checkPhoneUnique(user)) {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (sysUserService.checkEmailUnique(user)) {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateTime(new Date());
        user.setUpdateBy(ShiroUtils.getLoginName());
        sysUserService.updateUser(user);
        return toAjax(eduTeacherService.updateEduTeacher(eduTeacher));
    }

    /**
     * 删除教师信息
     */
    @RequiresPermissions("edu:teacher:remove")
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
