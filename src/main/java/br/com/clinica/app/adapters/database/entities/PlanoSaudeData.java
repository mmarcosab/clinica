package br.com.clinica.app.adapters.database.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Getter
@Builder
@Setter
@Entity
@Table(name = "plano_saude")
public class PlanoSaudeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "codigo_identificacao")
    private String codigoIdentificacao;
    @Column(name = "plano")
    private String plano;
    @Column(name = "cobertura")
    private String cobertura;
}
