package coruse.Course_registration.service;

import coruse.Course_registration.domain.Course;
import coruse.Course_registration.domain.CourseRegistration;
import coruse.Course_registration.domain.User;
import coruse.Course_registration.dto.CourseRegiRequest;
import coruse.Course_registration.dto.CourseRegiResponse;
import coruse.Course_registration.dto.UserLoginRequest;
import coruse.Course_registration.dto.UserLoginResponse;
import coruse.Course_registration.repository.CourseRegistrationRepository;
import coruse.Course_registration.repository.CourseRepository;
import coruse.Course_registration.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    public UserService(UserRepository userRepository, CourseRepository courseRepository, CourseRegistrationRepository courseRegistrationRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.courseRegistrationRepository = courseRegistrationRepository;
    }

    public List<User> getUsersWithCustomQuery(Long keyword) {
        return userRepository.findUsersWithCustomQuery(keyword);  // QueryDSL 쿼리 실행
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }






    public UserLoginResponse login(UserLoginRequest request){
       String studentNumber = request.getStudentNumber();
       String password = request.getPassword();

        Optional<User> User = userRepository.findByStudentNumber(studentNumber);

        // 2. 유저가 존재하는지 확인
        if (User.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 학번입니다.");
        }

        User user = User.get();

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new UserLoginResponse(user.getName());
    }

    @Transactional
    public CourseRegiResponse regist(CourseRegiRequest request) {
        Long id = request.getId();
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 강좌가 존재하지 않습니다."));

        User user = userRepository.findById(id) // 또는 SecurityContextHolder 등
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        CourseRegistration courseRegistration = CourseRegistration.builder()
                .user(user)
                .course(course)
                .build();

        courseRegistrationRepository.save(courseRegistration);

        return new CourseRegiResponse("수강신청이 완료되었습니다.");
    }


}
