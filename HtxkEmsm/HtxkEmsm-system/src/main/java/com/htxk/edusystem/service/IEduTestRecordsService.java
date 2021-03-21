package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduTestRecords;
import com.htxk.ruoyi.common.core.domain.Ztree;

import java.util.List;

/**
 * 考试记录Service接口
 *
 * @author maple
 * @date 2021-03-18
 */
public interface IEduTestRecordsService {
    /**
     * 查询考试记录
     *
     * @param id 考试记录ID
     * @return 考试记录
     */
    public EduTestRecords selectEduTestRecordsById(Long id);

    /**
     * 查询考试记录列表
     *
     * @param eduTestRecords 考试记录
     * @return 考试记录集合
     */
    public List<EduTestRecords> selectEduTestRecordsList(EduTestRecords eduTestRecords);

    /**
     * 新增考试记录
     *
     * @param eduTestRecords 考试记录
     * @return 结果
     */
    public int insertEduTestRecords(EduTestRecords eduTestRecords);

    /**
     * 修改考试记录
     *
     * @param eduTestRecords 考试记录
     * @return 结果
     */
    public int updateEduTestRecords(EduTestRecords eduTestRecords);

    /**
     * 批量删除考试记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduTestRecordsByIds(String ids);

    /**
     * 删除考试记录信息
     *
     * @param id 考试记录ID
     * @return 结果
     */
    public int deleteEduTestRecordsById(Long id);
    }
