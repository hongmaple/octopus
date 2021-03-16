package com.macbook.core.dao;

import com.macbook.core.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maweihong
 */
public interface ManagerPaperDao {

    /**
     * 试卷列表
     * @param paper
     * @return
     */
    public List<Paper> selectPaperList(Paper paper);

    /**
     * 试卷数量
     * @param paper
     * @return
     */
    public Integer selectPaperListCount(Paper paper);

    /**
     * 新建试卷信息
     * @param paper
     * @return
     */
    public int createManagerPaper(Paper paper);

    /**
     * 删除试卷信息
     * @param id
     * @return
     */
    public int deleteManagerPaper(Integer id);

    /**
     * 修改前查找试卷
     * @param id
     * @return
     */
    public Paper findManagerPaperById(Integer id);

    /**
     * 修改试卷信息
     * @param paper
     * @return
     */
    public int updateManagerPaper(Paper paper);

    /**
     * 显示所有试卷
     * @return
     */
    public List<Paper> findPaper();

}