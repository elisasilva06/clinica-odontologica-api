package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.Paciente;
import br.uema.clinica_odontologica_api.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    // GET - Listar todos os pacientes
    @GetMapping
    public List<Paciente> listarTodos() {
        return service.listarTodos();
    }

    // GET - Buscar paciente por ID
    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // POST - Cadastrar paciente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody Paciente paciente) {
        return service.salvar(paciente);
    }

    // PUT - Atualizar paciente
    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Integer id,
                              @RequestBody Paciente paciente) {
        return service.atualizar(id, paciente);
    }

    // DELETE - Excluir paciente
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}