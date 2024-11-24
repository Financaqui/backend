package com.finacaqui.Financaqui.dto;

import com.finacaqui.Financaqui.model.Gasto;
import com.finacaqui.Financaqui.model.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class GastoResponseDTO {

    private Long id;
    private String categoria;
    private Tipo formaPagamento;
    private Float valor;
    private Integer qtdParcelas;
    private Timestamp data;

    public GastoResponseDTO(Gasto gastoId) {

    }
}