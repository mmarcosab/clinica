package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.SecretarioData;
import br.com.clinica.app.adapters.database.repository.SecretarioRepository;
import br.com.clinica.app.adapters.presentation.response.SecretarioResponse;
import br.com.clinica.app.domain.entities.Secretario;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.SecretarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SecretarioServiceImpl implements SecretarioService {

    private ModelMapper modelMapper = new ModelMapper();
    private final SecretarioRepository secretarioRepository;


    @Override
    public SecretarioResponse create(Secretario secretario) {
        SecretarioData secretarioData = modelMapper.map(secretario, SecretarioData.class);
        SecretarioResponse response = modelMapper.map(secretarioRepository.save(secretarioData), SecretarioResponse.class);
        return response;
    }

    @Override
    public List<SecretarioResponse> list() {
        List<SecretarioData> secretariosData = secretarioRepository.findAll();
        List<SecretarioResponse> secretariosResponse = new ArrayList<>();
        for(SecretarioData s : secretariosData){
            secretariosResponse.add(modelMapper.map(s, SecretarioResponse.class));
        }
        return secretariosResponse;
    }

    @Override
    public SecretarioResponse update(Secretario secretario, Long id) throws DadoNaoEncontradoException {
        var secretarioPesquisado = secretarioRepository.findById(id);
        if(secretarioPesquisado.isEmpty()){
            throw new DadoNaoEncontradoException("secretario nao contrado pelo id: " + id);
        }
        var secretarioData = modelMapper.map(secretario, SecretarioData.class);
        secretarioData.setId(id);
        return modelMapper.map(secretarioRepository.save(secretarioData), SecretarioResponse.class);
    }

    @Override
    public void delete(Long id) throws DadoNaoEncontradoException {
        var secretarioData = secretarioRepository.findById(id);
        if(secretarioData.isEmpty()){
            throw new DadoNaoEncontradoException("secretario nao contrado pelo id: " + id);
        }
        secretarioRepository.deleteById(id);
    }

    @Override
    public SecretarioResponse getById(Long id) throws DadoNaoEncontradoException {
        var secretarioData = secretarioRepository.findById(id);
        if(secretarioData.isEmpty()){
            throw new DadoNaoEncontradoException("secretario nao contrado pelo id: " + id);
        }
        return modelMapper.map(secretarioData, SecretarioResponse.class);
    }

}
