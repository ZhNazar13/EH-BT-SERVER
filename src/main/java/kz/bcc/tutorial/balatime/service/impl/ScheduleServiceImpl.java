package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Schedule;
import kz.bcc.tutorial.balatime.repository.ScheduleRepository;
import kz.bcc.tutorial.balatime.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getById(Integer id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            return scheduleRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Schedule schedule = getById(id);
        if (schedule != null)
            scheduleRepository.delete(schedule);
    }
}
