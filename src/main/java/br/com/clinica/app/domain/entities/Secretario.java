package br.com.clinica.app.domain.entities;

import lombok.*;

import java.time.LocalDate;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Secretario {
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private Endereco endereco;
}
