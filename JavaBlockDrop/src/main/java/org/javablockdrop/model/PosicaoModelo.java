package org.javablockdrop.model;

public class PosicaoModelo {
    public Cor cor=Cor.PADRAO;
    public String composicao = cor.getDescricao()+"  ";
    public int linha;
    public int coluna;
    public boolean ocupado=false;

    public PosicaoModelo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public String getComposicao() {return composicao;}
    public void setComposicao(String composicao) {this.composicao = composicao;}

    public boolean isOcupado() {return ocupado;}
    public void setOcupado(boolean ocupado, String corPeca) {
        this.ocupado = ocupado;
        if(ocupado)
        {
            setComposicao(corPeca+"  ");
        }
    }

    public Cor getCor() {return cor;}
    public void setCor(Cor cor) {this.cor = cor;}
}