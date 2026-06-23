package br.uema.clinica_odontologica_api.service;

import br.uema.clinica_odontologica_api.entity.Pagamento;
import br.uema.clinica_odontologica_api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }

    public Pagamento buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado: " + id));
    }

    public Pagamento salvar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public Pagamento atualizar(Integer id, Pagamento dados) {
        Pagamento pagamento = buscarPorId(id);

        pagamento.setValor(dados.getValor());
        pagamento.setFormaPagamento(dados.getFormaPagamento());
        pagamento.setDataPagamento(dados.getDataPagamento());
        pagamento.setStatusPagamento(dados.getStatusPagamento());
        pagamento.setConsulta(dados.getConsulta());

        return repository.save(pagamento);
    }

    public void excluir(Integer id) {
        Pagamento pagamento = buscarPorId(id);
        repository.delete(pagamento);
    }
}