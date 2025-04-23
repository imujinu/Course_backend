package coruse.Course_registration.config.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 작업
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String token = httpRequest.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // "Bearer " 제거
            if (jwtUtil.validateToken(token, "expectedUsername")) {
                // 인증 성공 시 필요한 로직
            }
        }

        chain.doFilter(request, response);  // 다음 필터로 요청 전달
    }

    @Override
    public void destroy() {
        // 종료 작업
    }
}
