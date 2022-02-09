package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.ConsultaData;
import br.com.clinica.app.adapters.database.repository.ConsultaRepository;
import br.com.clinica.app.adapters.presentation.response.ConsultaResponse;
import br.com.clinica.app.domain.entities.Consulta;
import br.com.clinica.app.domain.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private ModelMapper modelMapper = new ModelMapper();
    private final ConsultaRepository repository;


    @Override
    public ConsultaResponse create(Consulta consulta) {
        ConsultaData consultaData = modelMapper.map(consulta, ConsultaData.class);
        return modelMapper.map(repository.save(consultaData), ConsultaResponse.class);
    }

    @Override
    public List<ConsultaResponse> list() {
        List<ConsultaData> consultasData = repository.findAll();
        List<ConsultaResponse> consultasResponse = new ArrayList<>();
        for(ConsultaData c : consultasData){
            consultasResponse.add(modelMapper.map(c, ConsultaResponse.class));
        }
        return consultasResponse;
    }

    @Override
    public ConsultaResponse update(Consulta consulta, Long id) {
        ConsultaData consultaData = modelMapper.map(consulta, ConsultaData.class);
        consultaData.setId(id);
        return modelMapper.map(repository.save(consultaData), ConsultaResponse.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ConsultaResponse getById(Long id) {
        ConsultaData consultaData = repository.getById(id);
        //TODO colocar excecao de not found aqui
        return modelMapper.map(consultaData, ConsultaResponse.class);
    }

}
