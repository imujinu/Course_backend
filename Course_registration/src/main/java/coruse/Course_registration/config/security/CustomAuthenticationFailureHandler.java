package coruse.Course_registration.config.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized 상태 코드 설정
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"아이디 또는 비밀번호가 틀렸습니다.\"}");
    }
}
