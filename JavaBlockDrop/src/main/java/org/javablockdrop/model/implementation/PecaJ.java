package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IPoliVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IPoliVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, laranja
 * ou vermelho claro.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaJ extends APeca implements IPoliVariacao {
    public PecaJ() {
        this.c1 = 4;
        this.c2 = 12;
        this.c3 = 19;
        this.c4 = 20;
        this.cor = Cor.LARANJA;
    }

    @Override
    public void girarHorario(int quantidade) {

    }

    @Override
    public void girarAntiHorario(int quantidade) {

    }

    @Override
    public int definirPosicao() {
        if(c1-c2 == -8 && c2-c3 == -7 && c3-c4 == -1 && c4-c1 == 16){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -8 && c2-c3 == -1 && c3-c4 == -1 && c4-c1 == 10){
            setPosicao(2);
            return 2;
        } else if (c1-c2 == -1 && c2-c3 == -7 && c3-c4 == -8 && c4-c1 == 16) {
            setPosicao(3);
            return 3;
        } else if (c1-c2 == -1 && c2-c3 == -1 && c3-c4 == -8 && c4-c1 == 10) {
            setPosicao(4);
            return 4;
        } else {
            System.out.println("A peça não está e nenhuma posição conhecida!");
            return 0;
        }
    }
}
