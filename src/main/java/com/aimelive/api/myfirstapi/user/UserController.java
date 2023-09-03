package com.aimelive.api.myfirstapi.user;

import com.aimelive.api.myfirstapi.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseData<User> newUser(@RequestBody User newUserBody){
        return  userService.newUser(newUserBody);
    }

    @GetMapping
    public ResponseData<List<User>> getAllUsers(){
       return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    ResponseData<User> getUserById(@PathVariable Long id){
        return  userService.getUserById(id);
    }

    @GetMapping("/findByEmail")
    ResponseData<User> getUserByEmail(@RequestParam String email){
      return  userService.getUserByEmail(email);
    }
    @PutMapping("/{id}")
    ResponseData<User> updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userService.updateUser(id,newUser);
    }

    @DeleteMapping("/{id}")
    ResponseData<Boolean> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
