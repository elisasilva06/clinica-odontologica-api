package br.uema.clinica_odontologica_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DentistaDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String cro;
    private String telefone;
    private String email;
    private BigDecimal salario;

    private String nomeEspecialidade;
}