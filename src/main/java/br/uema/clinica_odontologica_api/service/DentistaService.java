package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.dto.DentistaDTO;
import br.uema.clinica_odontologica_api.entity.Dentista;
import br.uema.clinica_odontologica_api.exception.ResourceNotFoundException;
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
    public List<DentistaDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    // BUSCAR POR ID
    public DentistaDTO buscarPorId(Integer id) {

        Dentista dentista = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Dentista não encontrado com ID: " + id));

        return converterParaDTO(dentista);
    }

    // SALVAR
    public Dentista salvar(Dentista dentista) {
        return repository.save(dentista);
    }

    // ATUALIZAR
    public Dentista atualizar(Integer id, Dentista dadosAtualizados) {

        Dentista dentista = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Dentista não encontrado com ID: " + id));

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

        Dentista dentista = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Dentista não encontrado com ID: " + id));

        repository.delete(dentista);
    }

    private DentistaDTO converterParaDTO(Dentista dentista) {

        DentistaDTO dto = new DentistaDTO();

        dto.setId(dentista.getId());
        dto.setNome(dentista.getNome());
        dto.setCpf(dentista.getCpf());
        dto.setCro(dentista.getCro());
        dto.setTelefone(dentista.getTelefone());
        dto.setEmail(dentista.getEmail());
        dto.setSalario(dentista.getSalario());

        dto.setNomeEspecialidade(
                dentista.getEspecialidade().getNomeEspecialidade()
        );

        return dto;
    }
}