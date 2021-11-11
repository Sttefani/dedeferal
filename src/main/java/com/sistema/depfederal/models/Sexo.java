package com.sistema.depfederal.models;


public enum Sexo{
    MASCULINO ("Masculino"), FEMININO("Feminino"), OUTROS("outros");

    private final String sexo;

    Sexo(String sexo){
        this.sexo = sexo;
    }

    public String getSexo(){return this.sexo;}

}
