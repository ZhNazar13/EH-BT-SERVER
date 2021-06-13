package kz.bcc.tutorial.balatime.repository;

import io.swagger.models.auth.In;
import kz.bcc.tutorial.balatime.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByTeacherIdAndSubjectOrder(Integer teacherId, Integer subjectOrder);

    List<Schedule> findAllByTeacherIdAndDayOfWeek(Integer teacherId, DayOfWeek dayOfWeek);
}
