package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.MedicoData;
import br.com.clinica.app.adapters.database.repository.MedicoRepository;
import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Medico;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
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
    private static final String NOT_FOUND = "medico nao encontrado pelo id: ";

    @Override
    public MedicoResponse create(Medico medico) {
        MedicoData secretarioData = modelMapper.map(medico, MedicoData.class);
        return modelMapper.map(medicoRepository.save(secretarioData), MedicoResponse.class);
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
    public MedicoResponse update(Medico medico, Long id) throws DadoNaoEncontradoException {
        var medicoPesquisado = medicoRepository.findById(id);
        if(medicoPesquisado.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        var medicoData = modelMapper.map(medico, MedicoData.class);
        medicoData.setId(id);
        return modelMapper.map(medicoRepository.save(medicoData), MedicoResponse.class);
    }

    @Override
    public void delete(Long id) throws DadoNaoEncontradoException {
        var medicoData = medicoRepository.findById(id);
        if(medicoData.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        medicoRepository.deleteById(id);
    }

    @Override
    public MedicoResponse getById(Long id) throws DadoNaoEncontradoException {
        var medicoData = medicoRepository.findById(id);
        if(medicoData.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        return modelMapper.map(medicoData.get(), MedicoResponse.class);
    }

}
