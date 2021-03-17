package com.htxk.edusystem.mapper;

import com.htxk.edusystem.domain.EduMajor;

import java.util.List;

/**
 * 专业Mapper接口
 *
 * @author maple
 * @date 2020-01-03
 */
public interface EduMajorMapper {
    /**
     * 查询专业
     *
     * @param majorStudiedid 专业ID
     * @return 专业
     */
    public EduMajor selectEduMajorById(Long majorStudiedid);

    /**
     * 查询专业列表
     *
     * @param eduMajor 专业
     * @return 专业集合
     */
    public List<EduMajor> selectEduMajorList(EduMajor eduMajor);

    /**
     * 新增专业
     *
     * @param eduMajor 专业
     * @return 结果
     */
    public int insertEduMajor(EduMajor eduMajor);

    /**
     * 修改专业
     *
     * @param eduMajor 专业
     * @return 结果
     */
    public int updateEduMajor(EduMajor eduMajor);

    /**
     * 删除专业
     *
     * @param majorStudiedid 专业ID
     * @return 结果
     */
    public int deleteEduMajorById(Long majorStudiedid);

    /**
     * 批量删除专业
     *
     * @param majorStudiedids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEduMajorByIds(String[] majorStudiedids);

    /**
     * 连表查询所有专业数据
     * @return 结果
     */
    public List<EduMajor> selectEduMajorAllList(EduMajor eduMajor);
}
