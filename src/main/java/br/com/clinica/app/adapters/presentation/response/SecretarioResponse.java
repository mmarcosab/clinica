package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SecretarioResponse {
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private EnderecoResponse endereco;
}
