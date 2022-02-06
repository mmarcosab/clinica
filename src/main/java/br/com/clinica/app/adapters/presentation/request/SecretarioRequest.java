package br.com.clinica.app.adapters.presentation.request;

import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SecretarioRequest {
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private EnderecoRequest endereco;
}
