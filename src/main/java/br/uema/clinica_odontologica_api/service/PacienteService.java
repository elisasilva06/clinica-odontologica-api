package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.dto.PacienteDTO;
import br.uema.clinica_odontologica_api.entity.Paciente;
import br.uema.clinica_odontologica_api.exception.ResourceNotFoundException;
import br.uema.clinica_odontologica_api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODOS
    public List<PacienteDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    // BUSCAR POR ID
    public PacienteDTO buscarPorId(Integer id) {

        Paciente paciente = buscarEntidadePorId(id);

        return converterParaDTO(paciente);
    }

    // SALVAR
    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    // ATUALIZAR
    public Paciente atualizar(Integer id, Paciente paciente) {

        Paciente existente = buscarEntidadePorId(id);

        existente.setNome(paciente.getNome());
        existente.setCpf(paciente.getCpf());
        existente.setDataNascimento(paciente.getDataNascimento());
        existente.setSexo(paciente.getSexo());
        existente.setTelefone(paciente.getTelefone());
        existente.setEndereco(paciente.getEndereco());
        existente.setEmail(paciente.getEmail());

        return repository.save(existente);
    }

    // EXCLUIR
    public void excluir(Integer id) {

        Paciente paciente = buscarEntidadePorId(id);

        repository.delete(paciente);
    }

    // BUSCAR ENTIDADE
    private Paciente buscarEntidadePorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Paciente não encontrado com ID: " + id
                        ));
    }

    // CONVERTER PARA DTO
    private PacienteDTO converterParaDTO(Paciente paciente) {

        PacienteDTO dto = new PacienteDTO();

        dto.setId(paciente.getId());
        dto.setNome(paciente.getNome());
        dto.setCpf(paciente.getCpf());
        dto.setDataNascimento(paciente.getDataNascimento());
        dto.setSexo(paciente.getSexo());
        dto.setTelefone(paciente.getTelefone());
        dto.setEndereco(paciente.getEndereco());
        dto.setEmail(paciente.getEmail());

        return dto;
    }
}