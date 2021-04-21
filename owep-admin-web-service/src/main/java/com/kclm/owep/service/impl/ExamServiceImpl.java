package com.kclm.owep.service.impl;

import com.kclm.owep.convert.ExamBankConvert;
import com.kclm.owep.convert.ExamQuesConvert;
import com.kclm.owep.dto.ClientDTO;
import com.kclm.owep.dto.ExamBankDTO;
import com.kclm.owep.dto.ExamPaperDTO;
import com.kclm.owep.dto.ExamQuesDTO;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamPaperTopic;
import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.entity.vo.ExamPaperVo;
import com.kclm.owep.entity.vo.PaperVo;
import com.kclm.owep.entity.vo.QuesAneswerSet;
import com.kclm.owep.entity.vo.TopicKeyAndValue;
import com.kclm.owep.mapper.ExamBankMapper;
import com.kclm.owep.mapper.ExamPaperMapper;
import com.kclm.owep.mapper.ExamQuesMapper;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.ExamService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamBankMapper examBankMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ExamQuesMapper examQuesMapper;

    @Autowired
    ExamPaperMapper examPaperMapper;

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public List<ExamBankDTO> allExamBank(String name) {

        List<ExamBank> examBanks = examBankMapper.selectAllByUserType(userMapper.selectByName(name).getId());
        List<ExamBankDTO> examBankDTOs = new ArrayList<>();
        for (ExamBank e : examBanks) {
            examBankDTOs.add(ExamBankConvert.INSTANCE.entityToDTO(e));
        }
        return examBankDTOs;
    }

    @Override
    public List<ExamBankDTO> availableExamBank(String name) {
        List<ExamBank> examBanks = examBankMapper.selectAvailableByUserType(userMapper.selectByName(name).getId());
        List<ExamBankDTO> examBankDTOs = new ArrayList<>();
        for (ExamBank e : examBanks) {
            examBankDTOs.add(ExamBankConvert.INSTANCE.entityToDTO(e));
        }
        return examBankDTOs;
    }

    @Override
    public List<ExamBankDTO> findAllByKeys(ExamBank exam, String name) {
        List<ExamBank> examBanks = examBankMapper.selectAllByKeys(userMapper.selectByName(name).getId(), exam);
        List<ExamBankDTO> examBankDTOs = new ArrayList<>();
        for (ExamBank e : examBanks) {
            examBankDTOs.add(ExamBankConvert.INSTANCE.entityToDTO(e));
        }
        return examBankDTOs;
    }

    @Override
    public List<ExamBankDTO> findShareByKeys(ExamBank exam, String name) {
        List<ExamBank> examBanks = examBankMapper.selectShareByKeys(userMapper.selectByName(name).getId(), exam);
        List<ExamBankDTO> examBankDTOs = new ArrayList<>();
        for (ExamBank e : examBanks) {
            examBankDTOs.add(ExamBankConvert.INSTANCE.entityToDTO(e));
        }
        return examBankDTOs;
    }

    @Override
    public List<ExamBankDTO> shareExamBank(String name) {
        List<ExamBank> examBanks = examBankMapper.selectShareByUserType(userMapper.selectByName(name).getId());
        List<ExamBankDTO> examBankDTOs = new ArrayList<>();
        for (ExamBank e : examBanks) {
            examBankDTOs.add(ExamBankConvert.INSTANCE.entityToDTO(e));
        }
        return examBankDTOs;
    }

    @Override
    public Map<String, Object> alterBank(ExamBank examBank) {
        Map<String, Object> map = new HashMap<>();
        int row = examBankMapper.alterBank(examBank);
        if (row > 0) {
            map.put("state", 200);
            map.put("msg", "修改成功");
        } else {
            map.put("state", 201);
            map.put("msg", "修改失败，请检查网络");
        }
        return map;
    }

    @Override
    public Map<String, Object> addBank(ExamBank examBank, String name) {
        Map<String, Object> map = new HashMap<>();
        int row = examBankMapper.addBank(examBank, userMapper.selectByName(name).getId());
        if (row > 0) {
            map.put("state", 200);
            map.put("msg", "添加成功");
        } else {
            map.put("state", 201);
            map.put("msg", "添加失败，请检查网络");
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteBank(int id) {
        Map<String, Object> map = new HashMap<>();
        int row = examBankMapper.deleteBank(id);
        if (row > 0) {
            map.put("state", 200);
        } else {
            map.put("state", 201);
        }
        return map;
    }

    @Override
    public Map<String, Object> addQues(ExamQues examQues) {
        Map<String, Object> map = new HashMap<>();

        int row = examQuesMapper.addQues(examQues);
        if (row > 0) {
            int id = examQues.getId();   //获得试题的id
            int row2 = examQuesMapper.addQuesAnswer(id, examQues.getAnswerSetList());
            //判断是否添加到了答案表中
            if (row2 > 0) {
                map.put("msg", "添加成功！");
            } else {
                map.put("msg", "添加失败！");
            }
        } else {
            map.put("msg", "添加失败！");
        }

        return map;
    }

    @Override
    public List<ExamQuesDTO> allQues(String name) {
        List<ExamQues> ques = examQuesMapper.selectAllByUserName(name);
        List<ExamQuesDTO> quesDTOS = new ArrayList<>();
        for (ExamQues e : ques) {
            quesDTOS.add(ExamQuesConvert.INSTANCE.entityToDTO(e));
        }
        return quesDTOS;
    }

    @Override
    public List<ExamQuesDTO> findShareQues() {
        //找到共享题库
        List<Integer> ids = examBankMapper.shareBankIds();
        //根据id查询共享试题
        List<ExamQues> ques = examQuesMapper.findShareQues(ids);

        List<ExamQuesDTO> quesDTOS = new ArrayList<>();
        for (ExamQues e : ques) {
            quesDTOS.add(ExamQuesConvert.INSTANCE.entityToDTO(e));
        }

        return quesDTOS;
    }

    @Override
    public Map<String, Object> alterQues(ExamQues examQues) {
        Map<String, Object> map = new HashMap<>();
        //得到题库id
        Integer bankId = examBankMapper.selectIdByName(examQues.getExamBank().getBankName());
        //封装试题的实体类
        ExamBank examBank = new ExamBank();
        examBank.setId(bankId);
        examQues.setExamBank(examBank);
        //执行试题表的修改
        int row = examQuesMapper.alterQues(examQues);
        if (row > 0) {
            //先删除该试题下的选项
            examQuesMapper.delAnswerSet(examQues.getId());
            //再添加修改后的选项
            int row2 = examQuesMapper.addQuesAnswer(examQues.getId(), examQues.getAnswerSetList());
            //判断添加答案选项是否执行了
            if (row2 > 0) {
                map.put("msg", "修改成功！");
            } else {
                map.put("msg", "修改失败！");
            }
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }

    @Override
    public List<ExamQuesDTO> selectQuesByKeys(ExamQues examQues) {

        List<ExamQues> ques = examQuesMapper.selectByKeys(examQues);
        List<ExamQuesDTO> examQuesDTOS = new ArrayList<>();
        for (ExamQues e : ques) {
            examQuesDTOS.add(ExamQuesConvert.INSTANCE.entityToDTO(e));
        }
        return examQuesDTOS;
    }

    @Override
    public Map<String, Object> addPaper(ExamPaperVo paperVo) {
        Map<String, Object> map = new HashMap<>();
        //添加试卷的信息
        examPaperMapper.addPaper(paperVo.getExamPaper());
        //添加大题的信息
        for (ExamPaperTopic e: paperVo.getTopicList()) {
            //根据大题的id找到对应的小题
            for (TopicKeyAndValue t:paperVo.getKeyAndValueList()) {
                if(t.getKey().equals(e.getId())){
                    //插入大题数据
                    examPaperMapper.addTopic(e);
                    //得到大题在数据库中的id
                    for (QuesAneswerSet q:t.getValue()) {
                        //将id设置为数据库中大题的id
                        q.setId(e.getId());
                        //将id设置为数据库中试卷的id
                        q.setPaperId(paperVo.getExamPaper().getId());
                        examPaperMapper.addQuesSet(q);
                    }
                }
            }

        map.put("msg","添加成功！");
        }
        //添加每道大题对应小题的信息
        return map;
    }

    @Override
    public List<ExamPaperDTO> findAllPapers(String name) {
        List<PaperVo> examPaperVos = examPaperMapper.findAllPaper(name);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        return mapperFacade.mapAsList(examPaperVos, ExamPaperDTO.class);
    }

    @Override
    public List<ExamPaperDTO> findPaperById(Integer id, String name) {
        List<PaperVo> examPaperVos = examPaperMapper.findPaperById(id,name);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        return mapperFacade.mapAsList(examPaperVos, ExamPaperDTO.class);
    }

    @Override
    @Transactional
    public Map<String, Object> alterPaper(ExamPaperVo paperVo) {
        //获得试卷的id
        Integer paperId = paperVo.getExamPaper().getId();
        //获得大题的id
        List<Integer> ids = examPaperMapper.findTopicById(paperId);
        //先删除试卷
        examPaperMapper.delQuesById(paperId);
        examPaperMapper.delTopicById(ids);
        examPaperMapper.delPaperById(paperId);
        //添加试卷
        Map<String, Object> map = new HashMap<>();
        //添加试卷的信息
        examPaperMapper.addPaper(paperVo.getExamPaper());
        //添加大题的信息
        for (ExamPaperTopic e: paperVo.getTopicList()) {
            //根据大题的id找到对应的小题
            for (TopicKeyAndValue t:paperVo.getKeyAndValueList()) {
                if(t.getKey().equals(e.getId())){
                    //插入大题数据
                    examPaperMapper.addTopic(e);
                    //得到大题在数据库中的id
                    for (QuesAneswerSet q:t.getValue()) {
                        //将id设置为数据库中大题的id
                        q.setId(e.getId());
                        //将id设置为数据库中试卷的id
                        q.setPaperId(paperVo.getExamPaper().getId());
                        examPaperMapper.addQuesSet(q);
                    }
                }
            }

            map.put("msg","修改成功！");
        }
        //添加每道大题对应小题的信息
        return map;
    }
}
