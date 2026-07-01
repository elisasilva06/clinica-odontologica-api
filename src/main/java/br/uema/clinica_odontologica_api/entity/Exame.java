package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "exame")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exame")
    private Integer id;

    @NotBlank(message = "O tipo de exame é obrigatório")
    @Column(name = "tipo_exame", nullable = false)
    private String tipoExame;

    @Column(name = "resultado")
    private String resultado;

    @NotNull(message = "A data do exame é obrigatória")
    @Column(name = "data_exame", nullable = false)
    private LocalDate dataExame;

    @NotNull(message = "A consulta é obrigatória")
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;
}