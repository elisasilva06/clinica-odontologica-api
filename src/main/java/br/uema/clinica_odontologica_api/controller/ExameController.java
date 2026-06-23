package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.Exame;
import br.uema.clinica_odontologica_api.service.ExameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exames")
public class ExameController {

    private final ExameService service;

    public ExameController(ExameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Exame> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Exame buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Exame salvar(@RequestBody Exame exame) {
        return service.salvar(exame);
    }

    @PutMapping("/{id}")
    public Exame atualizar(@PathVariable Integer id,
                           @RequestBody Exame exame) {
        return service.atualizar(id, exame);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}