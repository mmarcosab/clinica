package br.com.clinica.app.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
@Setter
public class Despesa {
    private String descricao;
    private BigDecimal valor;
}
