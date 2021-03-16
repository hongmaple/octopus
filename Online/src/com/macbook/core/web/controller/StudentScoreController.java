package com.macbook.core.web.controller;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Score;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerPaperService;
import com.macbook.core.service.ManagerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentScoreController {
    @Autowired
    private ManagerScoreService managerScoreService;
    @Autowired
    private ManagerPaperService managerPaperService;

    @RequestMapping(value = "/toStudentScoreList.action")
    public String scoreList(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "7") Integer rows,
                            String user_sno, Integer paper_id,
                            Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        user_sno = user.getSno();
        System.out.println(user_sno);
        Page<Score> scores = managerScoreService.findScoreList(page,rows,user_sno,paper_id);
        model.addAttribute("page",scores);
        List<Paper> papers = managerPaperService.findPapers();
        model.addAttribute("papers",papers);
        return "Student/student_score";
    }
}
