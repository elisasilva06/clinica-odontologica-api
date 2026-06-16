package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.entity.Especialidade;
import br.uema.clinica_odontologica_api.service.EspecialidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService service;

    public EspecialidadeController(EspecialidadeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Especialidade> listarTodas() {
        return service.listarTodas();
    }

    @PostMapping
    public Especialidade salvar(
            @RequestBody Especialidade especialidade) {

        return service.salvar(especialidade);
    }
}