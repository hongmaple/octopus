package com.ruoyi.edu.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.edu.domain.EduQuestion;
import com.ruoyi.edu.mapper.EduQuestionMapper;
import com.ruoyi.edu.service.IEduQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 题库Service业务层处理
 *
 * @author maple
 * @date 2021-03-18
 */
@Service("Question")
public class EduQuestionServiceImpl implements IEduQuestionService {
    @Autowired
    private EduQuestionMapper eduQuestionMapper;

    /**
     * 查询题库
     *
     * @param id 题库ID
     * @return 题库
     */
    @Override
    public EduQuestion selectEduQuestionById(Long id) {
        return eduQuestionMapper.selectEduQuestionById(id);
    }

    /**
     * 查询题库列表
     *
     * @param eduQuestion 题库
     * @return 题库
     */
    @Override
    public List<EduQuestion> selectEduQuestionList(EduQuestion eduQuestion) {
        return eduQuestionMapper.selectEduQuestionList(eduQuestion);
    }

    /**
     * 新增题库
     *
     * @param eduQuestion 题库
     * @return 结果
     */
    @Override
    public int insertEduQuestion(EduQuestion eduQuestion) {
                                                                                                                                                                                    eduQuestion.setCreateTime(DateUtils.getNowDate());
                                                                                        return eduQuestionMapper.insertEduQuestion(eduQuestion);
    }

    /**
     * 修改题库
     *
     * @param eduQuestion 题库
     * @return 结果
     */
    @Override
    public int updateEduQuestion(EduQuestion eduQuestion) {
                                                                                                                                                                                                                            eduQuestion.setUpdateTime(DateUtils.getNowDate());
                                                return eduQuestionMapper.updateEduQuestion(eduQuestion);
    }

    /**
     * 删除题库对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduQuestionByIds(String ids) {
        return eduQuestionMapper.deleteEduQuestionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除题库信息
     *
     * @param id 题库ID
     * @return 结果
     */
    @Override
    public int deleteEduQuestionById(Long id) {
        return eduQuestionMapper.deleteEduQuestionById(id);
    }
    }
