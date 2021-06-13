package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.dto.HTDLItem;
import kz.bcc.tutorial.balatime.model.dto.MyGroupsItem;

import java.util.List;

public interface TeacherWSService {
    List<HTDLItem> getHotDataTeacher(Integer teacherId);

    List<MyGroupsItem> getMyGroups (Integer teacherId);
}
