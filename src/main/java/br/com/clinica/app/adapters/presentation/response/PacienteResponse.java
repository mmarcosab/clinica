package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {
    private String id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private EnderecoResponse endereco;
    private PlanoSaudeResponse planoSaude;
    private List<ConsultaResponse> historico;
}
