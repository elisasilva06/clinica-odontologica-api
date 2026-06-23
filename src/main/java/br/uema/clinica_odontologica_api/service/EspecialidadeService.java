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

    // Listar todas as especialidades
    public List<Especialidade> listarTodas() {
        return repository.findAll();
    }

    // Buscar especialidade por ID
    public Especialidade buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrada."));
    }

    // Salvar nova especialidade
    public Especialidade salvar(Especialidade especialidade) {
        return repository.save(especialidade);
    }

    // Atualizar especialidade
    public Especialidade atualizar(Integer id, Especialidade especialidade) {
        Especialidade existente = buscarPorId(id);

        existente.setNomeEspecialidade(especialidade.getNomeEspecialidade());

        return repository.save(existente);
    }

    // Excluir especialidade
    public void excluir(Integer id) {
        Especialidade existente = buscarPorId(id);
        repository.delete(existente);
    }
}