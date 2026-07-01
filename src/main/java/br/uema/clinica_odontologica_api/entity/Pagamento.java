package br.uema.clinica_odontologica_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @NotBlank(message = "A forma de pagamento é obrigatória")
    @Column(name = "forma_pagamento", nullable = false)
    private String formaPagamento;

    @NotNull(message = "A data do pagamento é obrigatória")
    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @NotBlank(message = "O status do pagamento é obrigatório")
    @Column(name = "status_pagamento", nullable = false)
    private String statusPagamento;

    @NotNull(message = "A consulta é obrigatória")
    @OneToOne
    @JoinColumn(name = "id_consulta", nullable = false, unique = true)
    private Consulta consulta;
}