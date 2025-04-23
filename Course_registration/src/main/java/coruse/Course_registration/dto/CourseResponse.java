package coruse.Course_registration.dto;

import coruse.Course_registration.domain.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CourseResponse {
    private Long id;
    private String course;
    private String professor;
    private String isOnline;
    private String isMajor;
    private String date;
    private String time;

    public CourseResponse(Course course) {
        this.id = course.getId();
        this.course = course.getCourse();
        this.professor = course.getProfessor();
        this.isOnline = course.getIsOnline();
        this.isMajor = course.getIsMajor();
        this.date = course.getDate();
        this.time = course.getTime();
    }
}
