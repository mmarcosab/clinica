package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoResponse {
    private Long id;
    private String servico;
    private BigDecimal valor;
}
