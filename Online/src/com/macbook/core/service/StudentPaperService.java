package com.macbook.core.service;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Paper;

import java.util.List;

public interface StudentPaperService {

    public Page<Paper> getStudentPaper(Integer page, Integer rows, Integer id);
}
