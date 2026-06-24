package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.dto.DentistaDTO;
import br.uema.clinica_odontologica_api.entity.Dentista;
import br.uema.clinica_odontologica_api.service.DentistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private final DentistaService service;

    public DentistaController(DentistaService service) {
        this.service = service;
    }

    // LISTAR TODOS
    @GetMapping
    public List<DentistaDTO> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public DentistaDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public Dentista salvar(@RequestBody Dentista dentista) {
        return service.salvar(dentista);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Dentista atualizar(@PathVariable Integer id,
                              @RequestBody Dentista dentista) {
        return service.atualizar(id, dentista);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}