package coruse.Course_registration.repository;

import coruse.Course_registration.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepositoryCustom {

    Optional<List<Course>> findByCourseNumber(List<Long> coursesNumber);
}
