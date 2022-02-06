package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.PacienteData;
import br.com.clinica.app.adapters.database.repository.PacienteRepository;
import br.com.clinica.app.adapters.presentation.response.PacienteResponse;
import br.com.clinica.app.domain.entities.Paciente;
import br.com.clinica.app.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private ModelMapper modelMapper = new ModelMapper();
    private final PacienteRepository pacienteRepository;


    @Override
    public PacienteResponse create(Paciente paciente) {
        PacienteData pacienteData = modelMapper.map(paciente, PacienteData.class);
        PacienteResponse response = modelMapper.map(pacienteRepository.save(pacienteData), PacienteResponse.class);
        return response;
    }

    @Override
    public List<PacienteResponse> list() {
        List<PacienteData> pacientesData = pacienteRepository.findAll();
        List<PacienteResponse> secretariosResponse = new ArrayList<>();
        for(PacienteData s : pacientesData){
            secretariosResponse.add(modelMapper.map(s, PacienteResponse.class));
        }
        return secretariosResponse;
    }

    @Override
    public PacienteResponse update(Paciente paciente, Long id) {
        PacienteData pacienteData = modelMapper.map(paciente, PacienteData.class);
        pacienteData.setId(id);
        return modelMapper.map(pacienteRepository.save(pacienteData), PacienteResponse.class);
    }

    @Override
    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteResponse getById(Long id) {
        PacienteData pacienteData = pacienteRepository.getById(id);
        //TODO colocar excecao de not found aqui
        return modelMapper.map(pacienteData, PacienteResponse.class);
    }

}
