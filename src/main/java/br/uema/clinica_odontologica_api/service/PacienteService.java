package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.entity.Paciente;
import br.uema.clinica_odontologica_api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    // Listar todos os pacientes
    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    // Buscar paciente por ID
    public Paciente buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado."));
    }

    // Salvar paciente
    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    // Atualizar paciente
    public Paciente atualizar(Integer id, Paciente paciente) {

        Paciente existente = buscarPorId(id);

        existente.setNome(paciente.getNome());
        existente.setCpf(paciente.getCpf());
        existente.setDataNascimento(paciente.getDataNascimento());
        existente.setSexo(paciente.getSexo());
        existente.setTelefone(paciente.getTelefone());
        existente.setEndereco(paciente.getEndereco());
        existente.setEmail(paciente.getEmail());

        return repository.save(existente);
    }

    // Excluir paciente
    public void excluir(Integer id) {
        Paciente paciente = buscarPorId(id);
        repository.delete(paciente);
    }
}