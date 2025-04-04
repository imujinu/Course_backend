package coruse.Course_registration;

import coruse.Course_registration.domain.User;
import coruse.Course_registration.repository.UserRepository;
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

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.KOREA);
        List<User> users = new ArrayList<>();

        // 앱 시작 시 이 코드가 실행됨
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
                    .password("2025" + String.format("%04d", 1+i))// 랜덤 이름
                    .studentNumber("2025" + String.format("%04d", 1+i))
                    .major("컴퓨터 공학과") // 랜덤 전공
                    .grade(randomValue)
                    .build();
            users.add(user);
        }

        userRepository.saveAll(users);

    }
}