package coruse.Course_registration.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginRequest {
    @NotNull(message = "학번을 입력해 주세요")
    @Size(min = 8, max = 8, message = "8자리의 학번을 입력해 주세요")
    @Pattern(regexp = "\\d{8}", message = "숫자로 된 학번을 입력해주세요")
    private String studentNumber;

    @NotNull(message = "비밀번호를 입력해 주세요")
    @Size(min = 4, max = 10, message = "비밀번호는 4~10자리로 입력해주세요")
    private String password;
}
