package br.com.clinica.app.adapters.presentation.controller;


import br.com.clinica.app.adapters.presentation.mapper.MedicoMapper;
import br.com.clinica.app.adapters.presentation.request.MedicoRequest;
import br.com.clinica.app.adapters.presentation.response.MedicoResponse;
import br.com.clinica.app.domain.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping(value = "/medicos")
    public ResponseEntity<List<MedicoResponse>> getAll(){
        return ResponseEntity.ok(medicoService.list());
    }

    @GetMapping(value = "/medicos/{medicoId}")
    public ResponseEntity<MedicoResponse> findById(@PathVariable Long medicoId) {
        return ResponseEntity.ok(medicoService.getById(medicoId));
    }

    @PostMapping(value = "/medicos")
    public ResponseEntity<MedicoResponse> create(@RequestBody MedicoRequest medicoRequest){
        return ResponseEntity.created(URI.create("/medicos/{medicoId}")).body(medicoService.create(MedicoMapper.map(medicoRequest)));
    }

    @PatchMapping(value = "/medicos/{medicoId}")
    public ResponseEntity<MedicoResponse> update(@RequestBody MedicoRequest medicoRequest, @PathVariable Long medicoId){
        return ResponseEntity.ok().body(medicoService.update(MedicoMapper.from(medicoRequest, medicoId)));
    }

    @DeleteMapping(value = "/medicos/{medicoId}")
    public ResponseEntity delete(@PathVariable Long medicoId) {
        medicoService.delete(medicoId);
        return ResponseEntity.ok().build();
    }

}
