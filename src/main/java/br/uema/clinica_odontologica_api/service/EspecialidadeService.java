package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.entity.Especialidade;
import br.uema.clinica_odontologica_api.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }

    public List<Especialidade> listarTodas() {
        return repository.findAll();
    }

    public Especialidade salvar(Especialidade especialidade) {
        return repository.save(especialidade);
    }

}