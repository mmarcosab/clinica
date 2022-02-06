package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

import java.util.List;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCaixaEntradaResponse {
    private List<ServicoResponse> servicos;
}
