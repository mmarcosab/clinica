package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.PacienteResponse;
import br.com.clinica.app.domain.entities.Paciente;
import java.util.List;


public interface PacienteService {
    PacienteResponse create(Paciente paciente);
    List<PacienteResponse> list();
    PacienteResponse update(Paciente paciente, Long id);
    void delete(Long id);
    PacienteResponse getById(Long id);
}
