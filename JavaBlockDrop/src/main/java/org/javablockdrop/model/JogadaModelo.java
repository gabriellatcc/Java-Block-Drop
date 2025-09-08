package org.javablockdrop.model;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.abstraction.APecaMulti2Var;
import org.javablockdrop.model.abstraction.APecaMulti4Var;

/**
 * Nesta classe as jogadas manipulam a peça ativa no tabuleiro, cada jogada é composta por
 * um movimento e a quantidade de vezes em que acontece.
 */
public class JogadaModelo {
    private PartidaModelo partidaModelo=PartidaModelo.getInstancia();;

    private char movimento;
    private int quantidade;

    public JogadaModelo(char movimento, int quantidade) {
        this.movimento = movimento;
        this.quantidade = quantidade;
    }

    /**
     * Este método recebe a peça ativa do tabuleiro e dependendo da jogada ativa o método, verifica se a peça pertence
     * a uma instancia de classe multivalorada e utiliza a rotação especifica da peça.
     */
    public void executar(){
        APeca pecaAtiva = partidaModelo.getTabuleiroModelo().getPecaAtiva();

        if(movimento == 'd'){
            pecaAtiva.movimentarD(quantidade);
            pecaAtiva.descer();
        } else if(movimento == 'e'){

            pecaAtiva.movimentarE(quantidade);
            pecaAtiva.descer();
        } else if(movimento == 'a'){
            if (pecaAtiva instanceof APecaMulti4Var) {
                ((APecaMulti4Var) pecaAtiva).girarAntiHorario(quantidade);
                pecaAtiva.descer();
            } else if (pecaAtiva instanceof APecaMulti2Var) {
                ((APecaMulti2Var) pecaAtiva).girar(quantidade);
                pecaAtiva.descer();
            }
        } else if(movimento == 'h'){
            if (pecaAtiva instanceof APecaMulti4Var) {
                ((APecaMulti4Var) pecaAtiva).girarHorario(quantidade);
                pecaAtiva.descer();
            } else if (pecaAtiva instanceof APecaMulti2Var) {
                ((APecaMulti2Var) pecaAtiva).girar(quantidade);
                pecaAtiva.descer();
            }
        } else{
            System.out.println("erro ao manipular a peca pela jogada");
        }
    }

    /**
     * Métodos de encapsulamento getters e setters.
     */
    public char getMovimento() {return movimento;}
    public int getQuantidade() {return quantidade;}
}