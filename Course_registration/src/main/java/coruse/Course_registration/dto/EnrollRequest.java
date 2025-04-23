package coruse.Course_registration.dto;

import lombok.Data;

@Data
public class EnrollRequest {
    private Long id;
    private String course;
    private String date;
    private String isMajor;
    private String isOnline;
    private String professor;
    private String time;
}
