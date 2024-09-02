package com.ruoyi.web.controller.edu;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduPaper;
import com.ruoyi.edu.domain.EduTestRecords;
import com.ruoyi.edu.service.IEduPaperService;
import com.ruoyi.edu.service.IEduTestRecordsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 考试记录Controller
 *
 * @author maple
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/edu/records")
public class EduTestRecordsController extends BaseController {
    private String prefix = "edu/records";

    @Autowired
    private IEduTestRecordsService eduTestRecordsService;
    @Autowired
    private IEduPaperService eduPaperService;

    @RequiresPermissions("edu:records:view")
    @GetMapping()
    public String records() {
        return prefix + "/records";
    }

    /**
     * 查询考试记录列表
     */
    @RequiresPermissions("edu:records:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduTestRecords eduTestRecords) {
        startPage();
        List<EduTestRecords> list = eduTestRecordsService.selectEduTestRecordsList(eduTestRecords);
        return getDataTable(list);
    }
    
    /**
     * 导出考试记录列表
     */
    @RequiresPermissions("edu:records:export")
    @Log(title = "考试记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduTestRecords eduTestRecords) {
        List<EduTestRecords> list = eduTestRecordsService.selectEduTestRecordsList(eduTestRecords);
        ExcelUtil<EduTestRecords> util = new ExcelUtil<EduTestRecords>(EduTestRecords. class);
        return util.exportExcel(list, "records");
    }

    /**
     * 新增考试记录
     */
    @GetMapping("/add")
    public String add() {
            return prefix + "/add";
        }

    /**
     * 答题
     */
    @GetMapping("/examination/{paperId}")
    public String examination(ModelMap mmap, @PathVariable Long paperId) {
        System.out.println(paperId);
        EduPaper eduPaper = eduPaperService.selectEduPaperDetails(paperId);
        mmap.put("paper",eduPaper);
        return prefix + "/examination";
    }
    /**
     * 新增保存考试记录
     */
    @RequiresPermissions("edu:records:add")
    @Log(title = "考试记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduTestRecords eduTestRecords) {
        eduTestRecords.setCreateTime(new Date());
        eduTestRecords.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(eduTestRecordsService.insertEduTestRecords(eduTestRecords));
    }

    /**
     * 修改考试记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        EduTestRecords eduTestRecords =eduTestRecordsService.selectEduTestRecordsById(id);
        mmap.put("eduTestRecords", eduTestRecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存考试记录
     */
    @RequiresPermissions("edu:records:edit")
    @Log(title = "考试记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduTestRecords eduTestRecords) {
        return toAjax(eduTestRecordsService.updateEduTestRecords(eduTestRecords));
    }

    /**
     * 删除考试记录
     */
    @RequiresPermissions("edu:records:remove")
    @Log(title = "考试记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
            return toAjax(eduTestRecordsService.deleteEduTestRecordsByIds(ids));
        }
}
