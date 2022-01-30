package br.com.clinica.app.adapters.database.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Builder
@Setter
@Entity
@Table(name = "endereco")
public class EnderecoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero_residencia")
    private String numero;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "uf")
    private String uf;
}
