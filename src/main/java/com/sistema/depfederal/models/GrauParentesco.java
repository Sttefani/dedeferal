package com.sistema.depfederal.models;

public enum GrauParentesco {

    CONJUGE("conjuge"),
    FILHO("filho(a)"),
    IRMAO("irmão(ã)"),
    OUTRO("outro");

    private final String grauParentesco;


   GrauParentesco(String grauParentesco){
        this.grauParentesco = grauParentesco;
    }

    public String getGrauParentescoo(){return this.grauParentesco;}

}
