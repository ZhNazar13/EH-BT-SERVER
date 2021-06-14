package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.Group;
import kz.bcc.tutorial.balatime.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/group", produces = APPLICATION_JSON_VALUE)
public class GroupController {
    @Autowired
    private GroupService groupService;

    @ApiOperation(value = "Get all classes")
    @GetMapping("/all")
    public ResponseEntity<List<Group>> getAll() {
        return ResponseEntity.ok(groupService.getAll());
    }

    @ApiOperation(value = "Create or update class object")
    @PostMapping()
    public ResponseEntity<Group> postClass(@RequestBody Group group) {
        return ResponseEntity.ok(groupService.create(group));
    }
    @ApiOperation(value = "Get class by id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Integer id) {
        return ResponseEntity.ok(groupService.getById(id));
    }
    @ApiOperation(value = "Delete class by id")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteGroupById(@PathVariable Integer id) {
        groupService.delete(id);
        return ResponseEntity.ok("Class by " + id + "was deleted!");
    }

    @ApiOperation(value = "Get all classes")
    @GetMapping("/page/{page}/size/{size}")
    public ResponseEntity<Page<Group>> getAllByPageAndSize(
            @PathVariable Integer page,
            @PathVariable Integer size
    ){
        return ResponseEntity.ok(groupService.getAllByPageAndSize(page, size));
    }
}
