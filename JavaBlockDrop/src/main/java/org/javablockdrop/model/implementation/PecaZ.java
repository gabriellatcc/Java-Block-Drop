package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IDuplaVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IDuplaVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, vermelho.
 */
public class PecaZ extends APeca implements IDuplaVariacao {
    public PecaZ() {
        this.c1 = 2;
        this.c2 = 3;
        this.c3 = 11;
        this.c4 = 12;
        this.cor = Cor.VERMELHO;
    }

    @Override
    public void girar(int qnt) {
        if(qnt%2 == 1){//impar
            c1+=2;
            c2+=8;
            c3+=1;
            c4+=7;
        } else{//par
            c1-=2;
            c2-=8;
            c3-=1;
            c4-=7;
        }
    }

    @Override
    public void definirPosicao() {

    }
}