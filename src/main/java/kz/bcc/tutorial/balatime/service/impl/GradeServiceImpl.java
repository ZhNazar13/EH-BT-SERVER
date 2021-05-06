package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Grade;
import kz.bcc.tutorial.balatime.model.Student;
import kz.bcc.tutorial.balatime.model.Teacher;
import kz.bcc.tutorial.balatime.repository.GradeRepository;
import kz.bcc.tutorial.balatime.repository.TeacherRepository;
import kz.bcc.tutorial.balatime.service.GradeService;
import kz.bcc.tutorial.balatime.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade create(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade getById(Integer id) {
        Optional<Grade> optionalGrade = gradeRepository.findById(id);
        if (optionalGrade.isPresent()) {
            return gradeRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Grade grade = getById(id);
        if (grade != null)
            gradeRepository.delete(grade);
    }
}
