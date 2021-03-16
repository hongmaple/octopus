package com.macbook.core.service.impl;

import com.macbook.common.utils.Page;
import com.macbook.core.dao.ManagerPaperDao;
import com.macbook.core.pojo.Paper;
import com.macbook.core.service.ManagerPaperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author maweihong
 */
@Service
@Transactional
public class ManagerPaperServiceImpl implements ManagerPaperService {

    @Autowired
    private ManagerPaperDao managerPaperDao;
    @Override
    public Page<Paper> findPaperList(Integer page, Integer rows, Integer id, String qty_name, Integer qty_time) {
        Paper paper = new Paper();
        if (id != null){
            paper.setId(id);
        }
        if (StringUtils.isNotBlank(qty_name)){
            paper.setQty_name(qty_name);
        }
        if (qty_time != null){
            paper.setQty_time(qty_time);
        }
        //当前页
        paper.setStart((page-1)*rows);
        //每页数
        paper.setRows(rows);
        //查询试卷列表
        List<Paper> papers = managerPaperDao.selectPaperList(paper);
        //查询试卷数量
        Integer count = managerPaperDao.selectPaperListCount(paper);
        //创建page返回对象
        Page<Paper> result = new Page<>();
        result.setPage(page);
        result.setRows(papers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public int createManagerPaper(Paper paper) {
        return managerPaperDao.createManagerPaper(paper);
    }

    @Override
    public int deleteManagerPaper(Integer id) {
        return managerPaperDao.deleteManagerPaper(id);
    }

    @Override
    public Paper findManagerPaperById(Integer id) {
        return managerPaperDao.findManagerPaperById(id);
    }

    @Override
    public int updateManagerPaper(Paper paper) {
        return managerPaperDao.updateManagerPaper(paper);
    }

    @Override
    public List<Paper> findPapers() {
        return managerPaperDao.findPaper();
    }


}
