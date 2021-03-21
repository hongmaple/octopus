package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduClass;
import com.htxk.edusystem.domain.EduMajor;
import com.htxk.edusystem.service.IEduClassService;
import com.htxk.edusystem.service.IEduMajorService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.DateUtils;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import com.mchange.lang.ShortUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级信息Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/class")
public class EduClassController extends BaseController {
    private String prefix = "edusystem/class";

    @Autowired
    private IEduClassService eduClassService;

    @Autowired
    private IEduMajorService eduMajorService;

    @RequiresPermissions("edusystem:class:view")
    @GetMapping()
    public String educlass(ModelMap mmap) {
        mmap.put("eduMajors",eduMajorService.selectEduMajorList(new EduMajor()));
        return prefix + "/class";
    }

    /**
     * 查询班级信息列表
     */
    @RequiresPermissions("edusystem:class:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduClass eduClass) {
        startPage();
        List<EduClass> list = eduClassService.selectEduClassList(eduClass);
        return getDataTable(list);
    }

    /**
     * 导出班级信息列表
     */
    @RequiresPermissions("edusystem:class:export")
    @Log(title = "班级信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduClass eduClass) {
        List<EduClass> list = eduClassService.selectEduClassList(eduClass);
        ExcelUtil<EduClass> util = new ExcelUtil<EduClass>(EduClass.class);
        return util.exportExcel(list, "class");
    }

    /**
     * 新增班级信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("eduMajors",eduMajorService.selectEduMajorList(new EduMajor()));
        return prefix + "/add";
    }

    /**
     * 新增保存班级信息
     */
    @RequiresPermissions("edusystem:class:add")
    @Log(title = "班级信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduClass eduClass) {
        eduClass.setCreateBy(ShiroUtils.getLoginName());
        eduClass.setCreateTime(DateUtils.getNowDate());
        return toAjax(eduClassService.insertEduClass(eduClass));
    }

    /**
     * 修改班级信息
     */
    @GetMapping("/edit/{classId}")
    public String edit(@PathVariable("classId") Long classId, ModelMap mmap) {
        EduClass eduClass = eduClassService.selectEduClassById(classId);
        mmap.put("eduClass", eduClass);
        mmap.put("eduMajors",eduMajorService.selectEduMajorList(new EduMajor()));
        return prefix + "/edit";
    }

    /**
     * 修改保存班级信息
     */
    @RequiresPermissions("edusystem:class:edit")
    @Log(title = "班级信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduClass eduClass) {
        eduClass.setUpdateBy(ShiroUtils.getLoginName());
        eduClass.setUpdateTime(DateUtils.getNowDate());
        return toAjax(eduClassService.updateEduClass(eduClass));
    }

    /**
     * 删除班级信息
     */
    @RequiresPermissions("edusystem:class:remove")
    @Log(title = "班级信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduClassService.deleteEduClassByIds(ids));
    }
}
