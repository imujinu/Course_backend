package coruse.Course_registration.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secretKey = "yourSecretKey";  // JWT를 서명할 비밀 키
    private long expirationTime = 86400000L; // 24시간 유효

    // JWT 토큰 생성
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // 사용자 이름을 페이로드에 포함
                .setIssuedAt(new Date())  // 토큰 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))  // 만료 시간
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 비밀 키로 서명
                .compact();  // JWT 토큰 생성
    }

    // JWT 토큰에서 사용자 이름 추출
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject();
    }

    // JWT 토큰에서 클레임 추출 (헤더와 페이로드를 디코딩하여 클레임을 반환)
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)  // 비밀 키로 서명 검증
                .parseClaimsJws(token)
                .getBody();
    }

    // 토큰이 유효한지 검증
    public boolean validateToken(String token, String username) {
        String extractedUsername = getUsernameFromToken(token);
        return (username.equals(extractedUsername) && !isTokenExpired(token));
    }

    // 토큰 만료 여부 체크
    private boolean isTokenExpired(String token) {
        return getClaimsFromToken(token).getExpiration().before(new Date());
    }
}
