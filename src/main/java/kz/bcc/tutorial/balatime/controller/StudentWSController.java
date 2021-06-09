package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.dto.MyCourcesItem;
import kz.bcc.tutorial.balatime.model.dto.StudentHTDLItem;
import kz.bcc.tutorial.balatime.service.StudentWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/student/ws", produces = APPLICATION_JSON_VALUE)

public class StudentWSController {
    @Autowired
    StudentWSService studentWSService;

    @ApiOperation(value = "Get hot data")
    @GetMapping("/hot/studentId/{studentId}")
    public ResponseEntity<List<StudentHTDLItem>> getHotData(@PathVariable Integer studentId) {

        return ResponseEntity.ok(studentWSService.getHotData(studentId));
    }

    @ApiOperation(value = "Get my cources")
    @GetMapping("/myCources/studentId/{studentId}")
    public  ResponseEntity<List<MyCourcesItem>> getMyCources(@PathVariable Integer studentId){
        return ResponseEntity.ok(studentWSService.getMyCources(studentId));
    }
}
