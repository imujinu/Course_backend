package coruse.Course_registration.repository;

import coruse.Course_registration.domain.Course;
import coruse.Course_registration.domain.Enroll;
import coruse.Course_registration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<Enroll, Long> {



}

