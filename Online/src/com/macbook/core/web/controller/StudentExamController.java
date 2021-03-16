package com.macbook.core.web.controller;

import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.Question;
import com.macbook.core.pojo.Score;
import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerScoreService;
import com.macbook.core.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class StudentExamController {
    int tihao = 0;
    @Autowired
    private StudentExamService studentExamService;
    @Autowired
    private ManagerScoreService managerScoreService;

    @RequestMapping(value = "/toStudentExam.action")
    public String handlerExam(Integer id, String user_sno, HttpServletRequest request) {
        ArrayList<Question> listAll = new ArrayList<Question>();
        Paper paper = studentExamService.findPaperById(id);
        int numSing = 0;
        int numMuti = 0;
        int numJud = 0;
        int numFill = 0;
        int numEss = 0;
        int time = 0;
        numSing = paper.getQty_sing();
        numMuti = paper.getQty_muti();
        numJud = paper.getQty_jud();
        numFill = paper.getQty_fill();
        numEss = paper.getQty_ess();
        time = paper.getQty_time();
//        将每种题目按照题目类型存储
        LinkedList<Question> listSing = new LinkedList<Question>();
        LinkedList<Question> listMuti = new LinkedList<Question>();
        LinkedList<Question> listJud = new LinkedList<Question>();
        LinkedList<Question> listFill = new LinkedList<Question>();
        LinkedList<Question> listEss = new LinkedList<Question>();
        List<Question> questions = studentExamService.findQuestion();
        for (Question question : questions) {
            switch (question.getType()) {
                case "单选题":
                    listSing.add(question);
                    break;
                case "多选题":
                    listMuti.add(question);
                    break;
                case "判断题":
                    listJud.add(question);
                    break;
                case "填空题":
                    listFill.add(question);
                    break;
                default:
                    listEss.add(question);
                    break;
            }
        }
//        System.out.println("单：" + listSing.size());
//        System.out.println("多：" + listMuti.size());
//        System.out.println("判：" + listJud.size());
//        System.out.println("简：" + listEss.size());
//        System.out.println("填：" + listFill.size());
        listAll.addAll(randomQue(listSing, numSing));
        listAll.addAll(randomQue(listMuti, numMuti));
        listAll.addAll(randomQue(listJud, numJud));
        listAll.addAll(randomQue(listFill, numFill));
        listAll.addAll(randomQue(listEss, numEss));
//        System.out.println("全：" + listAll.size());
        tihao = 0;
        HttpSession session = request.getSession();
        //判断用户参加考试的次数
        User user = (User) session.getAttribute("USER_SESSION");
        user_sno = user.getSno();
        Score score = new Score();
        score.setUser_sno(user_sno);
        score.setPaper_id(id);
        Integer number = Integer.valueOf(0);
        number = studentExamService.examCount(score);
        session.setAttribute("paper",paper);
        session.setAttribute("number", number);
        session.setAttribute("examTime", time);
        session.setAttribute("ques", listAll);
        return "Student/student_exam_info";
    }

    public ArrayList<Question> randomQue(LinkedList<Question> list, int count) {
        ArrayList<Question> listA = new ArrayList<Question>();
        while (list.size() > 0 && count > 0) {
            count--;
            int m = (int) (Math.random() * list.size());
            Question question = list.get(m);
            list.remove(m);
            tihao++;
            question.setId(String.valueOf(tihao));
            String selectString = question.getSel();
            if (selectString != null) {
                String[] temp = selectString.split("\\@");
                question.setOptions(temp);
            }
            listA.add(question);
        }
        return listA;
    }

    @RequestMapping(value = "/calScore.action")
    public String calScore(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Score userScore = new Score();
        ArrayList<Question> questions = (ArrayList<Question>) session.getAttribute("ques");
        User user = (User) session.getAttribute("USER_SESSION");
        Paper paper = (Paper) session.getAttribute("paper");
        String stuAnsArr[] = null;
        double score = 0;
        double score_muti = 0;
        double score_sing = 0;
        double score_jud = 0;
        double score_fill = 0;
        double score_ess = 0;
        for (int i = 0; i < questions.size(); ++i) {
            Question question = questions.get(i);
            stuAnsArr = request.getParameterValues(question.getId());
            if (!question.getType().equals("简答题")) {
                if (stuAnsArr != null) {
                    String stuAns = "";
                    for (int j = 0; j < stuAnsArr.length; j++) {
                        stuAns += stuAnsArr[j];
                    }
                    //System.out.println(stuAns);
                    if (stuAns.equalsIgnoreCase(question.getAnswer())) {
                        switch (question.getType()) {
                            case "单选题":
                                score_sing += question.getScore();
                                score += score_sing;
                                break;
                            case "多选题":
                                score_muti += question.getScore();
                                score += score_muti;
                                break;
                            case "判断题":
                                score_jud += question.getScore();
                                score += score_jud;
                                break;
                            case "填空题":
                                score_fill += question.getScore();
                                score += score_fill;
                                break;
                            default:
                                break;
                        }
                    }
                }
            } else {
                //简答题的判断方法
                //拆分正确答案中的关键词
                String[] KEY_WORD = question.getAnswer().split("\\@");
                //获取简答题分值
                Integer totalScore = question.getScore();
                //每个的分点的细分
                int singleScore = 0;
                String stuAns = "";
                if (stuAnsArr != null) {
                    for (int j = 0; j < stuAnsArr.length; j++) {
                        //组装学生答案
                        stuAns += stuAnsArr[j];
                    }
                }
                // 使用contains方法
                //如果关键词存在
                if (KEY_WORD != null) {
                    //按照关键词数量细分分值
                    singleScore = totalScore / KEY_WORD.length;
                    for (int j = 0; j < KEY_WORD.length; j++) {
                        //判断考生答案中是否出现关键词
                        if (stuAns.contains(KEY_WORD[j])) {
                            //System.out.println(stuAns + "包含关键词:" + KEY_WORD[j]);
                            score_ess += singleScore;
                            score += score_ess;
                        } else {
                            System.out.println("不包含关键词:" + KEY_WORD[j]);
                        }
                    }
                }
            }
        }
        userScore.setUser_sno(user.getSno());
        userScore.setPaper_id(paper.getId());
        userScore.setScore_sing(score_sing);
        userScore.setScore_muti(score_muti);
        userScore.setScore_jud(score_jud);
        userScore.setScore_fill(score_fill);
        userScore.setScore_ess(score_ess);
        userScore.setScore(score);
        session.setAttribute("score",userScore);
        int rows = managerScoreService.createScore(userScore);
        if (rows > 0){

            return "Student/student_exam_after";
        }
        else{
            return "Student/student_exam";
        }

    }
}

