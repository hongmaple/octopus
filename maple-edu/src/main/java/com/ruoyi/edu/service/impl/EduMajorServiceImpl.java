package com.ruoyi.edu.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.edu.domain.EduMajor;
import com.ruoyi.edu.mapper.EduMajorMapper;
import com.ruoyi.edu.service.IEduMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 专业Service业务层处理
 *
 * @author maple
 * @date 2020-01-03
 */
@Service
public class EduMajorServiceImpl implements IEduMajorService {
    @Autowired
    private EduMajorMapper eduMajorMapper;

    /**
     * 查询专业
     *
     * @param majorStudiedid 专业ID
     * @return 专业
     */
    @Override
    public EduMajor selectEduMajorById(Long majorStudiedid) {
        return eduMajorMapper.selectEduMajorById(majorStudiedid);
    }

    /**
     * 查询专业列表
     *
     * @param eduMajor 专业
     * @return 专业
     */
    @Override
    public List<EduMajor> selectEduMajorList(EduMajor eduMajor) {
        return eduMajorMapper.selectEduMajorList(eduMajor);
    }

    /**
     * 新增专业
     *
     * @param eduMajor 专业
     * @return 结果
     */
    @Override
    public int insertEduMajor(EduMajor eduMajor) {
        eduMajor.setCreateTime(DateUtils.getNowDate());
        return eduMajorMapper.insertEduMajor(eduMajor);
    }

    /**
     * 修改专业
     *
     * @param eduMajor 专业
     * @return 结果
     */
    @Override
    public int updateEduMajor(EduMajor eduMajor) {
        return eduMajorMapper.updateEduMajor(eduMajor);
    }

    /**
     * 删除专业对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduMajorByIds(String ids) {
        return eduMajorMapper.deleteEduMajorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专业信息
     *
     * @param majorStudiedid 专业ID
     * @return 结果
     */
    @Override
    public int deleteEduMajorById(Long majorStudiedid) {
        return eduMajorMapper.deleteEduMajorById(majorStudiedid);
    }

    @Override
    public List<EduMajor> selectEduMajorAllList(EduMajor eduMajor) {
        return eduMajorMapper.selectEduMajorAllList(eduMajor);
    }
}
