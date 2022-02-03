package br.com.clinica.app.adapters.presentation.request;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCaixaSaidaRequest {
    List<DespesaRequest> despesas;
}
