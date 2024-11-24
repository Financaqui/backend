package com.finacaqui.Financaqui.dto;

import com.finacaqui.Financaqui.model.Tipo;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class GastoRequestDTO {

    private String Categoria;
    private Tipo formaPagamento;
    private Float valor;
    private Integer qtdParcelas;
    private Timestamp Data;
}
