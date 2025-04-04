package coruse.Course_registration.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    private Boolean isOnline;
    private String type;
    private Date date;

    @OneToMany(mappedBy = "course")
    private List<CourseRegistration> registrations;

}
