package com.kclm.owep.mapper.clazz;

import com.kclm.owep.entity.Chapter;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Homework;
import com.kclm.owep.entity.Section;
import com.kclm.owep.mapper.HomeworkMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HomeworkMapperTest {

    @Autowired
    private HomeworkMapper homeworkMapper;
    @Test
    void save() {
        Homework homework = new Homework();
        homework.setWorkTitle("课后作业");
        homework.setWorkContent("本节有三个小题 请完成");
        homework.setCourseName("Java核心技术（一）");
        Chapter chapter = new Chapter();
        chapter.setId(1);
        homework.setChapter(chapter);
        Section section = new Section();
        section.setId(1);
        homework.setSection(section);
        Clazz clazz = new Clazz();
        clazz.setId(1);
        homework.setClazz(clazz);
        homeworkMapper.save(homework);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteSelect() {
    }

    @Test
    void selectById() {
    }

    @Test
    void selectAll() {
        List<Homework> homework = homeworkMapper.selectAll();
        homework.forEach(System.out::println);
    }
}