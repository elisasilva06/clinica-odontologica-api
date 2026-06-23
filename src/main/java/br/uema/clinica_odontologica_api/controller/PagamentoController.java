package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.Pagamento;
import br.uema.clinica_odontologica_api.service.PagamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pagamento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Pagamento salvar(@RequestBody Pagamento pagamento) {
        return service.salvar(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento atualizar(@PathVariable Integer id,
                               @RequestBody Pagamento pagamento) {
        return service.atualizar(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}