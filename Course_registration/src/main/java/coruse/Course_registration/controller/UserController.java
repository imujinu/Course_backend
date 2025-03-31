package coruse.Course_registration.controller;

import coruse.Course_registration.domain.User;
import coruse.Course_registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{studentNumber}")
    public User getUser(@PathVariable Long studentNumber) {
        return userService.getUserByStudentNumber(studentNumber);
    }

}
