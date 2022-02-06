package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.MedicoRequest;
import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.entities.Medico;
import br.com.clinica.app.domain.service.MedicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public MedicoResponse create(@RequestBody MedicoRequest medicoRequest) {
        log.info("PAYLOAD ENTRADA DE MEDICO(A): {}", medicoRequest);
        return medicoService.create(modelMapper.map(medicoRequest, Medico.class));
    }

    @GetMapping
    public List<MedicoResponse> list(){
        log.info("LISTANDO MEDICOS(AS)");
        return medicoService.list();
    }

    @GetMapping("/{medicoId}")
    public MedicoResponse findById(@PathVariable Long medicoId){
        log.info("PESQUISANDO MEDICO(A) COM ID: {}", medicoId);
        return medicoService.getById(medicoId);
    }

    @PatchMapping("/{medicoId}")
    public MedicoResponse update(@PathVariable Long medicoId, @PathVariable MedicoRequest secretarioRequest){
        log.info("ATUALIZANDO DADOS DE MEDICO(A) COM ID: {}", medicoId);
        return medicoService.update(modelMapper.map(secretarioRequest, Medico.class), medicoId);
    }

    @DeleteMapping("/{medicoId}")
    public void deleteById(@PathVariable Long secretarioId){
        log.info("DELETANDO MEDICO(A) COM ID: {}", secretarioId);
        medicoService.delete(secretarioId);
    }

}