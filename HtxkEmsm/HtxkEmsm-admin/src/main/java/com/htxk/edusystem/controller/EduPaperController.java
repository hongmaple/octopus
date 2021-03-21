package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduPaper;
import com.htxk.edusystem.service.IEduPaperService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.domain.Ztree;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.StringUtils;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 试卷Controller
 *
 * @author maple
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/edusystem/paper")
public class EduPaperController extends BaseController {
    private String prefix = "edusystem/paper";

    @Autowired
    private IEduPaperService eduPaperService;

    @RequiresPermissions("edusystem:paper:view")
    @GetMapping()
    public String paper() {
        return prefix + "/paper";
    }

    /**
     * 查询试卷列表
     */
    @RequiresPermissions("edusystem:paper:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduPaper eduPaper) {
        startPage();
        List<EduPaper> list = eduPaperService.selectEduPaperList(eduPaper);
        return getDataTable(list);
    }

    /**
     * 导出试卷列表
     */
    @RequiresPermissions("edusystem:paper:export")
    @Log(title = "试卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduPaper eduPaper) {
        List<EduPaper> list = eduPaperService.selectEduPaperList(eduPaper);
        ExcelUtil<EduPaper> util = new ExcelUtil<EduPaper>(EduPaper.class);
        return util.exportExcel(list, "paper");
    }

    /**
     * 新增试卷
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存试卷
     */
    @RequiresPermissions("edusystem:paper:add")
    @Log(title = "试卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduPaper eduPaper) {
        eduPaper.setCreateBy(ShiroUtils.getLoginName());
        eduPaper.setCreateTime(new Date());
        return toAjax(eduPaperService.insertEduPaper(eduPaper));
    }

    /**
     * 修改试卷
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        EduPaper eduPaper = eduPaperService.selectEduPaperById(id);
        mmap.put("eduPaper", eduPaper);
        return prefix + "/edit";
    }

    /**
     * 修改保存试卷
     */
    @RequiresPermissions("edusystem:paper:edit")
    @Log(title = "试卷", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduPaper eduPaper) {
        eduPaper.setUpdateBy(ShiroUtils.getLoginName());
        eduPaper.setUpdateTime(new Date());
        return toAjax(eduPaperService.updateEduPaper(eduPaper));
    }

    /**
     * 删除试卷
     */
    @RequiresPermissions("edusystem:paper:remove")
    @Log(title = "试卷", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduPaperService.deleteEduPaperByIds(ids));
    }
}
