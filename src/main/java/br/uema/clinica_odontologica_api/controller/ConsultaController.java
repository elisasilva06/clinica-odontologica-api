package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.Consulta;
import br.uema.clinica_odontologica_api.service.ConsultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    // LISTAR
    @GetMapping
    public List<Consulta> listarTodas() {
        return service.listarTodas();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Consulta buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public Consulta salvar(@RequestBody Consulta consulta) {
        return service.salvar(consulta);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Integer id,
                              @RequestBody Consulta consulta) {
        return service.atualizar(id, consulta);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}