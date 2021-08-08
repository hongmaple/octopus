package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.eduTeachingMaterial;
import com.htxk.edusystem.service.IeduTeachingMaterialService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.config.Global;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.domain.Ztree;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.StringUtils;
import com.htxk.ruoyi.common.utils.file.FileUploadUtils;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import com.htxk.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件Controller
 *
 * @author maple
 * @date 2021-03-21
 */
@Controller
@RequestMapping("/edusystem/teachingMaterial")
public class eduTeachingMaterialController extends BaseController {
    private String prefix = "edusystem/teachingMaterial";

    @Autowired
    private IeduTeachingMaterialService eduTeachingMaterialService;

    @RequiresPermissions("edusystem:teachingMaterial:view")
    @GetMapping()
    public String teachingMaterial() {
        return prefix + "/teachingMaterial";
    }

    /**
     * 查询文件列表
     */
    @RequiresPermissions("edusystem:teachingMaterial:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(eduTeachingMaterial eduTeachingMaterial) {
        startPage();
        List<eduTeachingMaterial> list = eduTeachingMaterialService.selecteduTeachingMaterialList(eduTeachingMaterial);
        return getDataTable(list);
    }

    /**
     * 导出文件列表
     */
    @RequiresPermissions("edusystem:teachingMaterial:export")
    @Log(title = "文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(eduTeachingMaterial eduTeachingMaterial) {
        List<eduTeachingMaterial> list = eduTeachingMaterialService.selecteduTeachingMaterialList(eduTeachingMaterial);
        ExcelUtil<eduTeachingMaterial> util = new ExcelUtil<eduTeachingMaterial>(eduTeachingMaterial.class);
        return util.exportExcel(list, "teachingMaterial");
    }

    /**
     * 新增文件
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文件
     */
    @RequiresPermissions("edusystem:teachingMaterial:add")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(eduTeachingMaterial eduTeachingMaterial) {
        return toAjax(eduTeachingMaterialService.inserteduTeachingMaterial(eduTeachingMaterial));
    }

    /**
     * 修改文件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        eduTeachingMaterial eduTeachingMaterial = eduTeachingMaterialService.selecteduTeachingMaterialById(id);
        mmap.put("eduTeachingMaterial", eduTeachingMaterial);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件
     */
    @RequiresPermissions("edusystem:teachingMaterial:edit")
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(eduTeachingMaterial eduTeachingMaterial) {
        return toAjax(eduTeachingMaterialService.updateeduTeachingMaterial(eduTeachingMaterial));
    }

    /**
     * 删除文件
     */
    @RequiresPermissions("edusystem:teachingMaterial:remove")
    @Log(title = "文件", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduTeachingMaterialService.deleteeduTeachingMaterialByIds(ids));
    }

    /**
     * 保存头像
     */
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("url") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String url = FileUploadUtils.upload(Global.getMaterial(), file);
                return AjaxResult.success(url);
            }
            return error();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}
