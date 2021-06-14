package kz.bcc.tutorial.balatime.repository.pagination;

import kz.bcc.tutorial.balatime.model.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupPagingRepository extends PagingAndSortingRepository<Group, Integer> {
    Page<Group> findAll(Pageable pageable);
}
