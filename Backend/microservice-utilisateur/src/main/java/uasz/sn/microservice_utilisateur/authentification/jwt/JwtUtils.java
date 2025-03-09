package uasz.sn.microservice_utilisateur.authentification.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtUtils {
    @Value("${app.secret-key}")
    private String secretKey;
    @Value("${app.expiration-time}")
    private String expirationTime;

    public String generateToken(String username){
        List<>
    }

}
