package com.macbook.core.pojo;

import java.util.List;

/**
 * @author maweihong
 * 成绩的javabean类
 */
public class Score {
    /**
     * score_id:成绩ID
     * user_sno:学号
     * user_name:学生姓名
     * user_college:学生学院
     * paper_id:试卷ID
     * paper_name:试卷名称
     * score_sing:单选成绩
     * score_muti:多选成绩
     * score_jud:判断成绩
     * score_fill:填空成绩
     * score_ess:简答成绩
     * start:分页显示开始行
     * rows:分页显示行数
     */
    private Integer score_id;
    private String user_sno;
    private Integer paper_id;
    private double score_sing;
    private double score_muti;
    private double score_jud;
    private double score_fill;
    private double score_ess;
    private double score;
    private Integer start;
    private Integer rows;
    private User user;
    private Paper paper;
//    private List<User> users;
//    private List<Paper> papers;

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    public List<Paper> getPapers() {
//        return papers;
//    }
//
//    public void setPapers(List<Paper> papers) {
//        this.papers = papers;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public String getUser_sno() {
        return user_sno;
    }

    public void setUser_sno(String user_sno) {
        this.user_sno = user_sno;
    }


    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public double getScore_sing() {
        return score_sing;
    }

    public void setScore_sing(double score_sing) {
        this.score_sing = score_sing;
    }

    public double getScore_muti() {
        return score_muti;
    }

    public void setScore_muti(double score_muti) {
        this.score_muti = score_muti;
    }

    public double getScore_jud() {
        return score_jud;
    }

    public void setScore_jud(double score_jud) {
        this.score_jud = score_jud;
    }

    public double getScore_fill() {
        return score_fill;
    }

    public void setScore_fill(double score_fill) {
        this.score_fill = score_fill;
    }

    public double getScore_ess() {
        return score_ess;
    }

    public void setScore_ess(double score_ess) {
        this.score_ess = score_ess;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
