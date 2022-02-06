package br.com.clinica.app.domain.entities;

import lombok.*;

import java.util.List;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class RegistroCaixaEntrada {
    private List<Servico> servicos;
}
