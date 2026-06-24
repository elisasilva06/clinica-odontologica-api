package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.dto.PagamentoDTO;
import br.uema.clinica_odontologica_api.entity.Pagamento;
import br.uema.clinica_odontologica_api.exception.ResourceNotFoundException;
import br.uema.clinica_odontologica_api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODOS
    public List<PagamentoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public PagamentoDTO buscarPorId(Integer id) {

        Pagamento pagamento = buscarEntidadePorId(id);

        return converterParaDTO(pagamento);
    }

    // SALVAR
    public Pagamento salvar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    // ATUALIZAR
    public Pagamento atualizar(Integer id, Pagamento dados) {

        Pagamento pagamento = buscarEntidadePorId(id);

        pagamento.setValor(dados.getValor());
        pagamento.setFormaPagamento(dados.getFormaPagamento());
        pagamento.setDataPagamento(dados.getDataPagamento());
        pagamento.setStatusPagamento(dados.getStatusPagamento());
        pagamento.setConsulta(dados.getConsulta());

        return repository.save(pagamento);
    }

    // EXCLUIR
    public void excluir(Integer id) {

        Pagamento pagamento = buscarEntidadePorId(id);

        repository.delete(pagamento);
    }

    // BUSCAR ENTIDADE
    private Pagamento buscarEntidadePorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Pagamento não encontrado com ID: " + id
                        ));
    }

    // CONVERTER PARA DTO
    private PagamentoDTO converterParaDTO(Pagamento pagamento) {

        PagamentoDTO dto = new PagamentoDTO();

        dto.setId(pagamento.getId());
        dto.setValor(pagamento.getValor());
        dto.setFormaPagamento(pagamento.getFormaPagamento());
        dto.setDataPagamento(pagamento.getDataPagamento());
        dto.setStatusPagamento(pagamento.getStatusPagamento());

        dto.setIdConsulta(
                pagamento.getConsulta().getId()
        );

        dto.setNomePaciente(
                pagamento.getConsulta().getPaciente().getNome()
        );

        dto.setNomeDentista(
                pagamento.getConsulta().getDentista().getNome()
        );

        return dto;
    }
}