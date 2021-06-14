package kz.bcc.tutorial.balatime.repository;

import kz.bcc.tutorial.balatime.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByUserId(Integer userId);

    Page<Teacher> findAll(Pageable pageableRequest);
}
