package br.com.clinica.app.adapters.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "paciente")
public class PacienteData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @OneToOne(cascade=CascadeType.PERSIST)
    private EnderecoData endereco;
    @OneToOne(cascade=CascadeType.PERSIST)
    private PlanoSaudeData planoSaude;
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<ConsultaData> historico;
}
