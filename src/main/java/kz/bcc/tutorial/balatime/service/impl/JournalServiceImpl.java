package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Journal;
import kz.bcc.tutorial.balatime.repository.JournalRepository;
import kz.bcc.tutorial.balatime.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal create(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public Journal getById(Integer id) {
        Optional<Journal> optionalJournal = journalRepository.findById(id);
        if (optionalJournal.isPresent()) {
            return journalRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Journal journal = getById(id);
        if (journal != null)
            journalRepository.delete(journal);
    }
}
