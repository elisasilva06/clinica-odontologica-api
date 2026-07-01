package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.SalaAtendimento;
import br.uema.clinica_odontologica_api.service.SalaAtendimentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaAtendimentoController {

    private final SalaAtendimentoService service;

    public SalaAtendimentoController(SalaAtendimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<SalaAtendimento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public SalaAtendimento buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public SalaAtendimento salvar(@Valid @RequestBody SalaAtendimento sala) {
        return service.salvar(sala);
    }

    @PutMapping("/{id}")
    public SalaAtendimento atualizar(@PathVariable Integer id,
                                     @Valid @RequestBody SalaAtendimento sala) {
        return service.atualizar(id, sala);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}