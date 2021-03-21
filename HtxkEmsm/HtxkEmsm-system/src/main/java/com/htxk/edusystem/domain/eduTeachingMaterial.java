package com.htxk.edusystem.domain;
import com.htxk.ruoyi.common.annotation.Excel;
import com.htxk.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 文件对象 edu_teaching_material
 *
 * @author maple
 * @date 2021-03-21
 */
public class eduTeachingMaterial extends BaseEntity
        {
private static final long serialVersionUID=1L;

        /** 文件id */
            private Long id;

            /** 文件名称 */
                                                        @Excel(name = "文件名称")
                        private String fileName;

            /** 文件路径 */
                                                        @Excel(name = "文件路径")
                        private String url;

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
                            public void setFileName(String fileName)
            {
            this.fileName = fileName;
            }

    public String getFileName()
            {
            return fileName;
            }
                            public void setUrl(String url)
            {
            this.url = url;
            }

    public String getUrl()
            {
            return url;
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
                                .append("fileName",getFileName())
                                .append("url",getUrl())
                                .append("createBy",getCreateBy())
                                .append("createTime",getCreateTime())
                                .append("updateBy",getUpdateBy())
                                .append("updateTime",getUpdateTime())
                                .append("delFlag",getDelFlag())
            .toString();
        }
        }
