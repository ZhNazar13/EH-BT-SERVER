package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Student;
import kz.bcc.tutorial.balatime.model.dto.MyCourcesItem;
import kz.bcc.tutorial.balatime.model.dto.HTDLItem;
import kz.bcc.tutorial.balatime.model.dto.HTDLItemContent;
import kz.bcc.tutorial.balatime.service.StudentWSService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentWSServiceImpl implements StudentWSService {
    @Override
    public List<HTDLItem> getHotData(Integer studentId) {
        List<HTDLItem> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            HTDLItem HTDLItem = new HTDLItem();
            HTDLItem.setTitle("08:00 Subject " + i);
            HTDLItem.setTeacher("Teacher " + i);
            HTDLItemContent content = new HTDLItemContent();
            content.setClassRoom("Classroom " + i);
            content.setHomeWork("Homework " + i);
            content.setTheme("Lesson title " + i);
            content.setAttendance(i % 2 == 0);
            content.setGrade(i * 10 - 4);
            HTDLItem.setContent(content);
            list.add(HTDLItem);
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
