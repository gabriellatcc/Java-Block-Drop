package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APecaMulti4Var;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code APecaMulti4Var}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, roxo.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaMultiT extends APecaMulti4Var {
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