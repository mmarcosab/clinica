package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.MedicoRequest;
import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Medico;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.MedicoService;
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
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<MedicoResponse> create(@RequestBody MedicoRequest medicoRequest) {
        log.info("PAYLOAD ENTRADA DE MEDICO(A): {}", medicoRequest);
        var response = medicoService.create(modelMapper.map(medicoRequest, Medico.class));
        return ResponseEntity.created(URI.create("/clinica/medicos/" + response.getId())).body(medicoService.create(modelMapper.map(medicoRequest, Medico.class)));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<MedicoResponse>> list(){
        log.info("LISTANDO MEDICOS(AS)");
        return ResponseEntity.ok().body(medicoService.list());
    }

    @GetMapping("/{medicoId}")
    public ResponseEntity<MedicoResponse> findById(@PathVariable Long medicoId) throws DadoNaoEncontradoException {
        log.info("PESQUISANDO MEDICO(A) COM ID: {}", medicoId);
        return ResponseEntity.ok().body(medicoService.getById(medicoId));
    }

    @PatchMapping("/{medicoId}")
    public ResponseEntity<MedicoResponse> update(@PathVariable Long medicoId, @PathVariable MedicoRequest secretarioRequest) throws DadoNaoEncontradoException {
        log.info("ATUALIZANDO DADOS DE MEDICO(A) COM ID: {}", medicoId);
        return ResponseEntity.ok().body(medicoService.update(modelMapper.map(secretarioRequest, Medico.class), medicoId));
    }

    @DeleteMapping("/{medicoId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long secretarioId) throws DadoNaoEncontradoException {
        log.info("DELETANDO MEDICO(A) COM ID: {}", secretarioId);
        medicoService.delete(secretarioId);
        return ResponseEntity.ok().build();
    }

}