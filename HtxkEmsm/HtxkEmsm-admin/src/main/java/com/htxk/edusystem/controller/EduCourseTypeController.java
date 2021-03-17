package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduCourseType;
import com.htxk.edusystem.service.IEduCourseTypeService;
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
 * 课程类型Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/CourseType")
public class EduCourseTypeController extends BaseController {
    private String prefix = "edusystem/CourseType";

    @Autowired
    private IEduCourseTypeService eduCourseTypeService;

    @RequiresPermissions("edusystem:CourseType:view")
    @GetMapping()
    public String CourseType() {
        return prefix + "/CourseType";
    }

    /**
     * 查询课程类型列表
     */
    @RequiresPermissions("edusystem:CourseType:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduCourseType eduCourseType) {
        startPage();
        List<EduCourseType> list = eduCourseTypeService.selectEduCourseTypeList(eduCourseType);
        return getDataTable(list);
    }

    /**
     * 导出课程类型列表
     */
    @RequiresPermissions("edusystem:CourseType:export")
    @Log(title = "课程类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduCourseType eduCourseType) {
        List<EduCourseType> list = eduCourseTypeService.selectEduCourseTypeList(eduCourseType);
        ExcelUtil<EduCourseType> util = new ExcelUtil<EduCourseType>(EduCourseType.class);
        return util.exportExcel(list, "CourseType");
    }

    /**
     * 新增课程类型
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存课程类型
     */
    @RequiresPermissions("edusystem:CourseType:add")
    @Log(title = "课程类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduCourseType eduCourseType) {
        return toAjax(eduCourseTypeService.insertEduCourseType(eduCourseType));
    }

    /**
     * 修改课程类型
     */
    @GetMapping("/edit/{courseTypeId}")
    public String edit(@PathVariable("courseTypeId") Long courseTypeId, ModelMap mmap) {
        EduCourseType eduCourseType = eduCourseTypeService.selectEduCourseTypeById(courseTypeId);
        mmap.put("eduCourseType", eduCourseType);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程类型
     */
    @RequiresPermissions("edusystem:CourseType:edit")
    @Log(title = "课程类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduCourseType eduCourseType) {
        return toAjax(eduCourseTypeService.updateEduCourseType(eduCourseType));
    }

    /**
     * 删除课程类型
     */
    @RequiresPermissions("edusystem:CourseType:remove")
    @Log(title = "课程类型", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduCourseTypeService.deleteEduCourseTypeByIds(ids));
    }
}
