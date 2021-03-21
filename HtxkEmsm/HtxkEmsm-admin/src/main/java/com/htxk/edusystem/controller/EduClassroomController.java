package com.htxk.edusystem.controller;

import com.htxk.edusystem.domain.EduClassroom;
import com.htxk.edusystem.service.IEduClassroomService;
import com.htxk.ruoyi.common.annotation.Log;
import com.htxk.ruoyi.common.core.controller.BaseController;
import com.htxk.ruoyi.common.core.domain.AjaxResult;
import com.htxk.ruoyi.common.core.page.TableDataInfo;
import com.htxk.ruoyi.common.enums.BusinessType;
import com.htxk.ruoyi.common.utils.DateUtils;
import com.htxk.ruoyi.common.utils.poi.ExcelUtil;
import com.htxk.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教室Controller
 *
 * @author maple
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/edusystem/classroom")
public class EduClassroomController extends BaseController {
    private String prefix = "edusystem/classroom";

    @Autowired
    private IEduClassroomService eduClassroomService;

    @RequiresPermissions("edusystem:classroom:view")
    @GetMapping()
    public String classroom() {
        return prefix + "/classroom";
    }

    /**
     * 查询教室列表
     */
    @RequiresPermissions("edusystem:classroom:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduClassroom eduClassroom) {
        startPage();
        List<EduClassroom> list = eduClassroomService.selectEduClassroomList(eduClassroom);
        return getDataTable(list);
    }

    /**
     * 导出教室列表
     */
    @RequiresPermissions("edusystem:classroom:export")
    @Log(title = "教室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EduClassroom eduClassroom) {
        List<EduClassroom> list = eduClassroomService.selectEduClassroomList(eduClassroom);
        ExcelUtil<EduClassroom> util = new ExcelUtil<EduClassroom>(EduClassroom.class);
        return util.exportExcel(list, "classroom");
    }

    /**
     * 新增教室
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存教室
     */
    @RequiresPermissions("edusystem:classroom:add")
    @Log(title = "教室", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduClassroom eduClassroom) {
        eduClassroom.setCreateTime(DateUtils.getNowDate());
        eduClassroom.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(eduClassroomService.insertEduClassroom(eduClassroom));
    }

    /**
     * 修改教室
     */
    @GetMapping("/edit/{classroomId}")
    public String edit(@PathVariable("classroomId") Long classroomId, ModelMap mmap) {
        EduClassroom eduClassroom = eduClassroomService.selectEduClassroomById(classroomId);
        mmap.put("eduClassroom", eduClassroom);
        return prefix + "/edit";
    }

    /**
     * 修改保存教室
     */
    @RequiresPermissions("edusystem:classroom:edit")
    @Log(title = "教室", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EduClassroom eduClassroom) {
        eduClassroom.setUpdateTime(DateUtils.getNowDate());
        eduClassroom.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(eduClassroomService.updateEduClassroom(eduClassroom));
    }

    /**
     * 删除教室
     */
    @RequiresPermissions("edusystem:classroom:remove")
    @Log(title = "教室", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduClassroomService.deleteEduClassroomByIds(ids));
    }
}
