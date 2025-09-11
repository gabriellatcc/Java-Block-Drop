package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IDuplaVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca} e o método d
 * PecaI é uma APeca. (identidade principal e  PecaI sabe fazer o que está definido em IDuplaVariacao
 * (um contrato de habilidade que ela cumpre).
 * que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, ciano.
 */
public class PecaI extends APeca implements IDuplaVariacao {
    public PecaI() {
        this.c1 = 3;
        this.c2 = 11;
        this.c3 = 19;
        this.c4 = 27;
        this.cor = Cor.CIANO;
    }

    /**
     * Método que analisa as coordenadas e diz se a peça esta na posição 1 ou 2 para rotacionar posteiormente.
     */
    @Override
    public void girar(int qnt) {
        qnt*=qnt;
        if(qnt%2 == 1){//impar
            c1+=7;
            c2+=0;
            c3-=7;
            c4-=14;
        } else{//par
            c1-=7;
            c2-=0;
            c3+=7;
            c4+=14;
        }
    }

    /**
     * Método que analisa as coordenadas e diz se a peça esta na posição 1 ou 2 para rotacionar posteiormente.
     */
    @Override
    public void definirPosicao() {

    }
}