package com.macbook.core.service;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.User;

import java.util.List;


/**
 * @author maweihong
 */
public interface ManagerPaperService {
    /**
     * 分页显示试卷信息
     * @param page
     * @param rows
     * @param id
     * @param qty_name
     * @param qty_time
     * @return
     */
    public Page<Paper> findPaperList(Integer page, Integer rows, Integer id,
                                    String qty_name, Integer qty_time);

    /**
     * 创建试卷
     * @param paper
     * @return
     */
    public int createManagerPaper(Paper paper);

    /**
     * 删除试卷
     * @param id
     * @return
     */
    public int deleteManagerPaper(Integer id);

    /**
     * 更新前查找试卷
     * @param id
     * @return
     */
    public Paper findManagerPaperById(Integer id);

    /**
     * 更新试卷信息
     * @param paper
     * @return
     */
    public int updateManagerPaper(Paper paper);

    /**
     * 显示所有试卷信息
     * @return
     */
    public List<Paper> findPapers();
}
