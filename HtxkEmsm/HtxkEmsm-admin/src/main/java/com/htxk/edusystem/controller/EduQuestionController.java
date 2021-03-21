package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduQuestion;
import com.htxk.edusystem.service.IEduQuestionService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.domain.Ztree;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.StringUtils;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 题库Controller
 *
 * @author maple
 * @date 2021-03-18
 */
@Api(tags = "题库管理")
@Controller
@RequestMapping("/edusystem/question")
public class EduQuestionController extends BaseController {
    private String prefix = "edusystem/question";

    @Autowired
    private IEduQuestionService eduQuestionService;

    @RequiresPermissions("edusystem:question:view")
    @GetMapping()
    public String question() {
        return prefix + "/question";
    }

    /**
     * 查询题库列表
     */
    @ApiOperation("查询题库列表")
    @RequiresPermissions("edusystem:question:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduQuestion eduQuestion) {
        startPage();
        List<EduQuestion> list = eduQuestionService.selectEduQuestionList(eduQuestion);
        return getDataTable(list);
    }

    /**
     * 查询题库
     *
     * @param id 题库ID
     * @return 题库
     */
    @ApiOperation("查询题目")
    @RequiresPermissions("edusystem:question:byId")
    @GetMapping("/{id}")
    @ResponseBody
    public EduQuestion selectEduQuestionById(@PathVariable Long id) {
        return eduQuestionService.selectEduQuestionById(id);
    }

    /**
     * 导出题库列表
     */
    @ApiOperation("导出题库列表")
    @RequiresPermissions("edusystem:question:export")
    @Log(title = "题库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduQuestion eduQuestion) {
        List<EduQuestion> list = eduQuestionService.selectEduQuestionList(eduQuestion);
        ExcelUtil<EduQuestion> util = new ExcelUtil<EduQuestion>(EduQuestion.class);
        return util.exportExcel(list, "question");
    }

    /**
     * 新增题库
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存题库
     */
    @ApiOperation("新增保存题库")
    @RequiresPermissions("edusystem:question:add")
    @Log(title = "题库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduQuestion eduQuestion) {
        eduQuestion.setCreateBy(ShiroUtils.getLoginName());
        eduQuestion.setCreateTime(new Date());
        return toAjax(eduQuestionService.insertEduQuestion(eduQuestion));
    }

    /**
     * 修改题库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        EduQuestion eduQuestion = eduQuestionService.selectEduQuestionById(id);
        mmap.put("eduQuestion", eduQuestion);
        return prefix + "/edit";
    }

    /**
     * 修改保存题库
     */
    @ApiOperation("修改保存题库")
    @RequiresPermissions("edusystem:question:edit")
    @Log(title = "题库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduQuestion eduQuestion) {
        eduQuestion.setUpdateBy(ShiroUtils.getLoginName());
        eduQuestion.setUpdateTime(new Date());
        return toAjax(eduQuestionService.updateEduQuestion(eduQuestion));
    }

    /**
     * 删除题库
     */
    @ApiOperation("删除题库")
    @RequiresPermissions("edusystem:question:remove")
    @Log(title = "题库", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduQuestionService.deleteEduQuestionByIds(ids));
    }
}
