package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Room;
import kz.bcc.tutorial.balatime.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    ClassRoomRepository classroomRepository;

    @Override
    public Room getById(int id) {
        return classroomRepository.findById(id).get();
    }

    @Override
    public Room create(Room classroom) {
        if (classroomRepository.existsByCode(classroom.getCode())) {
            return null;
        }
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Room> getAll() {
        return classroomRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        classroomRepository.deleteById(id);
    }
}
