package com.macbook.core.web.controller;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Score;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerPaperService;
import com.macbook.core.service.ManagerScoreService;
import com.macbook.core.service.StudentPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentPaperController {

    @Autowired
    StudentPaperService studentPaperService;
    @Autowired
    ManagerPaperService managerPaperService;
    @Autowired
    ManagerScoreService managerScoreService;
    @RequestMapping(value = "/toPaperList.action")
    public String toListPaper(@RequestParam(defaultValue = "1")Integer page,
                              @RequestParam(defaultValue = "10")Integer rows,
                              Integer id, Model model, HttpServletRequest request){
        Page<Paper> papers = studentPaperService.getStudentPaper(page,rows,id);
        model.addAttribute("page",papers);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        String user_sno = user.getSno();
        Score score1 = new Score();
        score1.setUser_sno(user_sno);
        score1.setPaper_id(id);
        Score score = managerScoreService.findScoreBySnoAndPaper(score1);
        int flag = 1;
        if (score == null){
            flag = 0;
        }
        else{
            flag = 1;
        }

        model.addAttribute("FLAG",flag);
        return "Student/student_exam";
    }
}
