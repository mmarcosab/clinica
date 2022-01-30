package br.com.clinica.app.adapters.database.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@Setter
@Entity
@Table(name = "consulta")
public class ConsultaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany
    private List<ExameData> exames;
    @ManyToOne
    private MedicoData medico;
}
