package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.entity.Consulta;
import br.uema.clinica_odontologica_api.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODAS
    public List<Consulta> listarTodas() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Consulta buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada: " + id));
    }

    // SALVAR
    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    // ATUALIZAR
    public Consulta atualizar(Integer id, Consulta dados) {
        Consulta consulta = buscarPorId(id);

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
        Consulta consulta = buscarPorId(id);
        repository.delete(consulta);
    }
}