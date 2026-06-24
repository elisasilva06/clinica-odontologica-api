package br.uema.clinica_odontologica_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExameDTO {

    private Integer id;

    private String tipoExame;

    private String resultado;

    private LocalDate dataExame;

    private Integer idConsulta;

    private String nomePaciente;

    private String nomeDentista;
}