package br.com.clinica.app.domain.entities;

import lombok.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String complemento;
    private String bairro;
    private String uf;
}
