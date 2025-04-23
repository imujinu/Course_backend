package coruse.Course_registration.controller;

import coruse.Course_registration.dto.*;
import coruse.Course_registration.service.CourseService;
import coruse.Course_registration.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    private final UserService userService;
    private final CourseService courseService;

    @Autowired
    public UserController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;

    }


    //로그인
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest request,  HttpServletResponse response) {
        UserLoginResponse result = userService.login(request, response);
        return ResponseEntity.ok(result);
    }

    //강좌 조회
    @GetMapping("/course")
    public ResponseEntity<List<CourseResponse>> course() {
        List<CourseResponse> courseResponses = courseService.getAllCourse();
        return ResponseEntity.ok(courseResponses);
    }

    //수강 신청
    @PostMapping("/regist")
    public ResponseEntity<EnrolliResponse> regist(@Valid @RequestBody EnrollRequest request){
        EnrolliResponse response = userService.regist(request);
        return ResponseEntity.ok(response);
    }



}
