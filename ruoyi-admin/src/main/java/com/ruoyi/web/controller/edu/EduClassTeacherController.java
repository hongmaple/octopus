package com.ruoyi.web.controller.edu;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduClass;
import com.ruoyi.edu.domain.EduClassTeacher;
import com.ruoyi.edu.domain.EduTeacher;
import com.ruoyi.edu.service.IEduClassService;
import com.ruoyi.edu.service.IEduClassTeacherService;
import com.ruoyi.edu.service.IEduTeacherService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 班级教师Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edu/ClassTeacher")
public class EduClassTeacherController extends BaseController {
    private String prefix = "edu/ClassTeacher";

    @Autowired
    private IEduClassTeacherService eduClassTeacherService;

    @Autowired
    private IEduClassService eduClassService;

    @Autowired
    private IEduTeacherService eduTeacherService;

    @RequiresPermissions("edu:ClassTeacher:view")
    @GetMapping()
    public String ClassTeacher() {
        return prefix + "/ClassTeacher";
    }

    /**
     * 查询班级教师列表
     */
    @RequiresPermissions("edu:ClassTeacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduClassTeacher eduClassTeacher) {
        List<EduClassTeacher> list = eduClassTeacherService.selectEduClassTeacherList(eduClassTeacher);
        return getDataTable(list);
    }
    @RequiresPermissions("edu:ClassTeacher1:list1")
    @PostMapping("/list1")
    @ResponseBody
    public TableDataInfo list2(EduClassTeacher eduClassTeacher, ModelMap mmap) {
        List<EduClassTeacher> list = eduClassTeacherService.selectEduClassTeacherList(eduClassTeacher);
        for (EduClassTeacher eduClassTeacher1:list) {
            System.out.println(eduClassTeacher1);
        }
        return getDataTable(list);
    }
    /**
     * 导出班级教师列表
     */
    @RequiresPermissions("edu:ClassTeacher:export")
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
    @RequiresPermissions("edu:ClassTeacher:add")
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
    @RequiresPermissions("edu:ClassTeacher:edit")
    @Log(title = "班级教师", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduClassTeacher eduClassTeacher) {
        eduClassTeacher.setUpdateBy(ShiroUtils.getLoginName());
        eduClassTeacher.setUpdateTime(new Date());
        return toAjax(eduClassTeacherService.updateEduClassTeacher(eduClassTeacher));
    }

    /**
     * 删除班级教师
     */
    @RequiresPermissions("edu:ClassTeacher:remove")
    @Log(title = "班级教师", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduClassTeacherService.deleteEduClassTeacherByIds(ids));
    }
}
