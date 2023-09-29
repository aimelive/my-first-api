package com.aimelive.api.myfirstapi.user;

import com.aimelive.api.myfirstapi.dto.ResponseData;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@Tag(
        name = "User",
        description = "User management"
)
@SecurityRequirement(name = "bearerAuth") //Protecting all routes of this controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(
            description = "Create new user account",
            summary = "Register new user",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid token",
                            responseCode = "403"
                    ),
                    @ApiResponse(
                            description = "User exists",
                            responseCode = "500"
                    ),
            }

    )
    @Hidden
    ResponseData<User> newUser(@RequestBody User newUserBody){
        return  userService.newUser(newUserBody);
    }

    @GetMapping
    @Operation(
            summary = "List of all users",
            description = "GET all users registered"
    )

    public ResponseData<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "GET User by ID",
            description = "Get user data by specifying ID"
    )
    ResponseData<User> getUserById(@PathVariable Long id){
        return  userService.getUserById(id);
    }

    @GetMapping("/findByEmail")
    @Operation(
            summary = "GET User by Email",
            description = "Get user data by specifying Email"
    )
    ResponseData<User> getUserByEmail(@RequestParam String email){
      return  userService.getUserByEmail(email);
    }
    @PatchMapping("/{id}")
    @Operation(
            summary = "Update User",
            description = "Update User data by specifying ID and specify the JWT token of the current user so that you can update only your profile if you are not an admin"
    )
    ResponseData<User> updateUser(@RequestBody UpdateUserRequest newUser, @PathVariable Long id){
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete User",
            description = "Remove user from the system by specifying ID and specify the JWT token of the current user so that you can delete only your account if you are not an admin"
    )
    ResponseData<Boolean> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
