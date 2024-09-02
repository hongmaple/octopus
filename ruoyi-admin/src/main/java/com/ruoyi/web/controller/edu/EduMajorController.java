package com.ruoyi.web.controller.edu;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduMajor;
import com.ruoyi.edu.service.IEduMajorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专业Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edu/major")
public class EduMajorController extends BaseController {
    private String prefix = "edu/major";

    @Autowired
    private IEduMajorService eduMajorService;

    @RequiresPermissions("edu:major:view")
    @GetMapping()
    public String major() {
        return prefix + "/major";
    }

    /**
     * 查询专业列表
     */
    @RequiresPermissions("edu:major:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduMajor eduMajor) {
        startPage();
        List<EduMajor> list = eduMajorService.selectEduMajorList(eduMajor);
        return getDataTable(list);
    }

    /**
     * 导出专业列表
     */
    @RequiresPermissions("edu:major:export")
    @Log(title = "专业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduMajor eduMajor) {
        List<EduMajor> list = eduMajorService.selectEduMajorList(eduMajor);
        ExcelUtil<EduMajor> util = new ExcelUtil<EduMajor>(EduMajor.class);
        return util.exportExcel(list, "major");
    }

    /**
     * 新增专业
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存专业
     */
    @RequiresPermissions("edu:major:add")
    @Log(title = "专业", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduMajor eduMajor) {
        eduMajor.setCreateBy(ShiroUtils.getLoginName());
        eduMajor.setCreateTime(DateUtils.getNowDate());
        return toAjax(eduMajorService.insertEduMajor(eduMajor));
    }

    /**
     * 修改专业
     */
    @GetMapping("/edit/{majorStudiedid}")
    public String edit(@PathVariable("majorStudiedid") Long majorStudiedid, ModelMap mmap) {
        EduMajor eduMajor = eduMajorService.selectEduMajorById(majorStudiedid);
        mmap.put("eduMajor", eduMajor);
        return prefix + "/edit";
    }

    /**
     * 修改保存专业
     */
    @RequiresPermissions("edu:major:edit")
    @Log(title = "专业", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduMajor eduMajor) {
        eduMajor.setUpdataBy(ShiroUtils.getLoginName());
        eduMajor.setUpdataTime(DateUtils.getNowDate());
        return toAjax(eduMajorService.updateEduMajor(eduMajor));
    }

    /**
     * 删除专业
     */
    @RequiresPermissions("edu:major:remove")
    @Log(title = "专业", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduMajorService.deleteEduMajorByIds(ids));
    }
}
