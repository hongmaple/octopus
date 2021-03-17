package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduClass;
import com.htxk.edusystem.domain.EduClassTeacher;
import com.htxk.edusystem.domain.EduTeacher;
import com.htxk.edusystem.service.IEduClassService;
import com.htxk.edusystem.service.IEduClassTeacherService;
import com.htxk.edusystem.service.IEduTeacherService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.DateUtils;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班级教师Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/ClassTeacher")
public class EduClassTeacherController extends BaseController {
    private String prefix = "edusystem/ClassTeacher";

    @Autowired
    private IEduClassTeacherService eduClassTeacherService;

    @Autowired
    private IEduClassService eduClassService;

    @Autowired
    private IEduTeacherService eduTeacherService;

    @RequiresPermissions("edusystem:ClassTeacher:view")
    @GetMapping()
    public String ClassTeacher() {
        return prefix + "/ClassTeacher";
    }

    /**
     * 查询班级教师列表
     */
    @RequiresPermissions("edusystem:ClassTeacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduClassTeacher eduClassTeacher) {
        List<EduClassTeacher> list = eduClassTeacherService.selectEduClassTeacherList(eduClassTeacher);
        for (EduClassTeacher eduClassTeacher1:list) {
            System.out.println("哈哈");
        }
        return getDataTable(list);
    }
    @RequiresPermissions("edusystem:ClassTeacher1:list1")
    @PostMapping("/list1")
    @ResponseBody
    public TableDataInfo list2(EduClassTeacher eduClassTeacher,ModelMap mmap) {
        List<EduClassTeacher> list = eduClassTeacherService.selectEduClassTeacherList(eduClassTeacher);
        for (EduClassTeacher eduClassTeacher1:list) {
            System.out.println(eduClassTeacher1);
        }
        return getDataTable(list);
    }
    /**
     * 导出班级教师列表
     */
    @RequiresPermissions("edusystem:ClassTeacher:export")
    @Log(title = "班级教师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduClassTeacher eduClassTeacher) {
        List<EduClassTeacher> list = eduClassTeacherService.selectEduClassTeacherList(eduClassTeacher);
        ExcelUtil<EduClassTeacher> util = new ExcelUtil<EduClassTeacher>(EduClassTeacher.class);
        return util.exportExcel(list, "ClassTeacher");
    }

    /**
     * 新增班级教师
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("eduClassList",eduClassService.selectEduClassList(new EduClass()));
        mmap.put("eduTeacherList",eduTeacherService.selectEduTeacherList(new EduTeacher()));
        return prefix + "/add";
    }

    /**
     * 新增保存班级教师
     */
    @RequiresPermissions("edusystem:ClassTeacher:add")
    @Log(title = "班级教师", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduClassTeacher eduClassTeacher) {
        eduClassTeacher.setCreateBy(ShiroUtils.getLoginName());
        eduClassTeacher.setCreateTime(DateUtils.getNowDate());
        return toAjax(eduClassTeacherService.insertEduClassTeacher(eduClassTeacher));
    }

    /**
     * 修改班级教师
     */
    @GetMapping("/edit/{classTeacherId}")
    public String edit(@PathVariable("classTeacherId") Long classTeacherId, ModelMap mmap) {
        EduClassTeacher eduClassTeacher = eduClassTeacherService.selectEduClassTeacherById(classTeacherId);
        mmap.put("eduClassTeacher", eduClassTeacher);
        mmap.put("eduClassList",eduClassService.selectEduClassList(new EduClass()));
        mmap.put("eduTeacherList",eduTeacherService.selectEduTeacherList(new EduTeacher()));
        mmap.put("eduClassTeacherList",eduClassTeacherService.selectEduClassTeacherList(new EduClassTeacher()));
        return prefix + "/edit";
    }

    /**
     * 修改保存班级教师
     */
    @RequiresPermissions("edusystem:ClassTeacher:edit")
    @Log(title = "班级教师", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduClassTeacher eduClassTeacher) {
        return toAjax(eduClassTeacherService.updateEduClassTeacher(eduClassTeacher));
    }

    /**
     * 删除班级教师
     */
    @RequiresPermissions("edusystem:ClassTeacher:remove")
    @Log(title = "班级教师", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduClassTeacherService.deleteEduClassTeacherByIds(ids));
    }
}
