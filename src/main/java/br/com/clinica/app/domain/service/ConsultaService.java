package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.ConsultaResponse;
import br.com.clinica.app.domain.entities.Consulta;
import java.util.List;


public interface ConsultaService {
    ConsultaResponse create(Consulta consulta);
    List<ConsultaResponse> list();
    ConsultaResponse update(Consulta consulta, Long id);
    void delete(Long id);
    ConsultaResponse getById(Long id);
}
