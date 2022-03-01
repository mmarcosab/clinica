package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenService {

    @Value("${clinica.jwt.expiration}")
    private Long exp;

    @Value(("${clinica.jwt.secret}"))
    private String secret;

    public String gerarToken(Authentication authentication){
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date data = new Date();
        return Jwts.builder()
                .setIssuer("Clinica")// quem gerou
                .setSubject(logado.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(data.getTime() + exp))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }


}
