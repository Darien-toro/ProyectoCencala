package com.project.springboot.cencala.lavandery.controller;

import com.project.springboot.cencala.lavandery.dto.UserTypeDto;
import com.project.springboot.cencala.lavandery.service.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserTypeController {

    private final UserTypeService userService;

    @GetMapping
    public ResponseEntity<List<UserTypeDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTypeDto> getUserById(@PathVariable Integer id) {
        UserTypeDto user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserTypeDto> createUser(@RequestBody UserTypeDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserTypeDto> updateUser(@PathVariable Integer id, @RequestBody UserTypeDto userDto) {
        UserTypeDto updated = userService.updateUser(id, userDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
