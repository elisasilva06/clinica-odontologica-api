package br.uema.clinica_odontologica_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private String telefone;
    private String endereco;
    private String email;
}