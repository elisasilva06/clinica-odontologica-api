package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.SalaAtendimento;
import br.uema.clinica_odontologica_api.service.SalaAtendimentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaAtendimentoController {

    private final SalaAtendimentoService service;

    public SalaAtendimentoController(SalaAtendimentoService service) {
        this.service = service;
    }

    // LISTAR
    @GetMapping
    public List<SalaAtendimento> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public SalaAtendimento buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public SalaAtendimento salvar(@RequestBody SalaAtendimento sala) {
        return service.salvar(sala);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public SalaAtendimento atualizar(@PathVariable Integer id,
                                     @RequestBody SalaAtendimento sala) {
        return service.atualizar(id, sala);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}