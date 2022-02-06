package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCaixaSaidaResponse {
    List<DespesaResponse> despesas;
}
