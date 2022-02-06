package br.com.clinica.app.domain.service;

import br.com.clinica.app.adapters.presentation.response.SecretarioResponse;
import br.com.clinica.app.domain.entities.Secretario;
import java.util.List;


public interface SecretarioService {
    SecretarioResponse create(Secretario secretario);
    List<SecretarioResponse> list();
    SecretarioResponse update(Secretario secretario, Long id);
    void delete(Long id);
    SecretarioResponse getById(Long id);
}
