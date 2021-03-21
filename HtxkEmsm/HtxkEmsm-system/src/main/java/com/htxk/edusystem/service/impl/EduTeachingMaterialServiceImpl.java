package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.eduTeachingMaterial;
import com.htxk.edusystem.mapper.EduTeachingMaterialMapper;
import com.htxk.edusystem.service.IeduTeachingMaterialService;
import com.htxk.ruoyi.common.core.domain.Ztree;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * 文件Service业务层处理
 *
 * @author maple
 * @date 2021-03-21
 */
@Service
public class EduTeachingMaterialServiceImpl implements IeduTeachingMaterialService {
    @Autowired
    private EduTeachingMaterialMapper eduTeachingMaterialMapper;

    /**
     * 查询文件
     *
     * @param id 文件ID
     * @return 文件
     */
    @Override
    public eduTeachingMaterial selecteduTeachingMaterialById(Long id) {
        return eduTeachingMaterialMapper.selecteduTeachingMaterialById(id);
    }

    /**
     * 查询文件列表
     *
     * @param eduTeachingMaterial 文件
     * @return 文件
     */
    @Override
    public List<eduTeachingMaterial> selecteduTeachingMaterialList(eduTeachingMaterial eduTeachingMaterial) {
        return eduTeachingMaterialMapper.selecteduTeachingMaterialList(eduTeachingMaterial);
    }

    /**
     * 新增文件
     *
     * @param eduTeachingMaterial 文件
     * @return 结果
     */
    @Override
    public int inserteduTeachingMaterial(eduTeachingMaterial eduTeachingMaterial) {
                                                                                                                        eduTeachingMaterial.setCreateTime(DateUtils.getNowDate());
                                                                                        return eduTeachingMaterialMapper.inserteduTeachingMaterial(eduTeachingMaterial);
    }

    /**
     * 修改文件
     *
     * @param eduTeachingMaterial 文件
     * @return 结果
     */
    @Override
    public int updateeduTeachingMaterial(eduTeachingMaterial eduTeachingMaterial) {
                                                                                                                                                                eduTeachingMaterial.setUpdateTime(DateUtils.getNowDate());
                                                return eduTeachingMaterialMapper.updateeduTeachingMaterial(eduTeachingMaterial);
    }

    /**
     * 删除文件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteeduTeachingMaterialByIds(String ids) {
        return eduTeachingMaterialMapper.deleteeduTeachingMaterialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文件信息
     *
     * @param id 文件ID
     * @return 结果
     */
    @Override
    public int deleteeduTeachingMaterialById(Long id) {
        return eduTeachingMaterialMapper.deleteeduTeachingMaterialById(id);
    }
    }
