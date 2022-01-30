package br.com.clinica.app.adapters.database.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Builder
@Setter
@Entity
@Table(name = "medico")
public class MedicoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "crm")
    private String crm;
    @OneToOne
    private EnderecoData endereco;
}
