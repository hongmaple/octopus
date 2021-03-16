package com.macbook.core.pojo;

/**
 * @author maweihong
 * 问题的javabean类
 */
public class Question {

    /**
     * id:题号
     * number：题目id
     * type：题目类型
     * title：题目内容
     * sel：选择题选项
     * score：分值
     * answer：答案
     * image：题目配图
     */
    private String id;
    private Integer number;
    private String type;
    private String title;
    private String sel;
    private Integer score;
    private String answer;
    private String image;
    private Integer start;
    private Integer rows;
    private String[] options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
