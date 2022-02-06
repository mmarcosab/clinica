package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Medico;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;

import java.util.List;

public interface MedicoService {
    MedicoResponse create(Medico medico);
    List<MedicoResponse> list();
    MedicoResponse update(Medico medico, Long id) throws DadoNaoEncontradoException;
    void delete(Long id) throws DadoNaoEncontradoException;
    MedicoResponse getById(Long id) throws DadoNaoEncontradoException;
}
