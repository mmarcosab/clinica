package br.com.clinica.app.adapters.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "secretario")
public class SecretarioData {
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
}
