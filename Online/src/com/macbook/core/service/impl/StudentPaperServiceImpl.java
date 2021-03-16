package com.macbook.core.service.impl;

import com.macbook.common.utils.Page;
import com.macbook.core.dao.StudentPaperDao;
import com.macbook.core.pojo.Paper;
import com.macbook.core.service.StudentPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPaperServiceImpl implements StudentPaperService {
    @Autowired
    StudentPaperDao studentPaperDao;

    @Override
    public Page<Paper> getStudentPaper(Integer page, Integer rows,Integer id) {
        Paper paper = new Paper();
        paper.setId(id);
        //当前页
        paper.setStart((page-1)*rows);
        //每页数
        paper.setRows(rows);
        //查询试卷列表
        List<Paper> papers = studentPaperDao.getPapers(paper);
        //查询试卷数量
        Integer count = studentPaperDao.selectPaperListCount(paper);
        //创建page返回对象
        Page<Paper> result = new Page<>();
        result.setPage(page);
        result.setRows(papers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }
}
