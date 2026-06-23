package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.entity.Dentista;
import br.uema.clinica_odontologica_api.repository.DentistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    private final DentistaRepository repository;

    public DentistaService(DentistaRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODOS
    public List<Dentista> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Dentista buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado com ID: " + id));
    }

    // SALVAR
    public Dentista salvar(Dentista dentista) {
        return repository.save(dentista);
    }

    // ATUALIZAR
    public Dentista atualizar(Integer id, Dentista dadosAtualizados) {
        Dentista dentista = buscarPorId(id);

        dentista.setNome(dadosAtualizados.getNome());
        dentista.setCpf(dadosAtualizados.getCpf());
        dentista.setCro(dadosAtualizados.getCro());
        dentista.setTelefone(dadosAtualizados.getTelefone());
        dentista.setEmail(dadosAtualizados.getEmail());
        dentista.setSalario(dadosAtualizados.getSalario());
        dentista.setEspecialidade(dadosAtualizados.getEspecialidade());

        return repository.save(dentista);
    }

    // DELETAR
    public void excluir(Integer id) {
        Dentista dentista = buscarPorId(id);
        repository.delete(dentista);
    }
}