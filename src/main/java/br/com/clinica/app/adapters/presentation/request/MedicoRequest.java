package br.com.clinica.app.adapters.presentation.request;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoRequest {
    private String nome;
    private String cpf;
    private String rg;
    private String crm;
    private EnderecoRequest endereco;
}
