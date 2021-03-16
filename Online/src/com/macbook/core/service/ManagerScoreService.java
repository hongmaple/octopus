package com.macbook.core.service;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Score;
import com.macbook.core.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author maweihong
 */
public interface ManagerScoreService {

    /**
     * 查找成绩列表
     * @param page
     * @param rows
     * @param user_sno
     * @param paper_id
     * @return
     */
    public Page<Score> findScoreList(Integer page, Integer rows, String user_sno,
                                     Integer paper_id);


    /**
     * 删除成绩
     * @param score_id
     * @return
     */
    public int deleteManagerScore(Integer score_id);

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
    public int createScore(Score score);

    /**
     * 查询学生是否参加过考试
     * @param score
     * @return
     */
    public Score findScoreBySnoAndPaper(Score score);
}
