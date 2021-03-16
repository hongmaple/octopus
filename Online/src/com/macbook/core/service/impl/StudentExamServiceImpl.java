package com.macbook.core.service.impl;

import com.macbook.core.dao.StudentExamDao;
import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Question;
import com.macbook.core.pojo.Score;
import com.macbook.core.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentExamServiceImpl implements StudentExamService {
    @Autowired
    private StudentExamDao studentExamDao;

    @Override
    public Paper findPaperById(Integer id) {
        return studentExamDao.findPaperById(id);
    }

    @Override
    public List<Question> findQuestion() {
        return studentExamDao.findQuestion();
    }

    @Override
    public Integer examCount(Score score) {
        return studentExamDao.examCount(score);
    }
}
