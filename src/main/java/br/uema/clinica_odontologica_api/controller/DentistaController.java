package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.dto.DentistaDTO;
import br.uema.clinica_odontologica_api.entity.Dentista;
import br.uema.clinica_odontologica_api.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private final DentistaService service;

    public DentistaController(DentistaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DentistaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public DentistaDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Dentista salvar(@Valid @RequestBody Dentista dentista) {
        return service.salvar(dentista);
    }

    @PutMapping("/{id}")
    public Dentista atualizar(@PathVariable Integer id,
                              @Valid @RequestBody Dentista dentista) {
        return service.atualizar(id, dentista);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}