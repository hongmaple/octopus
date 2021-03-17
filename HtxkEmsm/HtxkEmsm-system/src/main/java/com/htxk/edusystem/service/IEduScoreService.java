package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduScore;

import java.util.List;

/**
 * 课程分数Service接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface IEduScoreService {
    /**
     * 查询课程分数
     *
     * @param scoreId 课程分数ID
     * @return 课程分数
     */
    public EduScore selectEduScoreById(Long scoreId);

    /**
     * 查询课程分数列表
     *
     * @param eduScore 课程分数
     * @return 课程分数集合
     */
    public List<EduScore> selectEduScoreList(EduScore eduScore);

    /**
     * 新增课程分数
     *
     * @param eduScore 课程分数
     * @return 结果
     */
    public int insertEduScore(EduScore eduScore);

    /**
     * 修改课程分数
     *
     * @param eduScore 课程分数
     * @return 结果
     */
    public int updateEduScore(EduScore eduScore);

    /**
     * 批量删除课程分数
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduScoreByIds(String ids);

    /**
     * 删除课程分数信息
     *
     * @param scoreId 课程分数ID
     * @return 结果
     */
    public int deleteEduScoreById(Long scoreId);
}
