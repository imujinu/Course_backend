package coruse.Course_registration.repository;

import coruse.Course_registration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //    User findByStudentNumber(Long studentNumber);
    // JPA에서 자동으로 생성해준 메소드, 필드와 이름이 일치해야 한다.
    // studentNumber, 학번을 매개변수로 받아서
    Optional<User> findUserByStudentNumber(Long studentNumber);

}
