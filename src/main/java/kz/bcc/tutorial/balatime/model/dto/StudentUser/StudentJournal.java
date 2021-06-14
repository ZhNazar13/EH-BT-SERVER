package kz.bcc.tutorial.balatime.model.dto.StudentUser;

import kz.bcc.tutorial.balatime.model.dto.LessonItem;
import lombok.Data;

@Data
public class StudentJournal {
    private Integer ord;
    private String student;
    private String grade;
    private String prim;
}
