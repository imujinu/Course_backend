package coruse.Course_registration.service;


import coruse.Course_registration.domain.CourseRegistration;
import coruse.Course_registration.domain.User;
import coruse.Course_registration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers // TestContainers 사용 선언
@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/ssac?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true",
        "spring.datasource.username=ssac",
        "spring.datasource.password=1234",
        "spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver"
})
public class UserServiceTest {

}