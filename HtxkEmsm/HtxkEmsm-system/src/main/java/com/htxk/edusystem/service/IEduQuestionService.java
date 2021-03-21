package com.htxk.edusystem.service;

import com.htxk.edusystem.domain.EduQuestion;
import com.htxk.ruoyi.common.core.domain.Ztree;

import java.util.List;

/**
 * 题库Service接口
 *
 * @author maple
 * @date 2021-03-18
 */
public interface IEduQuestionService {
    /**
     * 查询题库
     *
     * @param id 题库ID
     * @return 题库
     */
    public EduQuestion selectEduQuestionById(Long id);

    /**
     * 查询题库列表
     *
     * @param eduQuestion 题库
     * @return 题库集合
     */
    public List<EduQuestion> selectEduQuestionList(EduQuestion eduQuestion);

    /**
     * 新增题库
     *
     * @param eduQuestion 题库
     * @return 结果
     */
    public int insertEduQuestion(EduQuestion eduQuestion);

    /**
     * 修改题库
     *
     * @param eduQuestion 题库
     * @return 结果
     */
    public int updateEduQuestion(EduQuestion eduQuestion);

    /**
     * 批量删除题库
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduQuestionByIds(String ids);

    /**
     * 删除题库信息
     *
     * @param id 题库ID
     * @return 结果
     */
    public int deleteEduQuestionById(Long id);
    }
