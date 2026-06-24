package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.dto.ExameDTO;
import br.uema.clinica_odontologica_api.entity.Exame;
import br.uema.clinica_odontologica_api.exception.ResourceNotFoundException;
import br.uema.clinica_odontologica_api.repository.ExameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExameService {

    private final ExameRepository repository;

    public ExameService(ExameRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODOS
    public List<ExameDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public ExameDTO buscarPorId(Integer id) {

        Exame exame = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Exame não encontrado com ID: " + id));

        return converterParaDTO(exame);
    }

    // SALVAR
    public Exame salvar(Exame exame) {
        return repository.save(exame);
    }

    // ATUALIZAR
    public Exame atualizar(Integer id, Exame dados) {

        Exame exame = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Exame não encontrado com ID: " + id));

        exame.setTipoExame(dados.getTipoExame());
        exame.setResultado(dados.getResultado());
        exame.setDataExame(dados.getDataExame());
        exame.setConsulta(dados.getConsulta());

        return repository.save(exame);
    }

    // EXCLUIR
    public void excluir(Integer id) {

        Exame exame = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Exame não encontrado com ID: " + id));

        repository.delete(exame);
    }

    // CONVERTER PARA DTO
    private ExameDTO converterParaDTO(Exame exame) {

        ExameDTO dto = new ExameDTO();

        dto.setId(exame.getId());

        dto.setTipoExame(
                exame.getTipoExame()
        );

        dto.setResultado(
                exame.getResultado()
        );

        dto.setDataExame(
                exame.getDataExame()
        );

        dto.setIdConsulta(
                exame.getConsulta().getId()
        );

        dto.setNomePaciente(
                exame.getConsulta().getPaciente().getNome()
        );

        dto.setNomeDentista(
                exame.getConsulta().getDentista().getNome()
        );

        return dto;
    }
}