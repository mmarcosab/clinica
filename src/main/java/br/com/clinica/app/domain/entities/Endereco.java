package br.com.clinica.app.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String complemento;
    private String bairro;
    private String uf;
}
