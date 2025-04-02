package coruse.Course_registration.service;

import coruse.Course_registration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseService {

    private CourseRepository courseRepository;

@Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


}
