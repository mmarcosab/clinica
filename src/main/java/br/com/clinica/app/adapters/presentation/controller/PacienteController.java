package br.com.clinica.app.adapters.presentation.controller;


import br.com.clinica.app.adapters.presentation.request.PacienteRequest;
import br.com.clinica.app.adapters.presentation.response.PacienteResponse;
import br.com.clinica.app.domain.entities.Paciente;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<PacienteResponse> create(@RequestBody PacienteRequest pacienteRequest) {
        log.info("PAYLOAD ENTRADA DE PACIENTE: {}", pacienteRequest);
        var response = pacienteService.create(modelMapper.map(pacienteRequest, Paciente.class));
        return ResponseEntity.created(URI.create("/clinica/pacientes/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> list(){
        log.info("LISTANDO PACIENTES");
        return ResponseEntity.ok(pacienteService.list());
    }

    @GetMapping("/{pacienteId}")
    public ResponseEntity<PacienteResponse>  findById(@PathVariable Long pacienteId) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(pacienteService.getById(pacienteId));
    }

    @PatchMapping("/{pacienteId}")
    public ResponseEntity<PacienteResponse>  update(@PathVariable Long pacienteId, @PathVariable PacienteRequest pacienteRequest) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(pacienteService.update(modelMapper.map(pacienteRequest, Paciente.class), pacienteId));
    }

    @DeleteMapping("/{pacienteId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long pacienteId) throws DadoNaoEncontradoException {
        pacienteService.delete(pacienteId);
        return ResponseEntity.ok().build();
    }

}