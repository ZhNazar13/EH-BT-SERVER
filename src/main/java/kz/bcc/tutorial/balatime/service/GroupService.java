package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.Group;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GroupService {
    Group create(Group group);

    Group getById(Integer id);

    List<Group> getAll();

    void delete(Integer id);

    Page<Group> getAllByPageAndSize(Integer page, Integer size);
}
