package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IDuplaVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IDuplaVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, verde.
 */
public class PecaS extends APeca implements IDuplaVariacao {

    public PecaS() {
        this.c1 = 3;
        this.c2 = 4;
        this.c3 = 10;
        this.c4 = 11;
        this.cor = Cor.VERDE;
    }

    @Override
    public void girar(int qnt) {
        limparCasasOcupadas();
        int posicaoAtual = definirPosicao();

        if (qnt % 2 == 0) {
            if (posicaoAtual != 1) {
                c1-=0;
                c2-=7;
                c3-=2;
                c4-=9;
            }
        }
        else {
            if (posicaoAtual != 2) {
                c1+=0;
                c2+=7;
                c3+=2;
                c4+=9;
            }
        }
        definirCasasOcupadas();
    }

    @Override
    public int definirPosicao() {
        if(c1-c2 == -1 && c2-c3 == -6 && c3-c4 == -1 && c4-c1 == 8){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -8 && c2-c3 == -1 && c3-c4 == -8 && c4-c1 == 17){
            setPosicao(2);
            return 2;
        } else {
            return 0;
        }
    }
}
