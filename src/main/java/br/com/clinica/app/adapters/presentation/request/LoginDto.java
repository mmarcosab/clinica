package br.com.clinica.app.adapters.presentation.request;


import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String email;
    private String password;

    public UsernamePasswordAuthenticationToken converter(){
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}
