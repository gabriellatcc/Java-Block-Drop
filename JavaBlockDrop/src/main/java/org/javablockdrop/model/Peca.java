package org.javablockdrop.model;

public class Peca {
    private TabuleiroModelo tabuleiroModelo;

    public Peca() {
        tabuleiroModelo=TabuleiroModelo.getInstancia();
    }
// possivelmente criar uma classe MovimentoModelo que recebe uma geracao modelo e faz os calculos para somar ou subtrair respeitando o tamanho do tabuleiro
    public void criarO(){
        GeracaoModelo gm = new GeracaoModelo(3,4,11,12);
        gm.definirOcupacao();
    }
    public void criarJ(){
        GeracaoModelo gm = new GeracaoModelo(4,12,19,20);
        gm.definirOcupacao();
    }
    public void criarL(){
        GeracaoModelo gm = new GeracaoModelo(3,11,19,20);
        gm.definirOcupacao();
    }
    public void criarT(){
        GeracaoModelo gm = new GeracaoModelo(3,4,5,12);
        gm.definirOcupacao();
    }
    public void criarI(){
        GeracaoModelo gm = new GeracaoModelo(4,12,20,28);
        gm.definirOcupacao();
    }
    public void criarS(){
        GeracaoModelo gm = new GeracaoModelo(4,12,5,11);
        gm.definirOcupacao();
    }
    public void criarZ(){
        GeracaoModelo gm = new GeracaoModelo(4,12,3,13);
        gm.definirOcupacao();
    }
}