package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DespesaResponse {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
}
