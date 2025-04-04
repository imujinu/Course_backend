package coruse.Course_registration.repository;

import coruse.Course_registration.domain.Course;
import coruse.Course_registration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByStudentNumber(String studentNumber);

    Optional<Object> findById(String name);
}
