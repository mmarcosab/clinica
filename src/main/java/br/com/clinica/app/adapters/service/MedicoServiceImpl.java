package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.MedicoData;
import br.com.clinica.app.adapters.database.repository.MedicoRepository;
import br.com.clinica.app.adapters.presentation.mapper.MedicoMapper;
import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Medico;
import br.com.clinica.app.domain.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    @Override
    public MedicoResponse create(Medico medico) {
        MedicoData medicoData = MedicoMapper.map(medico);
        MedicoData result = medicoRepository.save(medicoData);
        return MedicoMapper.map(result);
    }

    @Override
    public List<MedicoResponse> list() {
        return MedicoMapper.map(medicoRepository.findAll());
    }

    @Override
    public MedicoResponse update(Medico medico) {
        return null;
    }

    @Override
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public MedicoResponse getById(Long id) {
        Optional<MedicoData> medico = medicoRepository.findById(id);
        if (medico.isPresent()) {
            return MedicoMapper.map(medico.get());
        }
        return null;
    }

}
