package org.javablockdrop.model;

public class Peca {
    private TabuleiroModelo tabuleiroModelo;

    public Peca() {
        tabuleiroModelo=TabuleiroModelo.getInstancia();
    }

    public void criarO(){
        //teste
        //criar classe que entre as4 posicoes de geracao daaaaaaaaaaaaaaa
        GeracaoModelo gm = new GeracaoModelo(3,4,11,12);

        tabuleiroModelo.getPosicoesLista().get(3).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(4).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(11).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(12).setOcupado(true);

        //posicao de geracao O:
        // [ a03, a04]
        // [ a13, a14]
    }
    public void criarJ(){
        tabuleiroModelo.getPosicoesLista().get(4).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(12).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(19).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(20).setOcupado(true);
        //posicao de geracao J:
        // [ false, a04]
        // [ false, a14]
        // [ a23, a24]
    }
    public void criarL(){
        tabuleiroModelo.getPosicoesLista().get(3).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(11).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(19).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(20).setOcupado(true);
        //posicao de geracao L:
        // [ a03, nada]
        // [ a13, nada]
        // [ a23, a24]
    }
    public void criarT(){
        tabuleiroModelo.getPosicoesLista().get(3).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(4).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(5).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(12).setOcupado(true);
        //posicao de geracao T:
        // [ a03, a04, a05]
        // [ false, a14, false]
    }
    public void criarI(){
        tabuleiroModelo.getPosicoesLista().get(4).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(12).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(20).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(28).setOcupado(true);
        //posicao de geracao I:
        // [ a04 ]
        // [ a14 ]
        // [ a24 ]
        // [ a34 ]
    }
    public void criarS(){
        tabuleiroModelo.getPosicoesLista().get(4).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(12).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(5).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(11).setOcupado(true);
        //posicao de geracao S:
        // [ false, a04, a05]
        // [ a13, a14, false]
    }
    public void criarZ(){
        tabuleiroModelo.getPosicoesLista().get(4).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(12).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(3).setOcupado(true);
        tabuleiroModelo.getPosicoesLista().get(13).setOcupado(true);
        //posicao de geracao Z:
        // [ a03, a04, false]
        // [ false, a14, a15]
    }
}