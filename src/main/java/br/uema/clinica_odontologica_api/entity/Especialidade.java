package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ESPECIALIDADE")
@Data
@NoArgsConstructor
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade")
    private Integer idEspecialidade;

    @Column(name = "nome_especialidade", nullable = false, unique = true)
    private String nomeEspecialidade;
}