package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduScore;
import com.htxk.edusystem.service.IEduScoreService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.system.domain.SysUser;
import com.htxk.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 课程分数Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/score")
public class EduScoreController extends BaseController {
    private String prefix = "edusystem/score";

    @Autowired
    private IEduScoreService eduScoreService;

    @RequiresPermissions("edusystem:score:view")
    @GetMapping()
    public String score() {
        return prefix + "/score";
    }

    /**
     * 查询课程分数列表
     */
    @RequiresPermissions("edusystem:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduScore eduScore) {
        startPage();
        List<EduScore> list = eduScoreService.selectEduScoreList(eduScore);
        return getDataTable(list);
    }

    /**
     * 导出课程分数列表
     */
    @RequiresPermissions("edusystem:score:export")
    @Log(title = "课程分数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduScore eduScore) {
        List<EduScore> list = eduScoreService.selectEduScoreList(eduScore);
        ExcelUtil<EduScore> util = new ExcelUtil<EduScore>(EduScore.class);
        return util.exportExcel(list, "score");
    }

    /**
     * 新增课程分数
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存课程分数
     */
    @RequiresPermissions("edusystem:score:add")
    @Log(title = "课程分数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduScore eduScore,HttpSession session) {
        String userName = session.getAttribute("username").toString();
        //设置创建者
        eduScore.setCreateBy(userName);
        //设置创建时间
        eduScore.setCreateTime(new Date());
        //设置修改时间
        eduScore.setUpdataTime(new Date());
        return toAjax(eduScoreService.insertEduScore(eduScore));
    }

    /**
     * 修改课程分数
     */
    @GetMapping("/edit/{scoreId}")
    public String edit(@PathVariable("scoreId") Long scoreId, ModelMap mmap) {
        EduScore eduScore = eduScoreService.selectEduScoreById(scoreId);
        mmap.put("eduScore", eduScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程分数
     */
    @RequiresPermissions("edusystem:score:edit")
    @Log(title = "课程分数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduScore eduScore,HttpSession session) {
        String userName = session.getAttribute("username").toString();
        //设置更新者
        eduScore.setUpdataBy(userName);
        //设置修改时间
        eduScore.setUpdataTime(new Date());
        return toAjax(eduScoreService.updateEduScore(eduScore));
    }

    /**
     * 删除课程分数
     */
    @RequiresPermissions("edusystem:score:remove")
    @Log(title = "课程分数", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduScoreService.deleteEduScoreByIds(ids));
    }
}
