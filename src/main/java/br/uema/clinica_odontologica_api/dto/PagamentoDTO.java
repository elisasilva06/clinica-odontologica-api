package br.uema.clinica_odontologica_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PagamentoDTO {

    private Integer id;

    private BigDecimal valor;

    private String formaPagamento;

    private LocalDate dataPagamento;

    private String statusPagamento;

    private Integer idConsulta;

    private String nomePaciente;

    private String nomeDentista;
}