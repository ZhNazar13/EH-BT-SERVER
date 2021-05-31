package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.Group;

import java.util.List;

public interface GroupService {
    Group create(Group group);

    Group getById(Integer id);

    List<Group> getAll();

    void delete(Integer id);
}
