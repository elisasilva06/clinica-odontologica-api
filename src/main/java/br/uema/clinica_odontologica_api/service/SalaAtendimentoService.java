package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.entity.SalaAtendimento;
import br.uema.clinica_odontologica_api.repository.SalaAtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaAtendimentoService {

    private final SalaAtendimentoRepository repository;

    public SalaAtendimentoService(SalaAtendimentoRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODOS
    public List<SalaAtendimento> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public SalaAtendimento buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com ID: " + id));
    }

    // SALVAR
    public SalaAtendimento salvar(SalaAtendimento sala) {
        return repository.save(sala);
    }

    // ATUALIZAR
    public SalaAtendimento atualizar(Integer id, SalaAtendimento dados) {
        SalaAtendimento sala = buscarPorId(id);

        sala.setNumeroSala(dados.getNumeroSala());
        sala.setBloco(dados.getBloco());
        sala.setStatusSala(dados.getStatusSala());

        return repository.save(sala);
    }

    // EXCLUIR
    public void excluir(Integer id) {
        SalaAtendimento sala = buscarPorId(id);
        repository.delete(sala);
    }
}