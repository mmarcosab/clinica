package br.com.clinica.app.adapters.presentation.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DespesaRequest {
    private String descricao;
    private BigDecimal valor;
}
