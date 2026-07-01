package br.uema.clinica_odontologica_api.controller;

import br.uema.clinica_odontologica_api.dto.ConsultaDTO;
import br.uema.clinica_odontologica_api.entity.Consulta;
import br.uema.clinica_odontologica_api.service.ConsultaService;
import lombok.Getter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    // LISTAR
    @GetMapping
    public List<ConsultaDTO> listarTodas() {
        return service.listarTodas();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ConsultaDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public Consulta salvar(@Valid @RequestBody Consulta consulta) {
        return service.salvar(consulta);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Integer id,
                          @Valid @RequestBody Consulta consulta) {
        return service.atualizar(id, consulta);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }


    // ENDPOINT DO RELATÓRIO (primeira consulta)
    @GetMapping("/relatorios/historico")
    public ResponseEntity<List<Object[]>> historicoConsultas() {
        return ResponseEntity.ok(
                service.historicoConsultas()
        );
    }

    //ENDPOIT ARRECADAÇÃO POR DENTISTA
    @GetMapping("/relatorios/arrecadacao")
    public ResponseEntity<List<Object[]>> arrecadaoPorDentista(){
        return ResponseEntity.ok(
                service.arrecadacaoPorDentista()
        );
    }

    //ENDPOINT DOS DENTISTAS COM MAIS CONSULTAS
    @GetMapping("/relatorios/racking")
    public ResponseEntity<List<Object[]>> rackingDentista(){
        return ResponseEntity.ok(
                service.rackingDentista()
        );
    }

    //ENDPOINT DE PACIENTES SEM CONSULTAS
    @GetMapping("/relatorios/sem-consultas")
    public  ResponseEntity<List<Object[]>> pacientesSemConsulta(){
        return ResponseEntity.ok(
                service.pacientesSemConsulta()
        );
    }

    //ENDPOINT DO RANKING DOS DENTISTAS POR ESPECIALIDADE
    @GetMapping("/relatorios/top-por-especialidade")
    public ResponseEntity<List<Object[]>> top3DentistasPorEspecialidade(){
        return ResponseEntity.ok(
                service.top3DentistasPorEspecialidade()
        );
    }

    //ENDPOINT EVOLUÇÃO FINANCEIRA DA CLÍNICA
    @GetMapping("/relatorios/evolucao-financeira")
    public ResponseEntity<List<Object[]>> evolucaoFinanceira(){
        return ResponseEntity.ok(
                service.evolucaoFinanceira()
        );
    }

    //ENDPOINT DENTISTAS A CIMA DA MÉDIA
    @GetMapping("/relatorios/dentistas-acima-media")
    public ResponseEntity<List<Object[]>> dentistasAcimaDaMedia(){
        return ResponseEntity.ok(
                service.dentistasAcimaDaMedia()
        );
    }

}