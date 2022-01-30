package br.com.clinica.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@Setter
public class Paciente {
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private PlanoSaude planoSaude;
    private List<Consulta> historico;
}
