package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.Grade;
import kz.bcc.tutorial.balatime.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/grade", produces = APPLICATION_JSON_VALUE)
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @ApiOperation(value = "Get All grades")
    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getAll() {
        return ResponseEntity.ok(gradeService.getAll());
    }

    @ApiOperation(value = "Create or update grade object")
    @PostMapping()
    public ResponseEntity<Grade> calculateTestObject(@RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.create(grade));
    }
    @ApiOperation(value = "Get grades by id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Integer id) {
        return ResponseEntity.ok(gradeService.getById(id));
    }
    @ApiOperation(value = "Delete grade by id")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteGradeById(@PathVariable Integer id) {
        gradeService.delete(id);
        return ResponseEntity.ok("Grade by " + id + "was deleted!");
    }
}