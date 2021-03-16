package com.macbook.core.service.impl;

import com.macbook.common.utils.Page;
import com.macbook.core.dao.ManagerQuestionDao;
import com.macbook.core.pojo.Question;
import com.macbook.core.service.ManagerQuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerQuestionServiceImpl implements ManagerQuestionService {

    @Autowired
    private ManagerQuestionDao managerQuestionDao;
    @Override
    public Page<Question> findQuestionList(Integer page,Integer rows, Integer number, String type, String title, Integer score) {
        Question question = new Question();
        if (number != null){
            question.setNumber(number);
        }
        if (StringUtils.isNotBlank(type)){
            question.setType(type);
        }
        if (StringUtils.isNotBlank(title)){
            question.setTitle(title);
        }
        if (score != null){
            question.setScore(score);
        }
        question.setStart((page-1)*rows);
        question.setRows(rows);
        List<Question> questions = managerQuestionDao.selectQuestionList(question);
        Integer count = managerQuestionDao.selectQuestionListCount(question);
        Page<Question> result = new Page<>();
        result.setPage(page);
        result.setRows(questions);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    /**
     * 删除题目
     * @param number
     * @return
     */
    @Override
    public int deleteManagerQuestion(Integer number) {
        return managerQuestionDao.deleteManagerQuestion(number);
    }

    @Override
    public int createManagerQuestion(Question question) {
        return managerQuestionDao.createManagerQuestion(question);
    }

}
