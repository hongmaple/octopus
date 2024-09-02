package com.ruoyi.edu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.edu.domain.EduQuestion;
import com.ruoyi.edu.domain.EduTestRecords;
import com.ruoyi.edu.mapper.EduQuestionMapper;
import com.ruoyi.edu.mapper.EduTestRecordsMapper;
import com.ruoyi.edu.service.IEduTestRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

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
    @Autowired
    private EduQuestionMapper eduQuestionMapper;

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
        List<EduTestRecords> eduTestRecordsList = eduTestRecordsMapper.selectEduTestRecordsList(eduTestRecords);
        return eduTestRecordsList;
    }

    // 将jsonString转化为hashmap
    private HashMap<String, Object> fromJson2Map(String jsonString) {
        HashMap jsonMap = JSON.parseObject(jsonString, HashMap.class);

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for (Iterator iter = jsonMap.keySet().iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            if (jsonMap.get(key) instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) jsonMap.get(key);
                List list = handleJSONArray(jsonArray);
                resultMap.put(key, list);
            } else {
                resultMap.put(key, jsonMap.get(key));
            }
        }
        return resultMap;
    }

    private List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray) {
        List list = new ArrayList();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (entry.getValue() instanceof JSONArray) {
                    map.put((String) entry.getKey(), handleJSONArray((JSONArray) entry.getValue()));
                } else {
                    map.put((String) entry.getKey(), entry.getValue());
                }
            }
            list.add(map);
        }
        return list;
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
        HashMap<String, Object> singMap = fromJson2Map(eduTestRecords.getSingAnswerSheet());
        calculateSingScore(eduTestRecords, singMap);
        HashMap<String, Object> mutiMap = fromJson2Map(eduTestRecords.getMutiAnswerSheet());
        calculateMutiScore(eduTestRecords, mutiMap);
        HashMap<String, Object> judMap = fromJson2Map(eduTestRecords.getJudAnswerSheet());
        judMap.forEach((k, v) -> {
            Integer i = Integer.valueOf(String.valueOf(v));
            EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(Long.valueOf(k));
            if (i == 1) {
                if ("对".equals(eduQuestion.getAnswer())) {
                    eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
                }
            } else {
                if ("错".equals(eduQuestion.getAnswer())) {
                    eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
                }
            }
        });
        HashMap<String, Object> fillMap = fromJson2Map(eduTestRecords.getFillAnswerSheet());
        fillMap.forEach((k, v) -> {
            String i = (String) v;
            EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(Long.valueOf(k));
            if (i.equals(eduQuestion.getAnswer())) {
                eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
            }
        });
        return eduTestRecordsMapper.insertEduTestRecords(eduTestRecords);
    }

    private void calculateSingScore(EduTestRecords eduTestRecords, HashMap<String, Object> singMap) {
        singMap.forEach((k, v) -> {
            EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(Long.valueOf(k));
            Integer i = Integer.valueOf(String.valueOf(v));
            switch (i) {
                case 1:
                    if ("A".equals(eduQuestion.getAnswer())) {
                        eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
                    }
                    break;
                case 2:
                    if ("B".equals(eduQuestion.getAnswer())) {
                        eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
                    }
                    break;
                case 3:
                    if ("C".equals(eduQuestion.getAnswer())) {
                        eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
                    }
                    break;
                case 4:
                    if ("D".equals(eduQuestion.getAnswer())) {
                        eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
                    }
                    break;
                default:
                    break;
            }
        });
    }

    private void calculateMutiScore(EduTestRecords eduTestRecords, HashMap<String, Object> singMap) {
        singMap.forEach((k, v) -> {
            EduQuestion eduQuestion = eduQuestionMapper.selectEduQuestionById(Long.valueOf(k));
            String value = String.valueOf(v);
            int answerNum = eduQuestion.getAnswer().length();
            int correctNum = 0;
            String[] valseArrey = value.split(",");
            int solutionNum = valseArrey.length;
            for (String s : valseArrey) {
                Integer i = Integer.valueOf(s);
                switch (i) {
                    case 1:
                        if (eduQuestion.getAnswer().indexOf("A") != -1) {
                            correctNum++;
                        }
                        break;
                    case 2:
                        if (eduQuestion.getAnswer().indexOf("B") != -1) {
                            correctNum++;
                        }
                        break;
                    case 3:
                        if (eduQuestion.getAnswer().indexOf("C") != -1) {
                            correctNum++;
                        }
                        break;
                    case 4:
                        if (eduQuestion.getAnswer().indexOf("D") != -1) {
                            correctNum++;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (correctNum == solutionNum) {
                if (correctNum == answerNum) {
                    eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore());
                }
                if (answerNum > correctNum) {
                    eduTestRecords.setScore(eduTestRecords.getScore() + eduQuestion.getScore() * 0.5);
                }
            }
        });
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
