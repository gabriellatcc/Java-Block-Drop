package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APecaMulti2Var;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code APecaMulti2Var}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, ciano.
 */
public class PecaMultiI extends APecaMulti2Var {
    public PecaMultiI() {
        this.c1 = 3;
        this.c2 = 11;
        this.c3 = 19;
        this.c4 = 27;
        this.cor = Cor.CIANO;
    }

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

    @Override
    public void definirPosicao() {

    }
}