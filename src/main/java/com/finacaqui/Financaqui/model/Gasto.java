package com.finacaqui.Financaqui.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity(name = "gasto")
@Table(name = "gasto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Gasto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private Float valor;
    private Integer qtdParcelas;
    private Timestamp data;
    private Tipo formaPagamento;

}
