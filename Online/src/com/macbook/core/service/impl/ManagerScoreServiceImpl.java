package com.macbook.core.service.impl;

import com.macbook.common.utils.Page;
import com.macbook.core.dao.ManagerScoreDao;
import com.macbook.core.pojo.Score;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerScoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
@Transactional
public class ManagerScoreServiceImpl implements ManagerScoreService {

    @Autowired
    private ManagerScoreDao managerScoreDao;
    @Override
    public Page<Score> findScoreList(Integer page, Integer rows, String user_sno, Integer paper_id) {
        Score score = new Score();
        if(StringUtils.isNotBlank(user_sno)){
            score.setUser_sno(user_sno);
        }
        if(paper_id != null){
            score.setPaper_id(paper_id);
        }

        score.setStart((page-1) * rows);
        score.setRows(rows);
        List<Score> scores = managerScoreDao.selectScoreList(score);
        Integer count = managerScoreDao.selectScoreListCount(score);
        //返回Page返回对象
        Page<Score> result = new Page<>();
        result.setPage(page);
        result.setRows(scores);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public int deleteManagerScore(Integer score_id) {
        return managerScoreDao.deleteScoreById(score_id);
    }

    @Override
    public Score findScoreById(Integer score_id) {
        return managerScoreDao.findScoreById(score_id);
    }

    @Override
    public int updateScore(Score score) {
        return managerScoreDao.updateScore(score);
    }

    @Override
    public int createScore(Score score) {
        return managerScoreDao.insertScore(score);
    }

    @Override
    public Score findScoreBySnoAndPaper(Score score) {
        return managerScoreDao.findScoreBySnoAndPaper(score);
    }
}
