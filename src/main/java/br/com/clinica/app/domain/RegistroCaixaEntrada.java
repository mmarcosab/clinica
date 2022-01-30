package br.com.clinica.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class RegistroCaixaEntrada {
    private List<Servico> servicos;
}
