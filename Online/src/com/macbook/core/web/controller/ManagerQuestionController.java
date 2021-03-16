package com.macbook.core.web.controller;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Question;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Queue;

/**
 * @author maweihong
 * 问题添加的控制类
 */
@Controller
public class ManagerQuestionController {
    @Autowired
    private ManagerQuestionService managerQuestionService;

    @GetMapping(value = "/toManagerQuestion.action")
    public String toQuestion() {
        return "Manager/manager_question";
    }

    @RequestMapping(value = "/listQuestion.action")
    public String list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "3") Integer rows,
                       Integer number, String type, String title,
                       Integer score, Model model,HttpServletRequest request) {
        Page<Question> questions = managerQuestionService.findQuestionList(page, rows, number, type, title, score);
        model.addAttribute("page", questions);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user.getIdentity().equals("管理员")){
            return "Manager/manager_question";
        }
        else {
            return "Teacher/teacher_question";
        }

    }

    @RequestMapping(value = "/toDeleteManagerQuestion.action")
    @ResponseBody
    public String deleteManagerQuestion(Integer number) {
        int result = managerQuestionService.deleteManagerQuestion(number);
        if (result > 0) {
            return "OK";
        } else {
            return "FALL";
        }
    }

    @RequestMapping(value = "/toCreateManagerQuestion.action")
    @ResponseBody
    public String createManagerQuestion(Question question, HttpServletRequest request) {
        if (question.getType() == null || question.getTitle() == null
                || question.getScore() == null || question.getAnswer() == null) {
            return "FALL1";
        } else {
            if (question.getType().equals("单选题") || question.getType().equals("多选题")) {
                String select = "";
                String[] temp = request.getParameterValues("sel");
                if (temp == null) {
                    return "FALL1";
                } else {
                    for (int i = 0; i < temp.length; i++) {
                        select += temp[i];
                        if (i != temp.length - 1) {
                            select += "@";
                        }
                    }
                    question.setSel(select);
                }
            }
            else{
                question.setSel("");
            }
            int rows = managerQuestionService.createManagerQuestion(question);
            if (rows > 0){
                return "OK";
            }
            else{
                return "FALL2";
            }
        }
    }
}

