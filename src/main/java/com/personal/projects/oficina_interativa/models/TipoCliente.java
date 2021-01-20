package com.personal.projects.oficina_interativa.models;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricacao;

    TipoCliente(int cod, String descricacao) {
        this.cod = cod;
        this.descricacao = descricacao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public static TipoCliente toEnum(Integer cod){
        if(cod == null)
            return null;

        for(TipoCliente x: TipoCliente.values()){
            if(cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
