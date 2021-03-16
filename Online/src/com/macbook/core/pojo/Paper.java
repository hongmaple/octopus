package com.macbook.core.pojo;

/**
 * @author maweihong
 * 试卷的题目数量的javaBean
 */

public class Paper {
    /**
     * id:试卷id
     * qty_name:试卷名称
     * qty_time:考试时间
     * qty_sing:单选题数量
     * qty_muti:多选题数量
     * qty_jud:判断题数量
     * qty_fill:填空题数量
     * qty_ess:简答题数量
     * quantity:题目总数量
     * start:分页显示开始行
     * rows：分页显示行数
     */
    private Integer id;
    private String qty_name;
    private Integer qty_time;
    private Integer qty_sing;
    private Integer qty_muti;
    private Integer qty_jud;
    private Integer qty_fill;
    private Integer qty_ess;
    private Integer quantity;
    private Integer start;
    private Integer rows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQty_name() {
        return qty_name;
    }

    public void setQty_name(String qty_name) {
        this.qty_name = qty_name;
    }

    public Integer getQty_time() {
        return qty_time;
    }

    public void setQty_time(Integer qty_time) {
        this.qty_time = qty_time;
    }

    public Integer getQty_sing() {
        return qty_sing;
    }

    public void setQty_sing(Integer qty_sing) {
        this.qty_sing = qty_sing;
    }

    public Integer getQty_muti() {
        return qty_muti;
    }

    public void setQty_muti(Integer qty_muti) {
        this.qty_muti = qty_muti;
    }

    public Integer getQty_jud() {
        return qty_jud;
    }

    public void setQty_jud(Integer qty_jud) {
        this.qty_jud = qty_jud;
    }

    public Integer getQty_fill() {
        return qty_fill;
    }

    public void setQty_fill(Integer qty_fill) {
        this.qty_fill = qty_fill;
    }

    public Integer getQty_ess() {
        return qty_ess;
    }

    public void setQty_ess(Integer qty_ess) {
        this.qty_ess = qty_ess;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
