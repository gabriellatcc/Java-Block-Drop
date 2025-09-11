package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.abstraction.IPoliVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IPoliVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, roxo.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaMultiT extends APeca implements IPoliVariacao {
    public PecaMultiT() {
        this.c1 = 2;
        this.c2 = 3;
        this.c3 = 4;
        this.c4 = 11;
        this.cor = Cor.ROXO;
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