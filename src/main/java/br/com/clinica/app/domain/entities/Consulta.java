package br.com.clinica.app.domain.entities;

import lombok.*;

import java.util.List;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Consulta {
    private String descricao;
    private List<String> exames;
    private Medico medico;
}
