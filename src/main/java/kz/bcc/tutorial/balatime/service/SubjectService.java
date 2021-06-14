package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.Subject;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectService {
    Subject create(Subject subject);

    Subject getById(Integer id);

    List<Subject> getAll();

    void delete(Integer id);

    Page<Subject> getAllByPageAndSize(Integer page, Integer size);
}
