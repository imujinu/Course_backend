package coruse.Course_registration.dto;

import coruse.Course_registration.domain.Enroll;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EnrollRequest {
   private List<Long> courseNumber;
   private String name;
}
