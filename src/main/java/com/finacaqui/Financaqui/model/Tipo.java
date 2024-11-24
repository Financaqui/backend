package com.finacaqui.Financaqui.model;

public enum Tipo {

    CREDITO("C"),
    DEBITO("D"),
    FISICO("F");

    private String codigo;

    Tipo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
