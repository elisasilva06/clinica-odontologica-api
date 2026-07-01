package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "PACIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(max = 14, message = "O CPF deve ter no máximo 14 caracteres")
    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve ser no passado")
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotBlank(message = "O sexo é obrigatório")
    @Size(max = 1, message = "O sexo deve ter no máximo 1 caractere")
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 150, message = "O endereço deve ter no máximo 150 caracteres")
    @Column(name = "endereco", nullable = false, length = 150)
    private String endereco;

    @Email(message = "O e-mail deve ser válido")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
    @Column(name = "email", unique = true, length = 100)
    private String email;

}