package br.com.clinica.app.adapters.presentation.response;

import lombok.*;


@ToString
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
