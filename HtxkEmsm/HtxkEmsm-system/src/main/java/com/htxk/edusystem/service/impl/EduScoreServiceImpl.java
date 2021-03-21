package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.EduScore;
import com.htxk.edusystem.mapper.EduScoreMapper;
import com.htxk.edusystem.service.IEduScoreService;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程分数Service业务层处理
 *
 * @author maple
 * @date 2020-01-03
 */
@Service
public class EduScoreServiceImpl implements IEduScoreService {
    @Autowired
    private EduScoreMapper eduScoreMapper;

    /**
     * 查询课程分数
     *
     * @param scoreId 课程分数ID
     * @return 课程分数
     */
    @Override
    public EduScore selectEduScoreById(Long scoreId) {
        return eduScoreMapper.selectEduScoreById(scoreId);
    }

    /**
     * 查询课程分数列表
     *
     * @param eduScore 课程分数
     * @return 课程分数
     */
    @Override
    public List<EduScore> selectEduScoreList(EduScore eduScore) {
        return eduScoreMapper.selectEduScoreList(eduScore);
    }

    /**
     * 新增课程分数
     *
     * @param eduScore 课程分数
     * @return 结果
     */
    @Override
    public int insertEduScore(EduScore eduScore) {
        eduScore.setCreateTime(DateUtils.getNowDate());
        return eduScoreMapper.insertEduScore(eduScore);
    }

    /**
     * 修改课程分数
     *
     * @param eduScore 课程分数
     * @return 结果
     */
    @Override
    public int updateEduScore(EduScore eduScore) {
        return eduScoreMapper.updateEduScore(eduScore);
    }

    /**
     * 删除课程分数对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduScoreByIds(String ids) {
        return eduScoreMapper.deleteEduScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程分数信息
     *
     * @param scoreId 课程分数ID
     * @return 结果
     */
    @Override
    public int deleteEduScoreById(Long scoreId) {
        return eduScoreMapper.deleteEduScoreById(scoreId);
    }
}
