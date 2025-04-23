package coruse.Course_registration.config.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthentication extends AbstractAuthenticationToken {

    private final String username;

    public JwtAuthentication(String username) {
        super(null);  // 권한은 아직 설정되지 않았으므로 null
        this.username = username;
        setAuthenticated(true);  // 이미 인증된 사용자
    }

    @Override
    public Object getCredentials() {
        return null;  // JWT 토큰에서 자격 증명은 별도로 필요하지 않으므로 null 반환
    }

    @Override
    public Object getPrincipal() {
        return username;  // JWT에서 추출한 사용자 이름
    }
}
