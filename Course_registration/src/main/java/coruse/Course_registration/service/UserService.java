package coruse.Course_registration.service;

import coruse.Course_registration.domain.CourseRegistration;
import coruse.Course_registration.domain.User;
import coruse.Course_registration.repository.CourseRegistrationRepository;
import coruse.Course_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    public UserService(UserRepository userRepository, CourseRegistrationRepository courseRegistrationRepository) {
        this.userRepository = userRepository;
        this.courseRegistrationRepository = courseRegistrationRepository;
    }

    public List<User> getUsersWithCustomQuery(Long keyword) {
        return userRepository.findUsersWithCustomQuery(keyword);  // QueryDSL 쿼리 실행
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void saveUserWithCourses() {
    }


}
