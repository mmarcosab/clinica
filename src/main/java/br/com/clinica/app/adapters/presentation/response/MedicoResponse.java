package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponse {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String crm;
    private EnderecoResponse endereco;
}
