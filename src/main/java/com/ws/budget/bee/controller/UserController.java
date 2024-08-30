package com.ws.budget.bee.controller;

import com.ws.budget.bee.domain.user.User;
import com.ws.budget.bee.domain.user.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create (@RequestBody @Valid User newUser, UriComponentsBuilder uriBuilder) {
        var user = userService.create(newUser);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<User>> findAll (Pageable pageable) {
        var users = userService.findAll();
        var page = new PageImpl<>(users, pageable, users.size());

        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById (@PathVariable Long id){
        var user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update (@RequestBody @Valid User newUser) {
        var user = userService.update(newUser);

        return ResponseEntity.ok(user);
    }
}