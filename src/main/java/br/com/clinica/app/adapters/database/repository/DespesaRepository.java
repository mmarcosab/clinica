package br.com.clinica.app.adapters.database.repository;

import br.com.clinica.app.adapters.database.entities.DespesaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaData, Long> {

}
