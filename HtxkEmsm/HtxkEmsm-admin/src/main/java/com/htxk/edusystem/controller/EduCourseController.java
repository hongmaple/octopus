package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduCourse;
import com.htxk.edusystem.service.IEduCourseService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/course")
public class EduCourseController extends BaseController {
    private String prefix = "edusystem/course";

    @Autowired
    private IEduCourseService eduCourseService;

    @RequiresPermissions("edusystem:course:view")
    @GetMapping()
    public String course() {
        return prefix + "/course";
    }

    /**
     * 查询课程列表
     */
    @RequiresPermissions("edusystem:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduCourse eduCourse) {
        startPage();
        List<EduCourse> list = eduCourseService.selectEduCourseList(eduCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @RequiresPermissions("edusystem:course:export")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduCourse eduCourse) {
        List<EduCourse> list = eduCourseService.selectEduCourseList(eduCourse);
        ExcelUtil<EduCourse> util = new ExcelUtil<EduCourse>(EduCourse.class);
        return util.exportExcel(list, "course");
    }

    /**
     * 新增课程
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存课程
     */
    @RequiresPermissions("edusystem:course:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduCourse eduCourse) {
        return toAjax(eduCourseService.insertEduCourse(eduCourse));
    }

    /**
     * 修改课程
     */
    @GetMapping("/edit/{courseId}")
    public String edit(@PathVariable("courseId") Long courseId, ModelMap mmap) {
        EduCourse eduCourse = eduCourseService.selectEduCourseById(courseId);
        mmap.put("eduCourse", eduCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程
     */
    @RequiresPermissions("edusystem:course:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduCourse eduCourse) {
        return toAjax(eduCourseService.updateEduCourse(eduCourse));
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("edusystem:course:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduCourseService.deleteEduCourseByIds(ids));
    }
}
