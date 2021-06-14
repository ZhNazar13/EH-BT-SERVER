package kz.bcc.tutorial.balatime.model.dto.StudentUser;

import lombok.Data;

@Data
public class LessonItem {
    private String name;
    private String teacher;
    private String group;
    private String Room;
    private Integer day;
    private boolean free;
}



