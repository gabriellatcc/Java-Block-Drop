package org.javablockdrop.model;

public final class GeracaoModelo {
    private TabuleiroModelo tabuleiroModelo;
    private int p1, p2, p3, p4;
    private String corFundo;

    public GeracaoModelo(int p1, int p2, int p3, int p4, String corFundo) {
        tabuleiroModelo=TabuleiroModelo.getInstancia();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.corFundo = corFundo;
    }

    public void definirOcupacao(){
        tabuleiroModelo.getPosicoesLista().get(p1).setOcupado(true, corFundo);
        tabuleiroModelo.getPosicoesLista().get(p2).setOcupado(true,corFundo);
        tabuleiroModelo.getPosicoesLista().get(p3).setOcupado(true,corFundo);
        tabuleiroModelo.getPosicoesLista().get(p4).setOcupado(true,corFundo);
    }

    public int getP1() {return p1;}
    public void setP1(int p1) {this.p1 = p1;}

    public int getP2() {return p2;}
    public void setP2(int p2) {this.p2 = p2;}

    public int getP3() {return p3;}
    public void setP3(int p3) {this.p3 = p3;}

    public int getP4() {return p4;}
    public void setP4(int p4) {this.p4 = p4;}

    public String getCorFundo() {return corFundo;}
    public void setCorFundo(String corFundo) {this.corFundo = corFundo;}
}