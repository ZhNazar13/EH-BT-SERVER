package kz.bcc.tutorial.balatime.model.dto.StudentUser;

import kz.bcc.tutorial.balatime.model.dto.LessonItem;
import lombok.Data;

@Data
public class SchedulerRow {
    private String time;
    private LessonItem l1;
    private LessonItem l2;
    private LessonItem l3;
    private LessonItem l4;
    private LessonItem l5;
}
