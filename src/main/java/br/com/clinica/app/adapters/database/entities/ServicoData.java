package br.com.clinica.app.adapters.database.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@Setter
@Entity
public class ServicoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao_servico")
    private String servico;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;
}
