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
        limparCasas();
        int posicaoAtual = definirPosicao();

        if (qnt % 2 == 0) {
            if (posicaoAtual != 1) {
                c1 -= 7;
                c3 += 7;
                c4 += 14;
            }
        }
        else {
            if (posicaoAtual != 2) {
                c1 += 7;
                c3 -= 7;
                c4 -= 14;
            }
        }
        definirCasas();
    }

    /**
     * Método que analisa as coordenadas e diz se a peça esta na posição 1 ou 2 para rotacionar posteiormente.
     */
    @Override
    public int definirPosicao() {
        if(c1-c2 == -8 && c2-c3 == -8 && c3-c4 == -8 && c4-c1 == 24){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -1 && c2-c3 == -1 && c3-c4 == -1 && c4-c1 == 3){
            setPosicao(2);
            return 2;
        } else {
            System.out.println("A peça não está e nenhuma posição conhecida!");
            return 0;
        }
    }
}