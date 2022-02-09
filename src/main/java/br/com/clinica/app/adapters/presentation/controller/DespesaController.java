package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.DespesaRequest;
import br.com.clinica.app.adapters.presentation.response.DespesaResponse;
import br.com.clinica.app.domain.entities.Despesa;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.DespesaService;
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
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService service;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<DespesaResponse> create(@RequestBody DespesaRequest request) {
        log.info("PAYLOAD ENTRADA DE DESPESA: {}", request);
        var response = service.create(modelMapper.map(request, Despesa.class));
        return ResponseEntity.created(URI.create("/clinica/despesas/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DespesaResponse>> list(){
        log.info("LISTANDO DESPESAS");
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{despesaId}")
    public ResponseEntity<DespesaResponse> findById(@PathVariable Long despesaId) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(service.getById(despesaId));
    }

    @PatchMapping("/{despesaId}")
    public ResponseEntity<DespesaResponse> update(@PathVariable Long despesaId, @PathVariable DespesaRequest request) throws DadoNaoEncontradoException {
        return ResponseEntity.ok(service.update(modelMapper.map(request, Despesa.class), despesaId));
    }

    @DeleteMapping("/{despesaId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long despesaId) throws DadoNaoEncontradoException {
        service.delete(despesaId);
        return ResponseEntity.ok().build();
    }

}