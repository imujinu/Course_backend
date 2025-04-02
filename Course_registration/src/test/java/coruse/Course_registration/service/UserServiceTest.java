package coruse.Course_registration.service;


import coruse.Course_registration.domain.CourseRegistration;
import coruse.Course_registration.domain.User;
import coruse.Course_registration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/ssac?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true",
        "spring.datasource.username=ssac",
        "spring.datasource.password=1234",
        "spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver"
})
class UserServiceTest {

    @Autowired
     UserRepository userRepository;

    @Test
    @Transactional
    public void saveUserWithCourses() {
        // given
        User user = new User();
        user.setName("Jinwoo");
        user.setMajor("Computer Science");
        user.setGrade(4L);

        CourseRegistration course1 = new CourseRegistration();
        course1.setCourseName("Spring Boot");
        course1.setProfessor("Dr. Kim");
        course1.setCredits(3);
        course1.setUser(user);

        CourseRegistration course2 = new CourseRegistration();
        course2.setCourseName("Database Systems");
        course2.setProfessor("Dr. Park");
        course2.setCredits(3);
        course2.setUser(user);

        user.getRegistrations().add(course1);
        user.getRegistrations().add(course2);

        // when
        User savedUser = userRepository.save(user);

        // then
        assertNotNull(savedUser.getId());
        assertEquals(2, savedUser.getRegistrations().size());
    }
}