package com.dentflow.user.controller;

import com.dentflow.auth.model.AuthUserResponse;
import com.dentflow.user.model.UserResponse;
import com.dentflow.user.model.User;
import com.dentflow.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("")
//    public List<User> getAllUsers() {
//        return userService.getAll();
//    }

//    @GetMapping("/{userId}")
//    public User getUser(@PathVariable Long userId) {
//        return userService.getUser(userId);
//    }

//    @GetMapping("/{userId}/all_clinics")
//    public Set<Clinic> getAllClinics(@PathVariable Long userId) {
//        return userService.getUser(userId).getClinics();
//    }
    @GetMapping("/profile")
    public UserResponse getUserProfile(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return new UserResponse(user.getFirstName(), user.getLastName(), user.getEmail());
    }

//    @Transactional
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<?> deleteUserAccount(@PathVariable Long userId){
//        userService.deleteUser(userId);
//        return ResponseEntity.noContent().build();
//    }
    @GetMapping("/getUser")
    public ResponseEntity<AuthUserResponse> getCurrentUser(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(new AuthUserResponse(user.getEmail()));
    }



}