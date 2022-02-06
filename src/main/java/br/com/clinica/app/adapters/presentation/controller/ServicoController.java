package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.ServicoRequest;
import br.com.clinica.app.adapters.presentation.response.ServicoResponse;
import br.com.clinica.app.domain.entities.Servico;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.ServicoService;
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
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService service;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<ServicoResponse> create(@RequestBody ServicoRequest servicoRequest) {
        log.info("PAYLOAD ENTRADA DE SERVICO: {}", servicoRequest);
        var response = service.create(modelMapper.map(servicoRequest, Servico.class));
        return ResponseEntity.created(URI.create("/clinica/servicos/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponse>> list(){
        log.info("LISTANDO SERVICOS");
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{servicoId}")
    public ResponseEntity<ServicoResponse> findById(@PathVariable Long servicoId) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(service.getById(servicoId));
    }

    @PatchMapping("/{servicoId}")
    public ResponseEntity<ServicoResponse> update(@PathVariable Long servicoId, @PathVariable ServicoRequest servicoRequest) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(service.update(modelMapper.map(servicoRequest, Servico.class), servicoId));
    }

    @DeleteMapping("/{servicoId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long servicoId) throws DadoNaoEncontradoException {
        service.delete(servicoId);
        return ResponseEntity.ok().build();
    }

}