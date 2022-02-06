package br.com.clinica.app.adapters.presentation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoResponse {
    private Long id;
    private String servico;
    private BigDecimal valor;
    @JsonProperty(value = "data_criacao")
    private LocalDate dataCriacao;
}
