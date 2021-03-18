package import com.htxk.ruoyi.common.annotation.Excel;

com.htxk.edusystem.domain;

/**
 * 试卷对象 edu_paper
 *
 * @author maple
 * @date 2021-03-18
 */
public class EduPaper extends BaseEntity
        {
private static final long serialVersionUID=1L;

        /** 试卷号 */
            private Long id;

            /** 试卷名称 */
                                                        @Excel(name = "试卷名称")
                        private String qtyName;

            /** 考试时间 */
                                                        @Excel(name = "考试时间")
                        private Integer qtyTime;

            /** 单选题id数组 */
                                                        @Excel(name = "单选题id数组")
                        private String qtySing;

            /** 多选题id数组 */
                                                        @Excel(name = "多选题id数组")
                        private String qtyMuti;

            /** 判断题id数组 */
                                                        @Excel(name = "判断题id数组")
                        private String qtyJud;

            /** 填空题id数组 */
                                                        @Excel(name = "填空题id数组")
                        private String qtyFill;

            /** 简答题id数组 */
                                                        @Excel(name = "简答题id数组")
                        private String qtyEss;

            /** 课程id */
                                                        @Excel(name = "课程id")
                        private Long courseId;

            /** 总分 */
                                                        @Excel(name = "总分")
                        private Double score;

                            /** 删除标志（0代表存在 2代表删除） */
            private String delFlag;

                            public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
                            public void setQtyName(String qtyName)
            {
            this.qtyName = qtyName;
            }

    public String getQtyName()
            {
            return qtyName;
            }
                            public void setQtyTime(Integer qtyTime)
            {
            this.qtyTime = qtyTime;
            }

    public Integer getQtyTime()
            {
            return qtyTime;
            }
                            public void setQtySing(String qtySing)
            {
            this.qtySing = qtySing;
            }

    public String getQtySing()
            {
            return qtySing;
            }
                            public void setQtyMuti(String qtyMuti)
            {
            this.qtyMuti = qtyMuti;
            }

    public String getQtyMuti()
            {
            return qtyMuti;
            }
                            public void setQtyJud(String qtyJud)
            {
            this.qtyJud = qtyJud;
            }

    public String getQtyJud()
            {
            return qtyJud;
            }
                            public void setQtyFill(String qtyFill)
            {
            this.qtyFill = qtyFill;
            }

    public String getQtyFill()
            {
            return qtyFill;
            }
                            public void setQtyEss(String qtyEss)
            {
            this.qtyEss = qtyEss;
            }

    public String getQtyEss()
            {
            return qtyEss;
            }
                            public void setCourseId(Long courseId)
            {
            this.courseId = courseId;
            }

    public Long getCourseId()
            {
            return courseId;
            }
                            public void setScore(Double score)
            {
            this.score = score;
            }

    public Double getScore()
            {
            return score;
            }
                                            public void setDelFlag(String delFlag)
            {
            this.delFlag = delFlag;
            }

    public String getDelFlag()
            {
            return delFlag;
            }
    
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                                .append("id",getId())
                                .append("qtyName",getQtyName())
                                .append("qtyTime",getQtyTime())
                                .append("qtySing",getQtySing())
                                .append("qtyMuti",getQtyMuti())
                                .append("qtyJud",getQtyJud())
                                .append("qtyFill",getQtyFill())
                                .append("qtyEss",getQtyEss())
                                .append("courseId",getCourseId())
                                .append("score",getScore())
                                .append("createBy",getCreateBy())
                                .append("createTime",getCreateTime())
                                .append("updateBy",getUpdateBy())
                                .append("updateTime",getUpdateTime())
                                .append("delFlag",getDelFlag())
            .toString();
        }
        }
