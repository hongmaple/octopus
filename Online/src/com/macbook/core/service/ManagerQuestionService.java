package com.macbook.core.service;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Question;

import java.util.List;

/**
 * @author maweihong
 */
public interface ManagerQuestionService {

    /**
     * 分页显示题库
     * @param page
     * @param rows
     * @param number
     * @param type
     * @param title
     * @param score
     * @return
     */
    public Page<Question> findQuestionList(Integer page, Integer rows,
                                           Integer number, String type,
                                           String title, Integer score);

    /**
     * 删除问题
     * @param number
     * @return
     */
    public int deleteManagerQuestion(Integer number);

    /**
     * 新建问题
     * @param question
     * @return
     */
    public int createManagerQuestion(Question question);
}
