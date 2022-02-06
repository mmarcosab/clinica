package br.com.clinica.app.adapters.presentation.controller;

import br.com.clinica.app.domain.exception.DadoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ErrorHandlerController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(DadoNaoEncontradoException.class)
    public ResponseEntity<Void> handleException(){
        return ResponseEntity.notFound().build();
    }

}
