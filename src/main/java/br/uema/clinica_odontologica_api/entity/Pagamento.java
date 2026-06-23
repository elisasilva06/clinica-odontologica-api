package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Integer id;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "forma_pagamento", nullable = false)
    private String formaPagamento;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "status_pagamento", nullable = false)
    private String statusPagamento;

    @OneToOne
    @JoinColumn(name = "id_consulta", nullable = false, unique = true)
    private Consulta consulta;
}