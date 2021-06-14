package kz.bcc.tutorial.balatime.repository.pagination;

import kz.bcc.tutorial.balatime.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectPagingRepository extends PagingAndSortingRepository<Subject, Integer> {
    Page<Subject> findAll(Pageable pageable);
}
