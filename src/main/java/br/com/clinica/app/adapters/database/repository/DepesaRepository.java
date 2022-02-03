package br.com.clinica.app.adapters.database.repository;

import br.com.clinica.app.adapters.database.entities.MedicoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepesaRepository extends JpaRepository<MedicoData, Long> {

}
