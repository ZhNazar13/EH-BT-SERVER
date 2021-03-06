package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.dto.SchedulerRow;
import kz.bcc.tutorial.balatime.service.StudentSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/scheduler/student", produces = APPLICATION_JSON_VALUE)
public class StudentSchedulerController {
    @Autowired
    StudentSchedulerService studentSchedulerService;

    @ApiOperation(value = "Get scheduler map")
    @GetMapping("/all/studentId/{studentId}")
    public ResponseEntity<List<SchedulerRow>> getAll(
            @PathVariable Integer studentId,
            @RequestParam Integer year,
            @RequestParam Integer month,
            @RequestParam Integer day
    ){
        return ResponseEntity.ok(studentSchedulerService.getAll(studentId, year, month, day));
    };
}
