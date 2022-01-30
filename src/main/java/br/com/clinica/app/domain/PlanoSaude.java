package br.com.clinica.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class PlanoSaude {
    private String tipo;
    private String codigoIdentificacao;
    private String plano;
    private String cobertura;
}
