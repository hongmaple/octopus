package com.macbook.core.dao;

import com.macbook.core.pojo.Paper;

import java.util.List;

public interface StudentPaperDao {

    public List<Paper> getPapers(Paper paper);

    public Integer selectPaperListCount(Paper paper);
}
