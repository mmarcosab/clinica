package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Medico;

import java.util.List;

public interface MedicoService {
    MedicoResponse create(Medico medico);
    List<MedicoResponse> list();
    MedicoResponse update(Medico medico, Long id);
    void delete(Long id);
    MedicoResponse getById(Long id);
}
