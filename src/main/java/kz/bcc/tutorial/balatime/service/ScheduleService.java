package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule create(Schedule schedule);

    Schedule getById(Integer id);

    List<Schedule> getAll();

    void delete(Integer id);
}
