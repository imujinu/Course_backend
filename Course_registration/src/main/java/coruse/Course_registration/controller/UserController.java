package coruse.Course_registration.controller;

import coruse.Course_registration.domain.User;
import coruse.Course_registration.dto.CourseRegiRequest;
import coruse.Course_registration.dto.CourseRegiResponse;
import coruse.Course_registration.dto.UserLoginRequest;
import coruse.Course_registration.dto.UserLoginResponse;
import coruse.Course_registration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{studentNumber}")
    public User getUser(@PathVariable Long studentNumber) {
        return (User) userService.getUsersWithCustomQuery(studentNumber);
    }



    @GetMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest request) {
        UserLoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/course")
    public ResponseEntity<CourseRegiResponse> regist(@Valid @RequestBody CourseRegiRequest request){
        CourseRegiResponse response = userService.regist(request);
        return ResponseEntity.ok(response);
    }
}
