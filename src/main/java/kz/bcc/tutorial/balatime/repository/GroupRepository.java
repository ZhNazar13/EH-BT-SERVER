package kz.bcc.tutorial.balatime.repository;

import kz.bcc.tutorial.balatime.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
