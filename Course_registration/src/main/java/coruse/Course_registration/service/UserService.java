package coruse.Course_registration.service;

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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollRepository enrollRepository;

    @Autowired
    public UserService(UserRepository userRepository, CourseRepository courseRepository, EnrollRepository enrollRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollRepository = enrollRepository;
    }

    public List<User> getUsersWithCustomQuery(Long keyword) {
        return userRepository.findUsersWithCustomQuery(keyword);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }






    public UserLoginResponse login(UserLoginRequest request){
       String studentNumber = request.getStudentNumber();
       String password = request.getPassword();

        Optional<User> User = userRepository.findByStudentNumber(studentNumber);

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
    public EnrolliResponse regist(EnrollRequest request) {
        Long id = request.getId();
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 강좌가 존재하지 않습니다."));

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        Enroll enroll = Enroll.builder()
                .user(user)
                .course(course)
                .build();

        enrollRepository.save(enroll);

        return new EnrolliResponse("수강신청이 완료되었습니다.");
    }


}
