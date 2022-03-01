package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.adapters.presentation.request.LoginDto;
import br.com.clinica.app.adapters.presentation.request.TokenDto;
import br.com.clinica.app.adapters.service.TokenService;
import br.com.clinica.app.domain.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto loginDto) {
        System.out.println(loginDto.toString());

        //TODO gerar token
        try {
            UsernamePasswordAuthenticationToken dadosLogin = loginDto.converter();
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            return ResponseEntity.ok(new TokenDto(tokenService.gerarToken(authentication), "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }



    }

}