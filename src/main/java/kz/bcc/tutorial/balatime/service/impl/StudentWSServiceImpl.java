package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.dto.MyCourcesItem;
import kz.bcc.tutorial.balatime.model.dto.StudentHTDLItem;
import kz.bcc.tutorial.balatime.model.dto.StudentHTDLItemContent;
import kz.bcc.tutorial.balatime.service.StudentWSService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentWSServiceImpl implements StudentWSService {
    @Override
    public List<StudentHTDLItem> getHotData(Integer studentId) {
        List<StudentHTDLItem> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            StudentHTDLItem studentHTDLItem = new StudentHTDLItem();
            studentHTDLItem.setTitle("08:00 Subject " + i);
            studentHTDLItem.setSummary("Teacher " + i);
            StudentHTDLItemContent content = new StudentHTDLItemContent();
            content.setClassRoom("Classroom " + i);
            content.setHomeWork("Homework " + i);
            content.setNextLesson("Lesson title " + i);
            content.setAttendance(i % 2 == 0);
            content.setGrade(i * 10 - 4);
            studentHTDLItem.setContent(content);
            list.add(studentHTDLItem);
        }
        return list;
    }

    @Override
    public List<MyCourcesItem> getMyCources(Integer studentId) {
        List<MyCourcesItem> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyCourcesItem myCourcesItem = new MyCourcesItem();
            myCourcesItem.setName("Subject" + i);
            myCourcesItem.setTeacher("Teacher" + i);
            list.add(myCourcesItem);
        }
        return list;
    }
}
