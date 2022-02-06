package br.com.clinica.app.domain.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Paciente {
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private PlanoSaude planoSaude;
    private List<Consulta> historico;
}
