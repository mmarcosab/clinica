package br.com.clinica.app.adapters.presentation.request;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {
    private String rua;
    private String numero;
    private String cidade;
    private String complemento;
    private String bairro;
    private String uf;
}
