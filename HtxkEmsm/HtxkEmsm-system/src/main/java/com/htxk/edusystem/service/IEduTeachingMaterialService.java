package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.eduTeachingMaterial;
import com.htxk.ruoyi.common.core.domain.Ztree;

import java.util.List;


/**
 * 文件Service接口
 *
 * @author maple
 * @date 2021-03-21
 */
public interface IeduTeachingMaterialService {
    /**
     * 查询文件
     *
     * @param id 文件ID
     * @return 文件
     */
    public eduTeachingMaterial selecteduTeachingMaterialById(Long id);

    /**
     * 查询文件列表
     *
     * @param eduTeachingMaterial 文件
     * @return 文件集合
     */
    public List<eduTeachingMaterial> selecteduTeachingMaterialList(eduTeachingMaterial eduTeachingMaterial);

    /**
     * 新增文件
     *
     * @param eduTeachingMaterial 文件
     * @return 结果
     */
    public int inserteduTeachingMaterial(eduTeachingMaterial eduTeachingMaterial);

    /**
     * 修改文件
     *
     * @param eduTeachingMaterial 文件
     * @return 结果
     */
    public int updateeduTeachingMaterial(eduTeachingMaterial eduTeachingMaterial);

    /**
     * 批量删除文件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteeduTeachingMaterialByIds(String ids);

    /**
     * 删除文件信息
     *
     * @param id 文件ID
     * @return 结果
     */
    public int deleteeduTeachingMaterialById(Long id);
    }
