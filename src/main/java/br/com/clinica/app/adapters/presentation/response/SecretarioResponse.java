package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SecretarioResponse {
    private String id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private EnderecoResponse endereco;
}
