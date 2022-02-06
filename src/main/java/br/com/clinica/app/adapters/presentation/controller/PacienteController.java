package br.com.clinica.app.adapters.presentation.controller;


import br.com.clinica.app.adapters.presentation.request.PacienteRequest;
import br.com.clinica.app.adapters.presentation.response.PacienteResponse;
import br.com.clinica.app.domain.entities.Paciente;
import br.com.clinica.app.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public PacienteResponse create(@RequestBody PacienteRequest pacienteRequest) {
        log.info("PAYLOAD ENTRADA DE PACIENTE: {}", pacienteRequest);
        return pacienteService.create(modelMapper.map(pacienteRequest, Paciente.class));
    }

    @GetMapping
    public List<PacienteResponse> list(){
        log.info("LISTANDO PACIENTES");
        return pacienteService.list();
    }

    @GetMapping("/{pacienteId}")
    public PacienteResponse findById(@PathVariable Long pacienteId){
        return pacienteService.getById(pacienteId);
    }

    @PatchMapping("/{pacienteId}")
    public PacienteResponse update(@PathVariable Long pacienteId, @PathVariable PacienteRequest pacienteRequest){
        return pacienteService.update(modelMapper.map(pacienteRequest, Paciente.class), pacienteId);
    }

    @DeleteMapping("/{pacienteId}")
    public void deleteById(@PathVariable Long pacienteId){
        pacienteService.delete(pacienteId);
    }

}