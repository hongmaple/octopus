package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.EduClass;
import com.htxk.edusystem.mapper.EduClassMapper;
import com.htxk.edusystem.service.IEduClassService;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级信息Service业务层处理
 *
 * @author maple
 * @date 2020-01-10
 */
@Service("EduClass")
public class EduClassServiceImpl implements IEduClassService {
    @Autowired
    private EduClassMapper eduClassMapper;

    /**
     * 查询班级信息
     *
     * @param classId 班级信息ID
     * @return 班级信息
     */
    @Override
    public EduClass selectEduClassById(Long classId) {
        return eduClassMapper.selectEduClassById(classId);
    }

    /**
     * 查询班级信息列表
     *
     * @param eduClass 班级信息
     * @return 班级信息
     */
    @Override
    public List<EduClass> selectEduClassList(EduClass eduClass) {
        return eduClassMapper.selectEduClassList(eduClass);
    }

    /**
     * 新增班级信息
     *
     * @param eduClass 班级信息
     * @return 结果
     */
    @Override
    public int insertEduClass(EduClass eduClass) {
        return eduClassMapper.insertEduClass(eduClass);
    }

    /**
     * 修改班级信息
     *
     * @param eduClass 班级信息
     * @return 结果
     */
    @Override
    public int updateEduClass(EduClass eduClass) {
        eduClass.setUpdateTime(DateUtils.getNowDate());
        return eduClassMapper.updateEduClass(eduClass);
    }

    /**
     * 删除班级信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduClassByIds(String ids) {
        return eduClassMapper.deleteEduClassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级信息信息
     *
     * @param classId 班级信息ID
     * @return 结果
     */
    @Override
    public int deleteEduClassById(Long classId) {
        return eduClassMapper.deleteEduClassById(classId);
    }
}
