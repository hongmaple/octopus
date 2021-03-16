package com.macbook.core.dao;

import com.macbook.core.pojo.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maweihong
 */
public interface ManagerScoreDao {
    /**
     * 成绩列表
     * @param score
     * @return
     */
    public List<Score> selectScoreList(Score score);

    /**
     * 成绩数量
     * @param score
     * @return
     */
    public Integer selectScoreListCount(Score score);

    /**
     * 删除成绩列表
     * @param score_id
     * @return
     */
    public Integer deleteScoreById(Integer score_id);

    /**
     * 修改前显示成绩信息
     * @param score_id
     * @return
     */
    public Score findScoreById(Integer score_id);

    /**
     * 修改成绩
     * @param score
     * @return
     */
    public int updateScore(Score score);

    /**
     * 新建成绩
     * @param score
     * @return
     */
    public int insertScore(Score score);

    /**
     * 查询学生是否参加过考试
     * @param score
     * @return
     */
    public Score findScoreBySnoAndPaper(Score score);
}
