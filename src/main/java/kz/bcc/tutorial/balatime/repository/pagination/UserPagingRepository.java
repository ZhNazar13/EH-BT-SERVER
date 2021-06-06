package kz.bcc.tutorial.balatime.repository.pagination;

import kz.bcc.tutorial.balatime.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingRepository extends PagingAndSortingRepository<User, Integer> {
    Page<User> findAll(Pageable pageable);
}
