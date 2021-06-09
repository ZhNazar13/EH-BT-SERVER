package kz.bcc.tutorial.balatime.model.dto;

import lombok.Data;

@Data
public class StudentHTDLItemContent {
    private String classRoom;
    private String homeWork;
    private String nextLesson;
    private Boolean attendance;
    private Integer grade;

}
