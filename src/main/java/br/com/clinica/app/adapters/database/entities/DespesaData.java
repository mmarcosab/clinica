package br.com.clinica.app.adapters.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "despesa")
public class DespesaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "data")
    private LocalDate data;
}
