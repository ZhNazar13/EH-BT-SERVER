package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.dto.MyCourcesItem;
import kz.bcc.tutorial.balatime.model.dto.StudentHTDLItem;

import java.util.List;

public interface StudentWSService {
    List<StudentHTDLItem> getHotData(Integer studentId);

    List<MyCourcesItem> getMyCources(Integer studentId);
}
