package kz.bcc.tutorial.balatime.service.impl;

        import kz.bcc.tutorial.balatime.model.dto.LessonItem;
        import kz.bcc.tutorial.balatime.model.dto.SchedulerRow;
        import kz.bcc.tutorial.balatime.service.StudentSchedulerService;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;

@Service
public class StudentSchedulerImpl implements StudentSchedulerService {

    @Override
    public List<SchedulerRow> getAll(Integer studentId, Integer year, Integer month, Integer day) {
        List<SchedulerRow> answer = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SchedulerRow schedulerRow = new SchedulerRow();
            schedulerRow.setTime((i+8)+":55");
            LessonItem l1 = new LessonItem();
            l1.setTeacher("teacher l1"+1);
            l1.setGroup("group l1"+1);
            l1.setName("name l1"+1);
            schedulerRow.setL1(l1);
            LessonItem l2 = new LessonItem();
            l2.setTeacher("teacher l2"+2);
            l2.setGroup("group l2"+2);
            l2.setName("name l2"+2);
            schedulerRow.setL1(l2);
            LessonItem l3 = new LessonItem();
            l3.setTeacher("teacher l3"+3);
            l3.setGroup("group l3"+3);
            l3.setName("name l3"+3);
            schedulerRow.setL1(l3);
            LessonItem l4 = new LessonItem();
            l4.setTeacher("teacher l4"+4);
            l4.setGroup("group l4"+4);
            l4.setName("name l4"+4);
            schedulerRow.setL1(l4);
            LessonItem l5 = new LessonItem();
            l5.setTeacher("teacher l5"+5);
            l5.setGroup("group l5"+5);
            l5.setName("name l5"+5);
            schedulerRow.setL1(l5);
            answer.add(schedulerRow);
        }
        return answer;
    }
}
