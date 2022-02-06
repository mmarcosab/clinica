package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.ConsultaRequest;
import br.com.clinica.app.adapters.presentation.response.ConsultaResponse;
import br.com.clinica.app.domain.entities.Consulta;
import br.com.clinica.app.domain.service.ConsultaService;
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
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaRequest consultaRequest) {
        log.info("PAYLOAD ENTRADA DE CONSULTA: {}", consultaRequest);
        var response = service.create(modelMapper.map(consultaRequest, Consulta.class));
        return ResponseEntity.created(URI.create("/clinica/consultas/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> list(){
        log.info("LISTANDO CONSULTAS");
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{consultaId}")
    public ResponseEntity<ConsultaResponse> findById(@PathVariable Long consultaId){
        return ResponseEntity.ok(service.getById(consultaId));
    }

    @PatchMapping("/{consultaId}")
    public ResponseEntity<ConsultaResponse> update(@PathVariable Long consultaId, @PathVariable ConsultaRequest consultaRequest){
        return ResponseEntity.ok(service.update(modelMapper.map(consultaRequest, Consulta.class), consultaId));
    }

    @DeleteMapping("/{consultaId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long consultaId){
        service.delete(consultaId);
        return ResponseEntity.ok().build();
    }


}