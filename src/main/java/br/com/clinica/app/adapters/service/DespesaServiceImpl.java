package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.DespesaData;
import br.com.clinica.app.adapters.database.repository.DespesaRepository;
import br.com.clinica.app.adapters.presentation.response.DespesaResponse;
import br.com.clinica.app.domain.entities.Despesa;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.DespesaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {

    private ModelMapper modelMapper = new ModelMapper();
    private final DespesaRepository repository;
    private static final String NOT_FOUND = "despesa nao contrada pelo id: ";

    @Override
    public DespesaResponse create(Despesa despesa) {
        var despesaData = modelMapper.map(despesa, DespesaData.class);
        return modelMapper.map(repository.save(despesaData), DespesaResponse.class);
    }

    @Override
    public List<DespesaResponse> list() {
        List<DespesaData> despesasData = repository.findAll();
        List<DespesaResponse> despesasResponse = new ArrayList<>();
        for(DespesaData s : despesasData){
            despesasResponse.add(modelMapper.map(s, DespesaResponse.class));
        }
        return despesasResponse;
    }

    @Override
    public DespesaResponse update(Despesa despesa, Long id) throws DadoNaoEncontradoException {
        var despesaPesquisada = repository.findById(id);
        if(despesaPesquisada.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        var despesaData = modelMapper.map(despesa, DespesaData.class);
        despesaData.setId(id);
        return modelMapper.map(repository.save(despesaData), DespesaResponse.class);
    }

    @Override
    public void delete(Long id) throws DadoNaoEncontradoException {
        var despesaData = repository.findById(id);
        if(despesaData.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        repository.deleteById(id);
    }

    @Override
    public DespesaResponse getById(Long id) throws DadoNaoEncontradoException {
        var despesaData = repository.findById(id);
        if(despesaData.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        return modelMapper.map(despesaData.get(), DespesaResponse.class);
    }

}
