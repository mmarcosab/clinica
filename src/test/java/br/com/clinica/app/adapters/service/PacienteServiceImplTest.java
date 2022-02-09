package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.entities.PacienteData;
import br.com.clinica.app.adapters.database.entities.ServicoData;
import br.com.clinica.app.adapters.database.repository.PacienteRepository;
import br.com.clinica.app.domain.entities.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;


public class PacienteServiceImplTest {

    private PacienteServiceImpl service;
    private PacienteRepository repository;

    @BeforeEach
    public void init(){
        repository = mock(PacienteRepository.class);
        service = new PacienteServiceImpl(repository);
    }

    @Test
    public void testList(){
        when(repository.findAll()).thenReturn(List.of(new PacienteData()));
        assertDoesNotThrow(() -> service.list());
    }

    @Test
    public void testFindById(){
        when(repository.findById(any())).thenReturn(Optional.of(new PacienteData()));
        assertDoesNotThrow(() -> service.getById(1l));
    }

    @Test
    public void testCreate(){
        when(repository.save(any())).thenReturn(new PacienteData());
        var paciente = new Paciente();
        assertDoesNotThrow(() -> service.create(paciente));
    }

    @Test
    public void testDelete(){
        when(repository.findById(any())).thenReturn(Optional.of(new PacienteData()));
        assertDoesNotThrow(() -> service.delete(1l));
    }


    @Test
    public void testUpdate(){
        when(repository.findById(any())).thenReturn(Optional.of(new PacienteData()));
        when(repository.save(any())).thenReturn(new ServicoData());
        assertDoesNotThrow(() -> service.getById(1l));
    }

}
