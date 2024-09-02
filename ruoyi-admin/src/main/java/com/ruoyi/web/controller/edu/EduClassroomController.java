package com.ruoyi.web.controller.edu;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.edu.domain.EduClassroom;
import com.ruoyi.edu.service.IEduClassroomService;
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
@RequestMapping("/edu/classroom")
public class EduClassroomController extends BaseController {
    private String prefix = "edu/classroom";

    @Autowired
    private IEduClassroomService eduClassroomService;

    @RequiresPermissions("edu:classroom:view")
    @GetMapping()
    public String classroom() {
        return prefix + "/classroom";
    }

    /**
     * 查询教室列表
     */
    @RequiresPermissions("edu:classroom:list")
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
    @RequiresPermissions("edu:classroom:export")
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
    @RequiresPermissions("edu:classroom:add")
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
    @RequiresPermissions("edu:classroom:edit")
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
    @RequiresPermissions("edu:classroom:remove")
    @Log(title = "教室", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eduClassroomService.deleteEduClassroomByIds(ids));
    }
}
