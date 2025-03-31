package coruse.Course_registration.service;

import coruse.Course_registration.domain.User;
import coruse.Course_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByStudentNumber(Long studentNumber){
        Optional<User> userInfo = userRepository.findUserByStudentNumber(studentNumber);

        return userInfo.orElseThrow(()-> new RuntimeException("학생을 찾을 수 없습니다."));

    }
}
