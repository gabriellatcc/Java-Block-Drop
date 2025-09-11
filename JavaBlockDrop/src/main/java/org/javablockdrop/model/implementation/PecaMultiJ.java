package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.abstraction.IPoliVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IPoliVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, laranja
 * ou vermelho claro.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaMultiJ extends APeca implements IPoliVariacao {
    public PecaMultiJ() {
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
    public void definirPosicao() {

    }
}
