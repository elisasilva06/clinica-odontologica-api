package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.dto.ConsultaDTO;
import br.uema.clinica_odontologica_api.entity.Consulta;
import br.uema.clinica_odontologica_api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import br.uema.clinica_odontologica_api.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODAS
    public List<ConsultaDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    // BUSCAR POR ID
    public ConsultaDTO buscarPorId(Integer id) {

        Consulta consulta = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Consulta não encontrada com ID: " + id));

        return converterParaDTO(consulta);
    }

    // SALVAR
    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    // ATUALIZAR
    public Consulta atualizar(Integer id, Consulta dados) {

        Consulta consulta = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Consulta não encontrada com ID: " + id));

        consulta.setDataConsulta(dados.getDataConsulta());
        consulta.setHoraConsulta(dados.getHoraConsulta());
        consulta.setStatusConsulta(dados.getStatusConsulta());
        consulta.setObservacoes(dados.getObservacoes());
        consulta.setPaciente(dados.getPaciente());
        consulta.setDentista(dados.getDentista());
        consulta.setSala(dados.getSala());

        return repository.save(consulta);
    }

    // EXCLUIR
    public void excluir(Integer id) {

        Consulta consulta = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Consulta não encontrada com ID: " + id));

        repository.delete(consulta);
    }

    private ConsultaDTO converterParaDTO(Consulta consulta) {

        ConsultaDTO dto = new ConsultaDTO();

        dto.setId(consulta.getId());
        dto.setDataConsulta(consulta.getDataConsulta());
        dto.setHoraConsulta(consulta.getHoraConsulta());
        dto.setStatusConsulta(consulta.getStatusConsulta());
        dto.setObservacoes(consulta.getObservacoes());

        dto.setNomePaciente(
                consulta.getPaciente().getNome()
        );

        dto.setNomeDentista(
                consulta.getDentista().getNome()
        );

        dto.setNumeroSala(
                consulta.getSala().getNumeroSala()
        );

        return dto;
    }

    //primeira consulta (nível básico)
    public List<Object[]> historicoConsultas() {
        return repository.historicoConsultas();
    }

    //segunda consulta
    public List<Object[]> arrecadacaoPorDentista(){
        return repository.arrecadacaoPorDentista();
    }

    //primeira consulta (nível intermediário)
    public List<Object[]> rackingDentista(){
        return repository.rankingDentistas();
    }

    public List<Object[]> pacientesSemConsulta(){
        return repository.pacientesSemConsulta();
    }

    //primeira consulta (nível avançado)
    public List<Object[]> top3DentistasPorEspecialidade(){
        return repository.top3DentistasPorEspecialidade();
    }

    public List<Object[]> evolucaoFinanceira(){
        return repository.evolucaoFinanceira();
    }

    public List<Object[]> dentistasAcimaDaMedia(){
        return repository.dentistasAcimaDaMedia();
    }

}