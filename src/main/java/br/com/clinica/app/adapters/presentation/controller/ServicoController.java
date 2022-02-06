package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.ServicoRequest;
import br.com.clinica.app.adapters.presentation.response.ServicoResponse;
import br.com.clinica.app.domain.entities.Servico;
import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import br.com.clinica.app.domain.service.ServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService service;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ServicoResponse create(@RequestBody ServicoRequest servicoRequest) {
        log.info("PAYLOAD ENTRADA DE SERVICO: {}", servicoRequest);
        return service.create(modelMapper.map(servicoRequest, Servico.class));
    }

    @GetMapping
    public List<ServicoResponse> list(){
        log.info("LISTANDO SERVICOS");
        return service.list();
    }

    @GetMapping("/{servicoId}")
    public ServicoResponse findById(@PathVariable Long servicoId) throws DadoNaoEncontradoException {
        return service.getById(servicoId);
    }

    @PatchMapping("/{servicoId}")
    public ServicoResponse update(@PathVariable Long servicoId, @PathVariable ServicoRequest servicoRequest) throws DadoNaoEncontradoException {
        return service.update(modelMapper.map(servicoRequest, Servico.class), servicoId);
    }

    @DeleteMapping("/{servicoId}")
    public void deleteById(@PathVariable Long servicoId) throws DadoNaoEncontradoException {
        service.delete(servicoId);
    }

}