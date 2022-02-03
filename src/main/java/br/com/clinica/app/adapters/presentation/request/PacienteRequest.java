package br.com.clinica.app.adapters.presentation.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequest {
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private EnderecoRequest endereco;
    private PlanoSaudeRequest planoSaude;
    private List<ConsultaRequest> historico;
}
