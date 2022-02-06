package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlanoSaudeResponse {
    private String tipo;
    private String codigoIdentificacao;
    private String plano;
    private String cobertura;
}
