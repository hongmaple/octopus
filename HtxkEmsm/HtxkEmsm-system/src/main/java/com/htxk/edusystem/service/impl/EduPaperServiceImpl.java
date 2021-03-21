package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.EduPaper;
import com.htxk.edusystem.domain.EduQuestion;
import com.htxk.edusystem.mapper.EduPaperMapper;
import com.htxk.edusystem.mapper.EduQuestionMapper;
import com.htxk.edusystem.service.IEduPaperService;
import com.htxk.ruoyi.common.core.domain.Ztree;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 试卷Service业务层处理
 *
 * @author maple
 * @date 2021-03-18
 */
@Service
public class EduPaperServiceImpl implements IEduPaperService {
    @Autowired
    private EduPaperMapper eduPaperMapper;
    @Autowired
    private EduQuestionMapper eduQuestionMapper;

    /**
     * 查询试卷
     *
     * @param id 试卷ID
     * @return 试卷
     */
    @Override
    public EduPaper selectEduPaperById(Long id) {
        return eduPaperMapper.selectEduPaperById(id);
    }

    /**
     * 查询试卷列表
     *
     * @param eduPaper 试卷
     * @return 试卷
     */
    @Override
    public List<EduPaper> selectEduPaperList(EduPaper eduPaper) {
        return eduPaperMapper.selectEduPaperList(eduPaper);
    }

    /**
     * 新增试卷
     *
     * @param eduPaper 试卷
     * @return 结果
     */
    @Override
    public int insertEduPaper(EduPaper eduPaper) {
        return eduPaperMapper.insertEduPaper(eduPaper);
    }

    /**
     * 修改试卷
     *
     * @param eduPaper 试卷F
     * @return 结果
     */
    @Override
    public int updateEduPaper(EduPaper eduPaper) {
        return eduPaperMapper.updateEduPaper(eduPaper);
    }

    /**
     * 删除试卷对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduPaperByIds(String ids) {
        return eduPaperMapper.deleteEduPaperByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除试卷信息
     *
     * @param id 试卷ID
     * @return 结果
     */
    @Override
    public int deleteEduPaperById(Long id) {
        return eduPaperMapper.deleteEduPaperById(id);
    }

    @Override
    public EduPaper selectEduPaperDetails(Long id) {
        EduPaper eduPaper = this.selectEduPaperById(id);
        if (eduPaper.getQtyEss()!=null&&!eduPaper.getQtyEss().isEmpty()) {
            System.out.println("buskon");
            String[] essArray = eduPaper.getQtyEss().split(",");
            List<EduQuestion> essQuestions = new ArrayList<>(5);
            for (String s : essArray) {
                Long questionId = Long.valueOf(s);
                EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(questionId);
                eduQuestion.setAnswer(null);
                essQuestions.add(eduQuestion);
            }
            eduPaper.setQtyEssList(essQuestions);
        }
        if (eduPaper.getQtyFill()!=null&&!eduPaper.getQtyFill().isEmpty()) {
            System.out.println("buskon");
            String[] fillArray = eduPaper.getQtyFill().split(",");
            List<EduQuestion> fillQuestions = new ArrayList<>(5);
            for (String s : fillArray) {
                Long questionId = Long.valueOf(s);
                EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(questionId);
                eduQuestion.setAnswer(null);
                fillQuestions.add(eduQuestion);
            }
            eduPaper.setQtyFillList(fillQuestions);
        }
        if (eduPaper.getQtyJud()!=null&&!eduPaper.getQtyJud().isEmpty()) {
            System.out.println("buskon");
            String[] judArray = eduPaper.getQtyJud().split(",");
            List<EduQuestion> judQuestions = new ArrayList<>(5);
            for (String s : judArray) {
                Long questionId = Long.valueOf(s);
                EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(questionId);
                eduQuestion.setAnswer(null);
                judQuestions.add(eduQuestion);
            }
            eduPaper.setQtyJudList(judQuestions);
        }
        if (eduPaper.getQtyMuti()!=null&&!eduPaper.getQtyMuti().isEmpty()) {
            System.out.println("buskon");
            String[] mutiArray = eduPaper.getQtyMuti().split(",");
            List<EduQuestion> mutiQuestions = new ArrayList<>(5);
            for (String s : mutiArray) {
                Long questionId = Long.valueOf(s);
                EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(questionId);
                eduQuestion.setAnswer(null);
                eduQuestion.setSels(eduQuestion.getSel().split("@"));
                mutiQuestions.add(eduQuestion);
            }
            eduPaper.setQtyMutiList(mutiQuestions);
        }
        if (eduPaper.getQtySing()!=null&&!eduPaper.getQtySing().isEmpty()) {
            System.out.println("buskon");
            String[] singArray = eduPaper.getQtySing().split(",");
            List<EduQuestion> singQuestions = new ArrayList<>(5);
            for (String s : singArray) {
                Long questionId = Long.valueOf(s);
                EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(questionId);
                eduQuestion.setAnswer(null);
                eduQuestion.setSels(eduQuestion.getSel().split("@"));
                singQuestions.add(eduQuestion);
            }
            eduPaper.setQtySingList(singQuestions);
        }
        return eduPaper;
    }
}
