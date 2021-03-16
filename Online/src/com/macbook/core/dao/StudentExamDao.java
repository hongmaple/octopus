package com.macbook.core.dao;

import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Question;
import com.macbook.core.pojo.Score;

import java.util.List;

public interface StudentExamDao {

    /**
     * 通过试卷号查找试卷
     * @param id
     * @return
     */
    public Paper findPaperById(Integer id);

    /**
     * 查找题目
     * @return
     */
    public List<Question> findQuestion();

    /**
     * 查询参加考试的次数
     * @param score
     * @return
     */
    public Integer examCount(Score score);

}
