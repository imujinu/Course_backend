package coruse.Course_registration.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String course;
    private String professor;
    private String isOnline;
    private String isMajor;
    private String date;
    private String time;

    @OneToMany(mappedBy = "course")
    private List<Enroll> registrations;

}
