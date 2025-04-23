package coruse.Course_registration.service;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

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