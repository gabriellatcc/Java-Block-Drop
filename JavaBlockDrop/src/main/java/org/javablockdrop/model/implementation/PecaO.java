package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos da classe {@code APeca}, como não é rotacionada de maneira diferente,
 * redefine somente os valores das coordenadas da peca e a cor que deve ser e, neste caso, amarelo.
 */
public class PecaO extends APeca {
    public PecaO() {
        this.c1 = 3;
        this.c2 = 4;
        this.c3 = 11;
        this.c4 = 12;
        this.cor = Cor.AMARELO;
    }
}