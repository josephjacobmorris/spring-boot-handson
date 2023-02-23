package com.example.springboothandson.controllers;

import com.example.springboothandson.domain.User;
import com.example.springboothandson.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        validateUser(user);
        userService.createUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/")
    public @ResponseBody List<User> listUsers(){
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{id}/")
    public @ResponseBody User findUser(@PathVariable("id") String id){
        return userService.findById(Long.valueOf(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/user/{id}/")
    public void deleteUser(@PathVariable("id") String id){
         userService.deleteById(Long.valueOf(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/")
    public void findUser(@RequestBody User user){
        validateUser(user);
        userService.updateUser(user);
    }

    private static void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User should not be null");
        }
    }
}
