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
        limparCasas();
        int posicaoAtual = definirPosicao();

        if (qnt % 2 == 0) {
            if (posicaoAtual != 1) {
                c1-=2;
                c2-=8;
                c3-=1;
                c4-=7;
            }
        } else {
            if (posicaoAtual != 2) {
                c1+=2;
                c2+=8;
                c3+=1;
                c4+=7;
            }
        }
        definirCasas();
    }

    @Override
    public int definirPosicao() {
        if(c1-c2 == -1 && c2-c3 == -8 && c3-c4 == -1 && c4-c1 == 10){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -7 && c2-c3 == -1 && c3-c4 == -7 && c4-c1 == 15){
            setPosicao(2);
            return 2;
        } else {
            System.out.println("A peça não está e nenhuma posição conhecida!");
            return 0;
        }
    }
}