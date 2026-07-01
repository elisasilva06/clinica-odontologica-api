package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "dentista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentista")
    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @NotBlank(message = "O CRO é obrigatório")
    @Column(name = "cro", nullable = false, unique = true)
    private String cro;

    @NotBlank(message = "O telefone é obrigatório")
    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Email(message = "O e-mail deve ser válido")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "O salário é obrigatório")
    @PositiveOrZero(message = "O salário não pode ser negativo")
    @Column(name = "salario", nullable = false)
    private BigDecimal salario;

    @NotNull(message = "A especialidade é obrigatória")
    @ManyToOne
    @JoinColumn(name = "id_especialidade", nullable = false)
    private Especialidade especialidade;
}