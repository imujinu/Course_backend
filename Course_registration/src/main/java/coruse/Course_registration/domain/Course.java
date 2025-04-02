package coruse.Course_registration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courage;
    private String professor;
    private Boolean isOnline;
    private String type;
    private Date date;

    @Builder
    public Course(String courage, Date date, Long id, Boolean isOnline, String professor, String type) {
        this.courage = courage;
        this.date = date;
        this.id = id;
        this.isOnline = isOnline;
        this.professor = professor;
        this.type = type;
    }
}
