package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.Academ;

import java.util.List;

public interface AcademService {
    Academ create(Academ academ);

    Academ getById(Integer id);

    List<Academ> getAll();

    void delete(Integer id);
}
