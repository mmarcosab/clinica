package br.com.clinica.app.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
@Setter
public class Servico {
    private String servico;
    private BigDecimal valor;
}
