package br.com.clinica.app.adapters.presentation.response;

import lombok.*;

@Setter
@ToString
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
