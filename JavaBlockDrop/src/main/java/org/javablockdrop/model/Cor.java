package org.javablockdrop.model;

public enum Cor {
    //cores: unicode + color code
    RESETADO("\u001b[0m"),
    NEGRITO("\u001b[1m"),
    PADRAO("\u001b[40m"),
    PONTUADO("\u001b[107m"),
    VERMELHO("\u001b[41m"),
    LARANJA("\u001b[101m"),
    AMARELO("\u001b[43m"),
    VERDE("\u001b[102m"),
    CIANO("\u001b[106m"),
    AZUL("\u001b[44m"),
    ROXO("\u001b[45m");

    private String cor;

    Cor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {return cor;}
}