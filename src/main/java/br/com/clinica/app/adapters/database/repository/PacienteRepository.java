package br.com.clinica.app.adapters.database.repository;

import br.com.clinica.app.adapters.database.entities.PacienteData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteData, Long> {

}
