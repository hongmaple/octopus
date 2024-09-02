package com.ruoyi.edu.mapper;


import com.ruoyi.edu.domain.EduPaper;

import java.util.List;
/**
 * 试卷Mapper接口
 *
 * @author maple
 * @date 2021-03-18
 */
public interface EduPaperMapper {
    /**
     * 查询试卷
     *
     * @param id 试卷ID
     * @return 试卷
     */
    public EduPaper selectEduPaperById(Long id);

    /**
     * 查询试卷列表
     *
     * @param eduPaper 试卷
     * @return 试卷集合
     */
    public List<EduPaper> selectEduPaperList(EduPaper eduPaper);

    /**
     * 新增试卷
     *
     * @param eduPaper 试卷
     * @return 结果
     */
    public int insertEduPaper(EduPaper eduPaper);

    /**
     * 修改试卷
     *
     * @param eduPaper 试卷
     * @return 结果
     */
    public int updateEduPaper(EduPaper eduPaper);

    /**
     * 删除试卷
     *
     * @param id 试卷ID
     * @return 结果
     */
    public int deleteEduPaperById(Long id);

    /**
     * 批量删除试卷
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduPaperByIds(String[] ids);
}
