package br.com.clinica.app.adapters.database.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
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
    @OneToOne
    private EnderecoData endereco;
    @OneToOne
    private PlanoSaudeData planoSaude;
    @OneToMany
    private List<ConsultaData> historico;
}
