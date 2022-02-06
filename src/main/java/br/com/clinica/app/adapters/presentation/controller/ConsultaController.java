package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.ConsultaRequest;
import br.com.clinica.app.adapters.presentation.response.ConsultaResponse;
import br.com.clinica.app.domain.entities.Consulta;
import br.com.clinica.app.domain.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ConsultaResponse create(@RequestBody ConsultaRequest consultaRequest) {
        log.info("PAYLOAD ENTRADA DE CONSULTA: {}", consultaRequest);
        return service.create(modelMapper.map(consultaRequest, Consulta.class));
    }

    @GetMapping
    public List<ConsultaResponse> list(){
        log.info("LISTANDO CONSULTAS");
        return service.list();
    }

    @GetMapping("/{consultaId}")
    public ConsultaResponse findById(@PathVariable Long consultaId){
        return service.getById(consultaId);
    }

    @PatchMapping("/{consultaId}")
    public ConsultaResponse update(@PathVariable Long consultaId, @PathVariable ConsultaRequest consultaRequest){
        return service.update(modelMapper.map(consultaRequest, Consulta.class), consultaId);
    }

    @DeleteMapping("/{consultaId}")
    public void deleteById(@PathVariable Long consultaId){
        service.delete(consultaId);
    }


}