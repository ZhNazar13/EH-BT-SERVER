package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Academ;
import kz.bcc.tutorial.balatime.repository.AcademRepository;
import kz.bcc.tutorial.balatime.service.AcademService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademServiceImpl implements AcademService {
    @Autowired
    private AcademRepository academRepository;

    @Override
    public Academ create(Academ academ) {
        return academRepository.save(academ);
    }

    @Override
    public Academ getById(Integer id) {
        Optional<Academ> optionalAcadem = academRepository.findById(id);
        if (optionalAcadem.isPresent()) {
            return academRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Academ> getAll() {
        return academRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Academ academ = getById(id);
        if (academ != null)
            academRepository.delete(academ);
    }
}
