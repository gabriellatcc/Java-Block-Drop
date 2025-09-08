package org.javablockdrop.model;

import org.javablockdrop.model.enumeration.Cor;

/**
 * Classe responsável por gerenciar cada casa do tabuleiro, que contém uma cor padrão, a informação se está ocupada ou
 * não e sua posição na linha.
 */
public class CasaModelo {
    private String cor = Cor.PADRAO.getDescricao();
    private boolean ocupado = false;
    private int linha;

    public CasaModelo() {}

    /**
     * Métodos de encapsulamento getters e setters
     */
    public String getComposicao() {
        return this.cor + "  ";
    }
    public boolean isOcupado() {return ocupado;}
    public void setOcupado(boolean ocupado) {this.ocupado = ocupado;}
    public String getCor() {return cor;}
    public void setCor(String cor) {this.cor = cor;}
    public void setLinha(int i) {this.linha = linha;}
}