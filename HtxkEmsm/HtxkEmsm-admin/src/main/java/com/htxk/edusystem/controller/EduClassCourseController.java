package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduClassCourse;
import com.htxk.edusystem.service.IEduClassCourseService;
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
 * 班级课程Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/ClassCourse")
public class EduClassCourseController extends BaseController {
    private String prefix = "edusystem/ClassCourse";

    @Autowired
    private IEduClassCourseService eduClassCourseService;

    @RequiresPermissions("edusystem:ClassCourse:view")
    @GetMapping()
    public String ClassCourse() {
        return prefix + "/ClassCourse";
    }

    /**
     * 查询班级课程列表
     */
    @RequiresPermissions("edusystem:ClassCourse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduClassCourse eduClassCourse) {
        startPage();
        List<EduClassCourse> list = eduClassCourseService.selectEduClassCourseList(eduClassCourse);
        return getDataTable(list);
    }

    /**
     * 导出班级课程列表
     */
    @RequiresPermissions("edusystem:ClassCourse:export")
    @Log(title = "班级课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduClassCourse eduClassCourse) {
        List<EduClassCourse> list = eduClassCourseService.selectEduClassCourseList(eduClassCourse);
        ExcelUtil<EduClassCourse> util = new ExcelUtil<EduClassCourse>(EduClassCourse.class);
        return util.exportExcel(list, "ClassCourse");
    }

    /**
     * 新增班级课程
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存班级课程
     */
    @RequiresPermissions("edusystem:ClassCourse:add")
    @Log(title = "班级课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduClassCourse eduClassCourse) {
        return toAjax(eduClassCourseService.insertEduClassCourse(eduClassCourse));
    }

    /**
     * 修改班级课程
     */
    @GetMapping("/edit/{classCourseId}")
    public String edit(@PathVariable("classCourseId") Long classCourseId, ModelMap mmap) {
        EduClassCourse eduClassCourse = eduClassCourseService.selectEduClassCourseById(classCourseId);
        mmap.put("eduClassCourse", eduClassCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存班级课程
     */
    @RequiresPermissions("edusystem:ClassCourse:edit")
    @Log(title = "班级课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduClassCourse eduClassCourse) {
        return toAjax(eduClassCourseService.updateEduClassCourse(eduClassCourse));
    }

    /**
     * 删除班级课程
     */
    @RequiresPermissions("edusystem:ClassCourse:remove")
    @Log(title = "班级课程", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduClassCourseService.deleteEduClassCourseByIds(ids));
    }
}
