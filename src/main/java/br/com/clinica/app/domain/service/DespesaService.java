package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.DespesaResponse;
import br.com.clinica.app.domain.entities.Despesa;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import java.util.List;


public interface DespesaService {
    DespesaResponse create(Despesa despesa);
    List<DespesaResponse> list();
    DespesaResponse update(Despesa despesa, Long id) throws DadoNaoEncontradoException;
    void delete(Long id) throws DadoNaoEncontradoException;
    DespesaResponse getById(Long id) throws DadoNaoEncontradoException;
}
