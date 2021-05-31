package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.Schedule;
import kz.bcc.tutorial.balatime.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/schedule", produces = APPLICATION_JSON_VALUE)
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @ApiOperation(value = "Get all records")
    @GetMapping("/all")
    public ResponseEntity<List<Schedule>> getAll() {
        return ResponseEntity.ok(scheduleService.getAll());
    }

    @ApiOperation(value = "Create or update schedule object")
    @PostMapping()
    public ResponseEntity<Schedule> postSchedule(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleService.create(schedule));
    }
    @ApiOperation(value = "Get record by id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Integer id) {
        return ResponseEntity.ok(scheduleService.getById(id));
    }
    @ApiOperation(value = "Delete record by id")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteScheduleById(@PathVariable Integer id) {
        scheduleService.delete(id);
        return ResponseEntity.ok("Schedule by " + id + "was deleted!");
    }
}
