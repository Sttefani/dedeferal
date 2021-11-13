package com.sistema.depfederal.models;


public enum Sexo{
    MASCULINO ("Masculino"), FEMININO("Feminino"), OUTROS("outros");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
