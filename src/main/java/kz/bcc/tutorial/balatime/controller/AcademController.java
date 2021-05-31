package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.Academ;
import kz.bcc.tutorial.balatime.service.AcademService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/academ", produces = APPLICATION_JSON_VALUE)
public class AcademController {
    @Autowired
    private AcademService academService;

    @ApiOperation(value = "Get all records")
    @GetMapping("/all")
    public ResponseEntity<List<Academ>> getAll() {
        return ResponseEntity.ok(academService.getAll());
    }

    @ApiOperation(value = "Create or update record")
    @PostMapping()
    public ResponseEntity<Academ> postAcadem(@RequestBody Academ academ) {
        return ResponseEntity.ok(academService.create(academ));
    }
    @ApiOperation(value = "Get record by id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Academ> getAcademById(@PathVariable Integer id) {
        return ResponseEntity.ok(academService.getById(id));
    }
    @ApiOperation(value = "Delete record by id")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteAcademById(@PathVariable Integer id) {
        academService.delete(id);
        return ResponseEntity.ok("Record by " + id + "was deleted!");
    }
}
