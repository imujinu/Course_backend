package coruse.Course_registration.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String professor;
    private int credits;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
