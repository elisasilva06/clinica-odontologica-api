package br.uema.clinica_odontologica_api.repository;

import br.uema.clinica_odontologica_api.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}