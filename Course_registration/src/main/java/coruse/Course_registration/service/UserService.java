package coruse.Course_registration.service;

import coruse.Course_registration.config.security.JwtUtil;
import coruse.Course_registration.domain.Course;
import coruse.Course_registration.domain.Enroll;
import coruse.Course_registration.domain.User;
import coruse.Course_registration.dto.EnrollRequest;
import coruse.Course_registration.dto.EnrolliResponse;
import coruse.Course_registration.dto.UserLoginRequest;
import coruse.Course_registration.dto.UserLoginResponse;
import coruse.Course_registration.repository.EnrollRepository;
import coruse.Course_registration.repository.CourseRepository;
import coruse.Course_registration.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class UserService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollRepository enrollRepository;

    public UserLoginResponse login(UserLoginRequest request, HttpServletResponse response){
       String studentNumber = request.getStudentNumber();
       String password = request.getPassword();

        Optional<User> User = userRepository.findByStudentNumber(studentNumber);

        if (User.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 학번입니다.");
        }

        User user = User.get();
        String name = user.getName();
        String number = user.getStudentNumber();
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = JwtUtil.generateToken(name);
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return new UserLoginResponse(name, number, token) ;
    }

    @Transactional
    public EnrolliResponse regist(EnrollRequest request) {
        System.out.println("=== 1 ===");
        List<Long> coursesNumber = request.getCourseNumber();
        System.out.println("=== 2 ===");
        String name = request.getName();
        System.out.println("name: " + name);
        System.out.println("*************" + name);
        List<Course> courseList = courseRepository.findByCourseNumber(coursesNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 강좌가 존재하지 않습니다."));
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        for (Course course : courseList) {
            Enroll enroll = Enroll.builder()
                    .user(user)
                    .course(course)
                    .build();

            enrollRepository.save(enroll);
        }

        return new EnrolliResponse("수강신청이 완료되었습니다.");
    }


}
