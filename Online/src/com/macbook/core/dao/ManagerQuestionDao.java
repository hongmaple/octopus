package com.macbook.core.dao;

import com.macbook.core.pojo.Question;

import java.util.List;

public interface ManagerQuestionDao {

    /**
     * 问题列表
     * @param question
     * @return
     */
    public List<Question> selectQuestionList(Question question);

    /**
     * 问题数量
     * @param question
     * @return
     */
    public Integer selectQuestionListCount(Question question);

    /**
     * 删除问题
     * @param number
     * @return
     */
    public int deleteManagerQuestion(Integer number);

    /**
     * 新建题目
     * @param question
     * @return
     */
    public int createManagerQuestion(Question question);
}
