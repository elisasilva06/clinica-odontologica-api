package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.entity.Exame;
import br.uema.clinica_odontologica_api.repository.ExameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    private final ExameRepository repository;

    public ExameService(ExameRepository repository) {
        this.repository = repository;
    }

    public List<Exame> listarTodos() {
        return repository.findAll();
    }

    public Exame buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado: " + id));
    }

    public Exame salvar(Exame exame) {
        return repository.save(exame);
    }

    public Exame atualizar(Integer id, Exame dados) {
        Exame exame = buscarPorId(id);

        exame.setTipoExame(dados.getTipoExame());
        exame.setResultado(dados.getResultado());
        exame.setDataExame(dados.getDataExame());
        exame.setConsulta(dados.getConsulta());

        return repository.save(exame);
    }

    public void excluir(Integer id) {
        Exame exame = buscarPorId(id);
        repository.delete(exame);
    }
}
