package coruse.Course_registration.service;

import coruse.Course_registration.domain.Course;
import coruse.Course_registration.domain.Enroll;
import coruse.Course_registration.domain.User;
import coruse.Course_registration.dto.CourseResponse;
import coruse.Course_registration.repository.EnrollRepository;
import coruse.Course_registration.repository.CourseRepository;
import coruse.Course_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private EnrollRepository enrollRepository;
@Autowired
    public CourseService(CourseRepository courseRepository , EnrollRepository enrollRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollRepository = enrollRepository;
    }

    public List<CourseResponse> getAllCourse() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(CourseResponse::new) // Course -> CourseResponse 변환
                .collect(Collectors.toList()); // 리스트로 반환
    }

    public void courseRegi(Long studentId, List<Long> courseId ){
            User user = userRepository.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

            List<Course> courses = courseRepository.findByIdIn(courseId);

        List<Enroll> enrollList = courses.stream()
                .map(course -> Enroll.create(user, course)) // 생성 메서드 권장
                .collect(Collectors.toList());

        // 4. 일괄 저장
        enrollRepository.saveAll(enrollList);


                }


}
