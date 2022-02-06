package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.MedicoData;
import br.com.clinica.app.adapters.database.repository.MedicoRepository;
import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Medico;
import br.com.clinica.app.domain.service.MedicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private ModelMapper modelMapper = new ModelMapper();
    private final MedicoRepository medicoRepository;


    @Override
    public MedicoResponse create(Medico medico) {
        MedicoData secretarioData = modelMapper.map(medico, MedicoData.class);
        MedicoResponse response = modelMapper.map(medicoRepository.save(secretarioData), MedicoResponse.class);
        return response;
    }

    @Override
    public List<MedicoResponse> list() {
        List<MedicoData> medicosData = medicoRepository.findAll();
        List<MedicoResponse> medicosResponse = new ArrayList<>();
        for(MedicoData s : medicosData){
            medicosResponse.add(modelMapper.map(s, MedicoResponse.class));
        }
        return medicosResponse;
    }

    @Override
    public MedicoResponse update(Medico medico, Long id) {
        MedicoData medicoData = modelMapper.map(medico, MedicoData.class);
        medicoData.setId(id);
        return modelMapper.map(medicoRepository.save(medicoData), MedicoResponse.class);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public MedicoResponse getById(Long id) {
        MedicoData secretarioData = medicoRepository.getById(id);
        //TODO colocar excecao de not found aqui
        return modelMapper.map(secretarioData, MedicoResponse.class);
    }

}
