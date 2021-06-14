package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Group;
import kz.bcc.tutorial.balatime.repository.GroupRepository;
import kz.bcc.tutorial.balatime.repository.pagination.GroupPagingRepository;
import kz.bcc.tutorial.balatime.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupPagingRepository groupPagingRepository;

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getById(Integer id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            return groupRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Group group = getById(id);
        if (group != null)
            groupRepository.delete(group);
    }

    @Override
    public Page<Group> getAllByPageAndSize(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return groupPagingRepository.findAll(pageable);
    }
}
