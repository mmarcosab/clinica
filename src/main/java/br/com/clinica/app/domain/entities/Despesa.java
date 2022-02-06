package br.com.clinica.app.domain.entities;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Despesa {
    private String descricao;
    private BigDecimal valor;
}
