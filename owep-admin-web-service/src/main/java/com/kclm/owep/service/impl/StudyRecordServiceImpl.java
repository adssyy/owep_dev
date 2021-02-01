package com.kclm.owep.service.impl;

import com.kclm.owep.StudyRecordStatisticsDTO;
import com.kclm.owep.entity.StudyRecord;
import com.kclm.owep.entity.StudyRecordStatistics;
import com.kclm.owep.mapper.HomeworkAnswerMapper;
import com.kclm.owep.mapper.HomeworkMapper;
import com.kclm.owep.mapper.StudyRecordMapper;
import com.kclm.owep.service.StudyRecordService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class StudyRecordServiceImpl implements StudyRecordService {

    @Autowired
    private StudyRecordMapper studyRecordMapper;

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Autowired
    private HomeworkAnswerMapper homeworkAnswerMapper;

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public int create(StudyRecord studyRecord) {
        return this.studyRecordMapper.save(studyRecord);
    }

    @Override
    public int update(StudyRecord studyRecord) {
        return this.studyRecordMapper.update(studyRecord);
    }

    @Override
    public int delete(Integer id) {
        return this.studyRecordMapper.deleteById(id);
    }

    @Override
    public List<StudyRecordStatisticsDTO> selectAll() {
        List<StudyRecordStatistics> studyRecordStatistics = this.studyRecordMapper.selectAllStudyRecordStatistics();
        return entityToDTO(studyRecordStatistics);
    }

    @Override
    public List<StudyRecordStatisticsDTO> selectByKeyword(String orgName, String branchName, Serializable pid, Serializable cid) {
        List<StudyRecordStatistics> studyRecordStatistics = this.studyRecordMapper.selectStudyRecordStatisticsByKeyword(orgName, branchName, pid, cid);

        return entityToDTO(studyRecordStatistics);
    }

    @Override
    public List<StudyRecordStatisticsDTO> entityToDTO(List<StudyRecordStatistics> studyRecords){
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<StudyRecordStatisticsDTO> studyRecordStatisticsDTOS = mapperFacade.mapAsList(studyRecords, StudyRecordStatisticsDTO.class);
        for (StudyRecordStatisticsDTO studyRecordStatisticsDTO : studyRecordStatisticsDTOS){
            studyRecordStatisticsDTO.setVideoProcess(Math.floor(studyRecordStatisticsDTO.getTotalVideoRate()/studyRecordStatisticsDTO.getTotalVideoLength()*100));
            double totalHomework = homeworkMapper.countByClassId(studyRecordStatisticsDTO.getStudent().getClazz().getId());
            double answer = homeworkAnswerMapper.countByStudentId(studyRecordStatisticsDTO.getStudent().getId());
            System.out.println(totalHomework);
            System.out.println(answer);
            if (totalHomework != 0){
                studyRecordStatisticsDTO.setHomeworkProcess(Math.floor(answer/totalHomework*100));
            }else {
                studyRecordStatisticsDTO.setHomeworkProcess(0.0);
            }
        }
        return studyRecordStatisticsDTOS;
    }
}
