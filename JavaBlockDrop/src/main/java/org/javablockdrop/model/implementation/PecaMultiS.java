package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APecaMulti2Var;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code APecaMulti2Var}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, verde.
 */
public class PecaMultiS extends APecaMulti2Var {

    public PecaMultiS() {
        this.c1 = 3;
        this.c2 = 4;
        this.c3 = 10;
        this.c4 = 11;
        this.cor = Cor.VERDE;
    }

    @Override
    public void girar(int qnt) {
        qnt*=qnt;
        if(qnt%2 == 1){//impar
            c1+=0;
            c2+=7;
            c3+=2;
            c4+=9;
        } else{//par
            c1-=0;
            c2-=7;
            c3-=2;
            c4-=9;
        }
    }

    @Override
    public void definirPosicao() {

    }
}
