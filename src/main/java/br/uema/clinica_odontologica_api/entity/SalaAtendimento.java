package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "O número da sala é obrigatório")
    @Column(name = "numero_sala", nullable = false, unique = true)
    private String numeroSala;

    @NotBlank(message = "O bloco é obrigatório")
    @Column(name = "bloco", nullable = false)
    private String bloco;

    @NotBlank(message = "O status da sala é obrigatório")
    @Column(name = "status_sala", nullable = false)
    private String statusSala;
}