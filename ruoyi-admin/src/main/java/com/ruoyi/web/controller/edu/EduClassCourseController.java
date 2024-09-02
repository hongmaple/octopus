package com.ruoyi.web.controller.edu;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduClassCourse;
import com.ruoyi.edu.service.IEduClassCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 班级课程Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edu/ClassCourse")
public class EduClassCourseController extends BaseController {
    private String prefix = "edu/ClassCourse";

    @Autowired
    private IEduClassCourseService eduClassCourseService;

    @RequiresPermissions("edu:ClassCourse:view")
    @GetMapping()
    public String ClassCourse() {
        return prefix + "/ClassCourse";
    }

    /**
     * 查询班级课程列表
     */
    @RequiresPermissions("edu:ClassCourse:list")
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
    @RequiresPermissions("edu:ClassCourse:export")
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
    @RequiresPermissions("edu:ClassCourse:add")
    @Log(title = "班级课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduClassCourse eduClassCourse) {
        eduClassCourse.setCreateBy(ShiroUtils.getLoginName());
        eduClassCourse.setCreateTime(new Date());
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
    @RequiresPermissions("edu:ClassCourse:edit")
    @Log(title = "班级课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduClassCourse eduClassCourse) {
        eduClassCourse.setUpdateBy(ShiroUtils.getLoginName());
        eduClassCourse.setUpdateTime(new Date());
        return toAjax(eduClassCourseService.updateEduClassCourse(eduClassCourse));
    }

    /**
     * 删除班级课程
     */
    @RequiresPermissions("edu:ClassCourse:remove")
    @Log(title = "班级课程", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduClassCourseService.deleteEduClassCourseByIds(ids));
    }
}
