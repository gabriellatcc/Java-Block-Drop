package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IPoliVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IPoliVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, azul.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaL extends APeca implements IPoliVariacao {

    public PecaL() {
        this.c1 = 3;
        this.c2 = 11;
        this.c3 = 19;
        this.c4 = 20;
        this.cor = Cor.AZUL;
    }

    @Override
    public void girarHorario(int quantidade) {

    }

    @Override
    public void girarAntiHorario(int quantidade) {

    }

    @Override
    public int definirPosicao() {
        if(c1-c2 == -8 && c2-c3 == -8 && c3-c4 == -1 && c4-c1 == 17){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -1 && c2-c3 == -1 && c3-c4 == -6 && c4-c1 == 8){
            setPosicao(2);
            return 2;
        } else if (c1-c2 == -1 && c2-c3 == -8 && c3-c4 == -8 && c4-c1 == 17) {
            setPosicao(3);
            return 3;
        } else if (c1-c2 == -6 && c2-c3 == -1 && c3-c4 == -1 && c4-c1 == 8) {
            setPosicao(4);
            return 4;
        } else {
            System.out.println("a peça não está e nenhuma posição conhecida!");
            return 0;
        }
    }
}
