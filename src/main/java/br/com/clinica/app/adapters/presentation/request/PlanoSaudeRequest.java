package br.com.clinica.app.adapters.presentation.request;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlanoSaudeRequest {
    private String tipo;
    private String codigoIdentificacao;
    private String plano;
    private String cobertura;
}
