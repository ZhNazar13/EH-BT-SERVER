package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.Student;
import kz.bcc.tutorial.balatime.model.Teacher;
import kz.bcc.tutorial.balatime.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/student", produces = APPLICATION_JSON_VALUE)
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "Get all students")
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @ApiOperation(value = "Create or update student object")
    @PostMapping()
    public ResponseEntity<Student> postStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.create(student));
    }
    @ApiOperation(value = "Get student by id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }
    @ApiOperation(value = "Delete student by id")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.ok("Student by " + id + "was deleted!");
    }

    @ApiOperation(value = "Get all students")
    @GetMapping("/page/{page}/size/{size}")
    public ResponseEntity<Page<Student>> getByPageAndSize(
            @PathVariable Integer page,
            @PathVariable Integer size
    ){
        return ResponseEntity.ok(studentService.getAllByPageAndSize(page,size));
    }
}
