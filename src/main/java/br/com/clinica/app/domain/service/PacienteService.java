package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.PacienteResponse;
import br.com.clinica.app.domain.entities.Paciente;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;

import java.util.List;


public interface PacienteService {
    PacienteResponse create(Paciente paciente);
    List<PacienteResponse> list();
    PacienteResponse update(Paciente paciente, Long id) throws DadoNaoEncontradoException;
    void delete(Long id) throws DadoNaoEncontradoException;
    PacienteResponse getById(Long id) throws DadoNaoEncontradoException;
}
