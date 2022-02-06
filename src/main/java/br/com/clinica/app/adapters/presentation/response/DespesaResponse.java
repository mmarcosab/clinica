package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DespesaResponse {
    private String descricao;
    private BigDecimal valor;
}
