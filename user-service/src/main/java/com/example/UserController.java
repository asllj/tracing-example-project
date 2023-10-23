package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    public UserService userService;

     public UserController(UserService userService){
         this.userService = userService;
     }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
