package coruse.Course_registration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private Long id;
    private String name;
    private Long studentNumber;
    private String password;
    private String major;
    private long grade;

    @Builder
    public User(Long id, String name, Long studentNumber, String password, String major, long grade) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.password = password;
        this.major = major;
        this.grade = grade;
    }
}
