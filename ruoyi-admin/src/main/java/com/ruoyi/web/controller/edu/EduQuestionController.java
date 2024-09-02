package com.ruoyi.web.controller.edu;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduQuestion;
import com.ruoyi.edu.service.IEduQuestionService;
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
@RequestMapping("/edu/question")
public class EduQuestionController extends BaseController {
    private String prefix = "edu/question";

    @Autowired
    private IEduQuestionService eduQuestionService;

    @RequiresPermissions("edu:question:view")
    @GetMapping()
    public String question() {
        return prefix + "/question";
    }

    /**
     * 查询题库列表
     */
    @ApiOperation("查询题库列表")
    @RequiresPermissions("edu:question:list")
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
    @RequiresPermissions("edu:question:byId")
    @GetMapping("/{id}")
    @ResponseBody
    public EduQuestion selectEduQuestionById(@PathVariable Long id) {
        return eduQuestionService.selectEduQuestionById(id);
    }

    /**
     * 导出题库列表
     */
    @ApiOperation("导出题库列表")
    @RequiresPermissions("edu:question:export")
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
    @RequiresPermissions("edu:question:add")
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
    @RequiresPermissions("edu:question:edit")
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
    @RequiresPermissions("edu:question:remove")
    @Log(title = "题库", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduQuestionService.deleteEduQuestionByIds(ids));
    }
}
