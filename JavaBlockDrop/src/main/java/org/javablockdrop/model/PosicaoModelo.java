package org.javablockdrop.model;

// preenchido : ▓▓
// vazio:░░
public class PosicaoModelo {
    public String composicao= "░░";
    public int linha;
    public int coluna;
    public boolean ocupado=false;

    public PosicaoModelo( int linha , int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public String getComposicao() {return composicao;}
    public void setComposicao(String composicao) {this.composicao = composicao;}

    public boolean isOcupado() {return ocupado;}
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
        if(ocupado)
        {
            setComposicao("▓▓");
        }
    }
}
