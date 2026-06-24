package br.uema.clinica_odontologica_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ConsultaDTO {

    private Integer id;

    private LocalDate dataConsulta;

    private LocalTime horaConsulta;

    private String statusConsulta;

    private String observacoes;

    private String nomePaciente;

    private String nomeDentista;

    private String numeroSala;
}