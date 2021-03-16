package com.macbook.core.service;

import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Question;
import com.macbook.core.pojo.Score;

import java.util.List;

public interface StudentExamService {

    public Paper findPaperById(Integer id);

    public List<Question> findQuestion();

    public Integer examCount(Score score);
}
