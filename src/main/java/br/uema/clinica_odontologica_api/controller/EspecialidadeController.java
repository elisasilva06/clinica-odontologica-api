package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.Especialidade;
import br.uema.clinica_odontologica_api.service.EspecialidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService service;

    public EspecialidadeController(EspecialidadeService service) {
        this.service = service;
    }

    // GET - Listar todas as especialidades
    @GetMapping
    public List<Especialidade> listarTodas() {
        return service.listarTodas();
    }

    // GET - Buscar especialidade por ID
    @GetMapping("/{id}")
    public Especialidade buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // POST - Cadastrar especialidade
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidade salvar(@RequestBody Especialidade especialidade) {
        return service.salvar(especialidade);
    }

    // PUT - Atualizar especialidade
    @PutMapping("/{id}")
    public Especialidade atualizar(@PathVariable Integer id,
                                   @RequestBody Especialidade especialidade) {
        return service.atualizar(id, especialidade);
    }

    // DELETE - Excluir especialidade
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}