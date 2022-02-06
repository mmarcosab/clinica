package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.ServicoResponse;
import br.com.clinica.app.domain.entities.Servico;
import java.util.List;


public interface ServicoService {
    ServicoResponse create(Servico servico);
    List<ServicoResponse> list();
    ServicoResponse update(Servico servico, Long id);
    void delete(Long id);
    ServicoResponse getById(Long id);
}
