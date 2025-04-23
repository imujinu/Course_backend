package coruse.Course_registration.repository;

import coruse.Course_registration.domain.Course;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    List<Course> findByIdIn(List<Long> ids);
}
