package br.com.clinica.app.domain.entities;

import lombok.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class PlanoSaude {
    private String tipo;
    private String codigoIdentificacao;
    private String plano;
    private String cobertura;
}
