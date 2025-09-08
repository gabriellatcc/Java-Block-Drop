package org.javablockdrop.model.abstraction;

/**
 * Subclasse abstrata para peças com 2 variações de posições no tabuleiro, que herda os métodos e atributos
 * das classes {@code APeca} e {@code APecaMultivariavel}.
 */
public abstract class APecaMulti2Var extends APecaMultivariavel{
    public APecaMulti2Var() {
        quantidadeVariacoes = 2;
    }

    /**
     * Método abstrato que será sobrescrito dependendo da qual peça que terá
     * as coordenadas manipuladas nele.
     */
    public abstract void girar(int qnt);
}
