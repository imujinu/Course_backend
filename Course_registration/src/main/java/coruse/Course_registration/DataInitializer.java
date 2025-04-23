package coruse.Course_registration;

import coruse.Course_registration.domain.Course;
import coruse.Course_registration.domain.User;
import coruse.Course_registration.repository.CourseRepository;
import coruse.Course_registration.repository.UserRepository;
import lombok.Getter;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    @Getter
    private final CourseRepository courseRepository;

    public DataInitializer(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeUsers();
        initializeCourses();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {
            Faker faker = new Faker(Locale.KOREA);
            List<User> users = new ArrayList<>();
            User myUser = User.builder()
                    .name("임진우")
                    .password("20250001")
                    .studentNumber("20250001")
                    .major("컴퓨터공학과")
                    .grade(4.49)
                    .build();
            users.add(myUser);

            for (int i = 1; i <= 1000; i++) {
                double randomValue = 3.0 + (Math.random() * 1.5);
                randomValue = Math.floor(randomValue * 100) / 100.0;

                User user = User.builder()
                        .name(faker.name().fullName())
                        .password("2025" + String.format("%04d", 1+i))
                        .studentNumber("2025" + String.format("%04d", 1+i))
                        .major("컴퓨터 공학과")
                        .grade(randomValue)
                        .build();
                users.add(user);
            }

            userRepository.saveAll(users);
        }
    }

    private void initializeCourses() {
        if (courseRepository.count() == 0) {
            List<Course> courses = new ArrayList<>();

            Course course1 = Course.builder()
                    .course("데이터베이스")
                    .professor("김진우")
                    .isOnline("오프라인")
                    .isMajor("전공")
                    .date("월,목")
                    .time("8:50~11:50")
                    .build();
            courses.add(course1);

            Course course2 = Course.builder()
                    .course("운영체제")
                    .professor("박진우")
                    .isOnline("온라인")
                    .isMajor("전공")
                    .date("수,금")
                    .time("12:50~14:50")
                    .build();
            courses.add(course2);

            Course course3 = Course.builder()
                    .course("자료구조")
                    .professor("최진우")
                    .isOnline("오프라인")
                    .isMajor("전공")
                    .date("월")
                    .time("10:00~15:00")
                    .build();
            courses.add(course3);

            Course course4 = Course.builder()
                    .course("고전 문학의 이해")
                    .professor("우진김")
                    .isOnline("온라인")
                    .isMajor("교양")
                    .date("월")
                    .time("15:00~17:50")
                    .build();
            courses.add(course4);

            Course course5 = Course.builder()
                    .course("법과 정치")
                    .professor("이진우")
                    .isOnline("오프라인")
                    .isMajor("교양")
                    .date("목")
                    .time("10:00~11:50")
                    .build();
            courses.add(course5);

            Course course6 = Course.builder()
                    .course("삶과 철학")
                    .professor("우진우")
                    .isOnline("온라인")
                    .isMajor("교양")
                    .date("금")
                    .time("9:00~11:50")
                    .build();
            courses.add(course6);



            courseRepository.saveAll(courses);
        }
    }

}
