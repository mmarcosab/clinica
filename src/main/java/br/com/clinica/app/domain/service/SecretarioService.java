package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.SecretarioResponse;
import br.com.clinica.app.domain.entities.Secretario;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;

import java.util.List;


public interface SecretarioService {
    SecretarioResponse create(Secretario secretario);
    List<SecretarioResponse> list();
    SecretarioResponse update(Secretario secretario, Long id) throws DadoNaoEncontradoException;
    void delete(Long id) throws DadoNaoEncontradoException;
    SecretarioResponse getById(Long id) throws DadoNaoEncontradoException;
}
