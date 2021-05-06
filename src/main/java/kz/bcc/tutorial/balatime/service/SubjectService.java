package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject create(Subject subject);

    Subject getById(Integer id);

    List<Subject> getAll();

    void delete(Integer id);
}
