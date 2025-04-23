package coruse.Course_registration.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Enroll() {} // JPA용 기본 생성자

    public static Enroll create(User user, Course course) {
        Enroll enroll = new Enroll();
        enroll.user = user;
        enroll.course = course;
        return enroll;
    }
}
