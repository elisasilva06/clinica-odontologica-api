package br.uema.clinica_odontologica_api.repository;

import br.uema.clinica_odontologica_api.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}