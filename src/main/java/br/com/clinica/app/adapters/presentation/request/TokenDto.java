package br.com.clinica.app.adapters.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

    private String token;
    private String tipo;

    public TokenDto converter(String token, String tipo){
        return new TokenDto(token, tipo);
    }

}
