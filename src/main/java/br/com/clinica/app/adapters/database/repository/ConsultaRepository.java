package br.com.clinica.app.adapters.database.repository;

import br.com.clinica.app.adapters.database.entities.ConsultaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaData, Long> {

}
