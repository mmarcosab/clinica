package br.com.clinica.app.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Medico {
    private Long codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String crm;
    private Endereco endereco;
}
