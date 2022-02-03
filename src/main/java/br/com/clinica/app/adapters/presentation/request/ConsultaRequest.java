package br.com.clinica.app.adapters.presentation.request;

import lombok.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequest {

    private String descricao;
    private List<String> exames;
    private MedicoRequest medico;
}
