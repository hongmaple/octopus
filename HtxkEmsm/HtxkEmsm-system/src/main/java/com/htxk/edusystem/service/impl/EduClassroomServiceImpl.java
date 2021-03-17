package com.htxk.edusystem.service.impl;

import com.htxk.edusystem.domain.EduClassroom;
import com.htxk.edusystem.mapper.EduClassroomMapper;
import com.htxk.edusystem.service.IEduClassroomService;
import com.htxk.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教室Service业务层处理
 *
 * @author maple
 * @date 2020-01-03
 */
@Service
public class EduClassroomServiceImpl implements IEduClassroomService {

    @Resource
    private EduClassroomMapper eduClassroomMapper;

    /**
     * 查询教室
     *
     * @param classroomId 教室ID
     * @return 教室
     */
    @Override
    public EduClassroom selectEduClassroomById(Long classroomId) {
        return eduClassroomMapper.selectEduClassroomById(classroomId);
    }

    /**
     * 查询教室列表
     *
     * @param eduClassroom 教室
     * @return 教室
     */
    @Override
    public List<EduClassroom> selectEduClassroomList(EduClassroom eduClassroom) {
        return eduClassroomMapper.selectEduClassroomList(eduClassroom);
    }

    /**
     * 新增教室
     *
     * @param eduClassroom 教室
     * @return 结果
     */
    @Override
    public int insertEduClassroom(EduClassroom eduClassroom) {
        return eduClassroomMapper.insertEduClassroom(eduClassroom);
    }

    /**
     * 修改教室
     *
     * @param eduClassroom 教室
     * @return 结果
     */
    @Override
    public int updateEduClassroom(EduClassroom eduClassroom) {
        return eduClassroomMapper.updateEduClassroom(eduClassroom);
    }

    /**
     * 删除教室对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEduClassroomByIds(String ids) {
        return eduClassroomMapper.deleteEduClassroomByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教室信息
     *
     * @param classroomId 教室ID
     * @return 结果
     */
    @Override
    public int deleteEduClassroomById(Long classroomId) {
        return eduClassroomMapper.deleteEduClassroomById(classroomId);
    }
}
