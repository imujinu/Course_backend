package coruse.Course_registration.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long studentNumber;
    private String password;
    private String major;
    private Long grade;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseRegistration> registrations = new ArrayList<>();

    @Builder
    public User(Long id, String name, Long studentNumber, String password, String major, long grade) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.password = password;
        this.major = major;
        this.grade = grade;
    }

    public User() {

    }
}
