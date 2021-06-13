package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Schedule;
import kz.bcc.tutorial.balatime.model.dto.HTDLItem;
import kz.bcc.tutorial.balatime.model.dto.HTDLItemContent;
import kz.bcc.tutorial.balatime.model.dto.MyGroupsItem;
import kz.bcc.tutorial.balatime.repository.ScheduleRepository;
import kz.bcc.tutorial.balatime.service.TeacherWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;

@Service
public class TeacherWSServiceImpl implements TeacherWSService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public List<HTDLItem> getHotDataTeacher(Integer teacherId) {
        List<HTDLItem> list = new ArrayList<>();
        List<Schedule> scheduleByDayOfWeek = scheduleRepository.findAllByTeacherIdAndDayOfWeek(teacherId, MONDAY);
        for (int i = 0; i < scheduleByDayOfWeek.size(); i++) {
            HTDLItem htdlItem = new HTDLItem();
            Schedule schedule = scheduleByDayOfWeek.get(i);
            htdlItem.setTitle((i + 9) + ":00 " + schedule.getAcadem().getSubject().getName());
            htdlItem.setGroup(schedule.getGroup().getName());
            HTDLItemContent content = new HTDLItemContent();
            content.setClassRoom(schedule.getClassRoom());
            content.setHomeWork(schedule.getAcadem().getHomework());
            content.setTheme(schedule.getAcadem().getTheme());
            htdlItem.setContent(content);
            list.add(htdlItem);
        }
        return list;
    }

    @Override
    public List<MyGroupsItem> getMyGroups(Integer teacherId) {
        List<MyGroupsItem> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyGroupsItem myGroupsItem = new MyGroupsItem();
            myGroupsItem.setGroup((i + 1) + "A");
            myGroupsItem.setSubject("Math");
            list.add(myGroupsItem);
        }
        return list;
    }
}
