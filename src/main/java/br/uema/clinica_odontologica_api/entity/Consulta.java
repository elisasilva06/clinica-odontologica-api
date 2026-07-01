package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer id;

    @NotNull(message = "A data da consulta é obrigatória")
    @Column(name = "data_consulta", nullable = false)
    private LocalDate dataConsulta;

    @NotNull(message = "A hora da consulta é obrigatória")
    @Column(name = "hora_consulta", nullable = false)
    private LocalTime horaConsulta;

    @NotBlank(message = "O status da consulta é obrigatório")
    @Column(name = "status_consulta", nullable = false)
    private String statusConsulta;

    @Column(name = "observacoes")
    private String observacoes;

    @NotNull(message = "O paciente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @NotNull(message = "O dentista é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_dentista", nullable = false)
    private Dentista dentista;

    @NotNull(message = "A sala é obrigatória")
    @ManyToOne
    @JoinColumn(name = "id_sala", nullable = false)
    private SalaAtendimento sala;
}