package br.com.clinica.app.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class Consulta {
    private String descricao;
    private List<String> exames;
    private Medico medico;
}
