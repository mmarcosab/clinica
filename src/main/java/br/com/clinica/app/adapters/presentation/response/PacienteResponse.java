package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private EnderecoResponse endereco;
    private PlanoSaudeResponse planoSaude;
    private List<ConsultaResponse> historico;
}
