package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.ServicoResponse;
import br.com.clinica.app.domain.entities.Servico;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;

import java.util.List;


public interface ServicoService {
    ServicoResponse create(Servico servico);
    List<ServicoResponse> list();
    ServicoResponse update(Servico servico, Long id) throws DadoNaoEncontradoException;
    void delete(Long id) throws DadoNaoEncontradoException;
    ServicoResponse getById(Long id) throws DadoNaoEncontradoException;
}
