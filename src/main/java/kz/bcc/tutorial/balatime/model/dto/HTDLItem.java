package kz.bcc.tutorial.balatime.model.dto;

import lombok.Data;

@Data
public class HTDLItem {
    private String title;
    private String teacher;
    private String group;
    private HTDLItemContent content;

}
