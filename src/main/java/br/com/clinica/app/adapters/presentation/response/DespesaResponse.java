package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DespesaResponse {
    private String descricao;
    private BigDecimal valor;
}
