package br.uema.clinica_odontologica_api.repository;

import br.uema.clinica_odontologica_api.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository
        extends JpaRepository<Especialidade, Integer> {

}