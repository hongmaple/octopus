package com.ruoyi.web.controller.edu;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduCourse;
import com.ruoyi.edu.service.IEduCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 课程Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edu/course")
public class EduCourseController extends BaseController {
    private String prefix = "edu/course";

    @Autowired
    private IEduCourseService eduCourseService;

    @RequiresPermissions("edu:course:view")
    @GetMapping()
    public String course() {
        return prefix + "/course";
    }

    /**
     * 查询课程列表
     */
    @RequiresPermissions("edu:course:list")
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
    @RequiresPermissions("edu:course:export")
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
    @RequiresPermissions("edu:course:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduCourse eduCourse) {
        eduCourse.setCreateBy(ShiroUtils.getLoginName());
        eduCourse.setCreateTime(new Date());
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
    @RequiresPermissions("edu:course:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduCourse eduCourse) {
        eduCourse.setUpdataBy(ShiroUtils.getLoginName());
        eduCourse.setUpdateTime(new Date());
        return toAjax(eduCourseService.updateEduCourse(eduCourse));
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("edu:course:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduCourseService.deleteEduCourseByIds(ids));
    }
}
