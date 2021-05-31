package kz.bcc.tutorial.balatime.repository;

import kz.bcc.tutorial.balatime.model.Academ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademRepository extends JpaRepository<Academ, Integer> {
}
