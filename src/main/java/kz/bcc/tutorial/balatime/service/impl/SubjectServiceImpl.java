package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Subject;
import kz.bcc.tutorial.balatime.repository.SubjectRepository;
import kz.bcc.tutorial.balatime.repository.pagination.SubjectPagingRepository;
import kz.bcc.tutorial.balatime.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectPagingRepository subjectPagingRepository;

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getById(Integer id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            return subjectRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Subject subject = getById(id);
        if (subject != null)
            subjectRepository.delete(subject);
    }

    @Override
    public Page<Subject> getAllByPageAndSize(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return subjectPagingRepository.findAll(pageable);
    }
}
