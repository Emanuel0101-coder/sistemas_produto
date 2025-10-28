package com.mercado.komprinha.model;

public enum Categoria {
    LITERATURA("Literatura"),
    ESPORTIVO("Esportivo"),
    COMIDA("Comida"),
    IMOVEL("Imóvel"),
    OBJETO("Objeto"),
    ARTE("Arte");

    private final String nomeFormatado;

    Categoria(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

    @Override
    public String toString() {
        return nomeFormatado;
    }
}


