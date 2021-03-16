package com.macbook.core.web.controller;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Score;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerPaperService;
import com.macbook.core.service.ManagerScoreService;
import com.macbook.core.service.ManagerUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author maweihong
 */
@Controller
public class ManagerScoreController {
    @Autowired
    private ManagerScoreService managerScoreService;
    @Autowired
    private ManagerPaperService managerPaperService;
    @Autowired
    private ManagerUserService managerUserService;

    @RequestMapping(value = "/toManagerScore.action",method = RequestMethod.GET)
    public String toManagerScore(){
        return "Manager/manager_score";
    }

    @RequestMapping(value = "/toManagerScoreList.action")
    public String scoreList(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "7") Integer rows,
                            String user_sno, Integer paper_id,
                            Model model, HttpServletRequest request){
        Page<Score> scores = managerScoreService.findScoreList(page,rows,user_sno,paper_id);
        model.addAttribute("page",scores);
        List<Paper> papers = managerPaperService.findPapers();
        model.addAttribute("papers",papers);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user.getIdentity().equals("管理员")){
            return "Manager/manager_score";
        }
        else{
            return "Teacher/teacher_score";
        }

    }

    @RequestMapping(value = "/toDeleteManagerScore.action")
    @ResponseBody
    public String deleteManagerScore(Integer score_id){
        int rows = managerScoreService.deleteManagerScore(score_id);
        if(rows > 0){
            return "OK";
        }
        else{
            return "FALL";
        }
    }

    @RequestMapping(value = "/toFindScoreById.action")
    @ResponseBody
    public Score findScoreById(Integer score_id){
        Score score = managerScoreService.findScoreById(score_id);
        return score;
    }

    @RequestMapping(value = "/toUpdateManagerScore.action")
    @ResponseBody
    public String updateScore(Score score){
        double score_sing = score.getScore_sing();
        double score_muti = score.getScore_muti();
        double score_jud = score.getScore_jud();
        double score_fill = score.getScore_fill();
        double score_ess = score.getScore_ess();
        double score_score = score_sing + score_ess +score_fill + score_muti + score_jud;
        score.setScore(score_score);
        int raws = managerScoreService.updateScore(score);
        if (raws > 0){
            return "OK";
        }else {
            return "FALL";
        }
    }

    @RequestMapping(value = "/toCreateManagerScore.action")
    @ResponseBody
    public String createManagerScore(Score score){
        if (score.getUser_sno()=="" || score.getPaper_id()==null || score.getScore_sing()-0.0<1e-6
        || score.getScore_muti()-0.0<1e-6 || score.getScore_jud()-0.0<1e-6 || score.getScore_fill()-0.0<1e-6
        || score.getScore_ess()-0.0<1e-6){
            return "FALL1";
        }
        else{
            User user = managerUserService.findManagerUserBySno(score.getUser_sno());
            if (user == null){
                return "FALL2";
            }
            else{
                 double score_sing = score.getScore_sing();
                 double score_muti = score.getScore_muti();
                 double score_jud = score.getScore_jud();
                 double score_fill = score.getScore_fill();
                 double score_ess = score.getScore_ess();
                 double score_score = score_sing + score_ess +score_fill + score_muti + score_jud;
                 score.setScore(score_score);
                 int rows = managerScoreService.createScore(score);
                 if (rows > 0){
                     return "OK";
                 }
                 else{
                     return "FALL3";
                 }
            }
        }
    }
}
