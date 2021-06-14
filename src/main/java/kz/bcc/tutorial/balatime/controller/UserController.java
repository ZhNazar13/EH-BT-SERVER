package kz.bcc.tutorial.balatime.controller;

import io.swagger.annotations.ApiOperation;
import kz.bcc.tutorial.balatime.model.User;
import kz.bcc.tutorial.balatime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/private/v1/user", produces = APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all users")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @ApiOperation(value = "Create or update user object")
    @PostMapping()
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }
    @ApiOperation(value = "Get user by id")
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @ApiOperation(value = "Delete user by Id")
    @DeleteMapping("/id/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.delete(id);
    }

    @ApiOperation(value = "Get all users")
    @GetMapping("/page/{page}/size/{size}")
    public ResponseEntity<Page<User>> getByPageAndSize(
            @PathVariable Integer page,
            @PathVariable Integer size
    ){
        return ResponseEntity.ok(userService.getAllByPageAndSize(page,size));
    }
}
