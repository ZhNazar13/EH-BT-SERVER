package kz.bcc.tutorial.balatime.repository;

import kz.bcc.tutorial.balatime.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
