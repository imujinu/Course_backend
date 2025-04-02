package coruse.Course_registration.repository;

import coruse.Course_registration.domain.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
}

