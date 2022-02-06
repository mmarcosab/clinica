package br.com.clinica.app.domain.entities;

import lombok.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Medico {
    private Long codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String crm;
    private Endereco endereco;
}
