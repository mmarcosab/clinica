package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.SecretarioRequest;
import br.com.clinica.app.adapters.presentation.response.SecretarioResponse;
import br.com.clinica.app.domain.entities.Secretario;
import br.com.clinica.app.domain.service.SecretarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/secretarios")
public class SecretarioController {

    private final SecretarioService secretarioService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public SecretarioResponse create(@RequestBody SecretarioRequest secretarioRequest) {
        log.info("PAYLOAD ENTRADA DE SECRETARIO: {}", secretarioRequest);
        return secretarioService.create(modelMapper.map(secretarioRequest, Secretario.class));
    }

    @GetMapping
    public List<SecretarioResponse> list(){
        log.info("LISTANDO SECRETARIOS(AS)");
        return secretarioService.list();
    }

    @GetMapping("/{secretarioId}")
    public SecretarioResponse findById(@PathVariable Long secretarioId){
        return secretarioService.getById(secretarioId);
    }

    @PatchMapping("/{secretarioId}")
    public SecretarioResponse update(@PathVariable Long secretarioId, @PathVariable SecretarioRequest secretarioRequest){
        return secretarioService.update(modelMapper.map(secretarioRequest, Secretario.class), secretarioId);
    }

    @DeleteMapping("/{secretarioId}")
    public void deleteById(@PathVariable Long secretarioId){
        secretarioService.delete(secretarioId);
    }

}