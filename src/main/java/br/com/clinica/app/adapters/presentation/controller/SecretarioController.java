package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.SecretarioRequest;
import br.com.clinica.app.adapters.presentation.response.SecretarioResponse;
import br.com.clinica.app.domain.entities.Secretario;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.SecretarioService;
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
@RequestMapping("/secretarios")
public class SecretarioController {

    private final SecretarioService secretarioService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<SecretarioResponse> create(@RequestBody SecretarioRequest secretarioRequest) {
        log.info("PAYLOAD ENTRADA DE SECRETARIO: {}", secretarioRequest);
        var response = secretarioService.create(modelMapper.map(secretarioRequest, Secretario.class));
        return ResponseEntity.created(URI.create("/clinica/secretarios/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SecretarioResponse>> list(){
        log.info("LISTANDO SECRETARIOS(AS)");
        return ResponseEntity.ok(secretarioService.list());
    }

    @GetMapping("/{secretarioId}")
    public ResponseEntity<SecretarioResponse> findById(@PathVariable Long secretarioId) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(secretarioService.getById(secretarioId));
    }

    @PatchMapping("/{secretarioId}")
    public ResponseEntity<SecretarioResponse> update(@PathVariable Long secretarioId, @PathVariable SecretarioRequest secretarioRequest) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(secretarioService.update(modelMapper.map(secretarioRequest, Secretario.class), secretarioId));
    }

    @DeleteMapping("/{secretarioId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long secretarioId) throws DadoNaoEncontradoException {
        secretarioService.delete(secretarioId);
        return ResponseEntity.ok().build();
    }

}