package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Schedule;
import kz.bcc.tutorial.balatime.model.dto.LessonItem;
import kz.bcc.tutorial.balatime.model.dto.SchedulerRow;
import kz.bcc.tutorial.balatime.repository.ScheduleRepository;
import kz.bcc.tutorial.balatime.service.TeacherSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherSchedulerServiceImpl implements TeacherSchedulerService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public List<SchedulerRow> getAll(Integer teacherId) {
        List<SchedulerRow> answer = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Integer subjectOrder = i + 1;
            List<Schedule> scheduleBySubjectOrder = scheduleRepository.findAllByTeacherIdAndSubjectOrder(teacherId, subjectOrder);
            SchedulerRow schedulerRow = new SchedulerRow();
            schedulerRow.setTime((i + 9) + ":00");
            schedulerRow.setL1(objectMapperDto(scheduleBySubjectOrder, DayOfWeek.MONDAY));
            schedulerRow.setL2(objectMapperDto(scheduleBySubjectOrder, DayOfWeek.TUESDAY));
            schedulerRow.setL3(objectMapperDto(scheduleBySubjectOrder, DayOfWeek.WEDNESDAY));
            schedulerRow.setL4(objectMapperDto(scheduleBySubjectOrder, DayOfWeek.THURSDAY));
            schedulerRow.setL5(objectMapperDto(scheduleBySubjectOrder, DayOfWeek.FRIDAY));
            answer.add(schedulerRow);
        }
        return answer;
    }

    LessonItem objectMapperDto(List<Schedule> timetableListByOrder, DayOfWeek dayOfWeek) {

        LessonItem lessonItem = new LessonItem();
        Optional<Schedule> ot = timetableListByOrder.stream().filter(tt -> tt.getDayOfWeek().getValue() == dayOfWeek.getValue()).findFirst();
        if (ot.isPresent()) {
            Schedule timetable = ot.get();
            lessonItem.setGroup(timetable.getGroup().getName());
            lessonItem.setName(timetable.getAcadem().getSubject().getName());
            lessonItem.setTeacher(timetable.getTeacher().getFirstName());
            lessonItem.setEmpty(false);
        } else {
            lessonItem.setGroup("");
            lessonItem.setName("relax");
            lessonItem.setTeacher("");
            lessonItem.setEmpty(true);
        }
        return lessonItem;

    }
}
