package com.springsecurity.controller;

import com.springsecurity.model.User;
import com.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PatchMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser) {
        User user = userService.updateUser(updatedUser);
        if(user!=null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "userId") String userId) {
        String message = userService.deleteUser(userId);
        if(message!=null) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
