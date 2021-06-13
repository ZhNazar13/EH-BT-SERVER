package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.dto.HTDLItem;
import kz.bcc.tutorial.balatime.model.dto.LessonItem;
import kz.bcc.tutorial.balatime.model.dto.MyGroupsItem;
import kz.bcc.tutorial.balatime.service.TeacherWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/teacher/ws", produces = APPLICATION_JSON_VALUE)
public class TeacherWSController {
    @Autowired
    TeacherWSService teacherWSService;

    @ApiOperation(value = "Get hot data")
    @GetMapping("/hotData/teacherId/{teacherId}")
    public ResponseEntity<List<HTDLItem>> getHotDataTeacher(@PathVariable Integer teacherId){
        return ResponseEntity.ok(teacherWSService.getHotDataTeacher(teacherId));
    }

    @ApiOperation(value = "Get my groups")
    @GetMapping("/myGroups/teacherId/{teacherId}")
    public ResponseEntity<List<MyGroupsItem>> getMyGroups(@PathVariable Integer teacherId){
        return ResponseEntity.ok(teacherWSService.getMyGroups(teacherId));
    }
}
