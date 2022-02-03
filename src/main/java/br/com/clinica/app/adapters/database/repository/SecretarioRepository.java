package br.com.clinica.app.adapters.database.repository;

import br.com.clinica.app.adapters.database.entities.SecretarioData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretarioRepository extends JpaRepository<SecretarioData, Long> {

}
