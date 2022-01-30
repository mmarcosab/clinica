package br.com.clinica.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Medico {
    private String nome;
    private String cpf;
    private String rg;
    private String crm;
    private Endereco endereco;
}
