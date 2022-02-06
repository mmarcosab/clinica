package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoResponse {
    private String servico;
    private BigDecimal valor;
}
