package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sala_atendimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Integer id;

    @Column(name = "numero_sala", nullable = false, unique = true)
    private String numeroSala;

    @Column(name = "bloco", nullable = false)
    private String bloco;

    @Column(name = "status_sala", nullable = false)
    private String statusSala;
}