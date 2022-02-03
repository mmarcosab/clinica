package br.com.clinica.app.adapters.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoResponse {
    private String rua;
    private String numero;
    private String cidade;
    private String complemento;
    private String bairro;
    private String uf;
}
