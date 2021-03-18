package

import com.htxk.ruoyi.common.core.domain.Ztree;
import com.htxk.ruoyi.common.core.text.Convert;
import com.htxk.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

com.htxk.edusystem.service.impl;
                                                                                                                                                                                com.htxk.edusystem.mapper.EduTestRecordsMapper;
    com.htxk.edusystem.domain.EduTestRecords;
    com.htxk.edusystem.service.IEduTestRecordsService;

/**
 * 考试记录Service业务层处理
 *
 * @author maple
 * @date 2021-03-18
 */
@Service
public class EduTestRecordsServiceImpl implements IEduTestRecordsService {
    @Autowired
    private EduTestRecordsMapper eduTestRecordsMapper;

    /**
     * 查询考试记录
     *
     * @param id 考试记录ID
     * @return 考试记录
     */
    @Override
    public EduTestRecords selectEduTestRecordsById(Long id) {
        return eduTestRecordsMapper.selectEduTestRecordsById(id);
    }

    /**
     * 查询考试记录列表
     *
     * @param eduTestRecords 考试记录
     * @return 考试记录
     */
    @Override
    public List<EduTestRecords> selectEduTestRecordsList(EduTestRecords eduTestRecords) {
        return eduTestRecordsMapper.selectEduTestRecordsList(eduTestRecords);
    }

    /**
     * 新增考试记录
     *
     * @param eduTestRecords 考试记录
     * @return 结果
     */
    @Override
    public int insertEduTestRecords(EduTestRecords eduTestRecords) {
                                                                                                                                                                                                                                                                                        eduTestRecords.setCreateTime(DateUtils.getNowDate());
                                                                                        return eduTestRecordsMapper.insertEduTestRecords(eduTestRecords);
    }

    /**
     * 修改考试记录
     *
     * @param eduTestRecords 考试记录
     * @return 结果
     */
    @Override
    public int updateEduTestRecords(EduTestRecords eduTestRecords) {
                                                                                                                                                                                                                                                                                                                                eduTestRecords.setUpdateTime(DateUtils.getNowDate());
                                                return eduTestRecordsMapper.updateEduTestRecords(eduTestRecords);
    }

    /**
     * 删除考试记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduTestRecordsByIds(String ids) {
        return eduTestRecordsMapper.deleteEduTestRecordsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考试记录信息
     *
     * @param id 考试记录ID
     * @return 结果
     */
    @Override
    public int deleteEduTestRecordsById(Long id) {
        return eduTestRecordsMapper.deleteEduTestRecordsById(id);
    }
    }
