package br.com.clinica.app.adapters.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;


@Getter
@NoArgsConstructor
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
    @OneToOne(cascade=CascadeType.PERSIST)
    private MedicoData medico;
}
