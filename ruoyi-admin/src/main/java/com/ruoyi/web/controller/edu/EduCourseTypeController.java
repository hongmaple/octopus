package com.ruoyi.web.controller.edu;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduCourseType;
import com.ruoyi.edu.service.IEduCourseTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 课程类型Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edu/CourseType")
public class EduCourseTypeController extends BaseController {
    private String prefix = "edu/CourseType";

    @Autowired
    private IEduCourseTypeService eduCourseTypeService;

    @RequiresPermissions("edu:CourseType:view")
    @GetMapping()
    public String CourseType() {
        return prefix + "/CourseType";
    }

    /**
     * 查询课程类型列表
     */
    @RequiresPermissions("edu:CourseType:list")
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
    @RequiresPermissions("edu:CourseType:export")
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
    @RequiresPermissions("edu:CourseType:add")
    @Log(title = "课程类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduCourseType eduCourseType) {
        eduCourseType.setCreateBy(ShiroUtils.getLoginName());
        eduCourseType.setCreateTime(new Date());
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
    @RequiresPermissions("edu:CourseType:edit")
    @Log(title = "课程类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduCourseType eduCourseType) {
        eduCourseType.setUpdateBy(ShiroUtils.getLoginName());
        eduCourseType.setUpdateTime(new Date());
        return toAjax(eduCourseTypeService.updateEduCourseType(eduCourseType));
    }

    /**
     * 删除课程类型
     */
    @RequiresPermissions("edu:CourseType:remove")
    @Log(title = "课程类型", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduCourseTypeService.deleteEduCourseTypeByIds(ids));
    }
}
