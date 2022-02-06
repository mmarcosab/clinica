package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

import java.util.List;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponse {
    private Long id;
    private String descricao;
    private List<String> exames;
    private MedicoResponse medico;
}
