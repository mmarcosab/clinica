package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.ServicoData;
import br.com.clinica.app.adapters.database.repository.ServicoRepository;
import br.com.clinica.app.domain.entities.Servico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class ServicoServiceImplTest {

    private ServicoServiceImpl service;
    private ServicoRepository repository;

    @BeforeEach
    public void init(){
        repository = mock(ServicoRepository.class);
        service = new ServicoServiceImpl(repository);
    }

    @Test
    public void testList(){
        when(repository.findAll()).thenReturn(List.of(new ServicoData()));
        assertDoesNotThrow(() -> service.list());
    }

    @Test
    public void testFindById(){
        when(repository.findById(any())).thenReturn(Optional.of(new ServicoData()));
        assertDoesNotThrow(() -> service.getById(1l));
    }

    @Test
    public void testCreate(){
        when(repository.save(any())).thenReturn(new ServicoData());
        var servico = new Servico();
        servico.setValor(BigDecimal.TEN);
        servico.setDescricao("exame XPTO");
        assertDoesNotThrow(() -> service.create(servico));
    }

    @Test
    public void testDelete(){
        when(repository.findById(any())).thenReturn(Optional.of(new ServicoData()));
        assertDoesNotThrow(() -> service.delete(1l));
    }


    @Test
    public void testUpdate(){
        when(repository.findById(any())).thenReturn(Optional.of(new ServicoData()));
        when(repository.save(any())).thenReturn(new ServicoData());
        assertDoesNotThrow(() -> service.getById(1l));
    }

}
