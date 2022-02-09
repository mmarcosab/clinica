package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.ServicoData;
import br.com.clinica.app.adapters.database.repository.ServicoRepository;
import br.com.clinica.app.adapters.presentation.response.ServicoResponse;
import br.com.clinica.app.domain.entities.Servico;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.ServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService {

    private ModelMapper modelMapper = new ModelMapper();
    private final ServicoRepository servicoRepository;
    private static final String NOT_FOUND = "servico nao contrado pelo id: ";

    @Override
    public ServicoResponse create(Servico servico) {
        ServicoData servicoData = modelMapper.map(servico, ServicoData.class);
        return modelMapper.map(servicoRepository.save(servicoData), ServicoResponse.class);
    }

    @Override
    public List<ServicoResponse> list() {
        List<ServicoData> servicosData = servicoRepository.findAll();
        List<ServicoResponse> servicosResponse = new ArrayList<>();
        for(ServicoData s : servicosData){
            servicosResponse.add(modelMapper.map(s, ServicoResponse.class));
        }
        return servicosResponse;
    }

    @Override
    public ServicoResponse update(Servico servico, Long id) throws DadoNaoEncontradoException {
        var servicoPesquisado = servicoRepository.findById(id);
        if(servicoPesquisado.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        var servicoData = modelMapper.map(servico, ServicoData.class);
        servicoData.setId(id);
        return modelMapper.map(servicoRepository.save(servicoData), ServicoResponse.class);
    }

    @Override
    public void delete(Long id) throws DadoNaoEncontradoException {
        var servicoData = servicoRepository.findById(id);
        if(servicoData.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        servicoRepository.deleteById(id);
    }

    @Override
    public ServicoResponse getById(Long id) throws DadoNaoEncontradoException {
        var servicoData = servicoRepository.findById(id);
        if(servicoData.isEmpty()){
            throw new DadoNaoEncontradoException(NOT_FOUND + id);
        }
        return modelMapper.map(servicoData.get(), ServicoResponse.class);
    }

}
