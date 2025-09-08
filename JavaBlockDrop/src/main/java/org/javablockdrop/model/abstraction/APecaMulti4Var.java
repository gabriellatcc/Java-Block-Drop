package org.javablockdrop.model.abstraction;

/**
 * Subclasse abstrata para peças com 4 variações de posições no tabuleiro, que herda os métodos e atributos
 * das classes {@code APeca} e {@code APecaMultivariavel}
 */
public abstract class APecaMulti4Var extends APecaMultivariavel{
    public APecaMulti4Var() {
        quantidadeVariacoes = 4;
    }

    /**
     * Método abstrato que será sobrescrito dependendo da qual peça que terá
     * as coordenadas manipuladas nele para girar no sentido horário.
     */
    public abstract void girarHorario(int quantidade);

    /**
     * Método abstrato que será sobrescrito dependendo da qual peça que terá
     * as coordenadas manipuladas nele para girar no sentido anti-horário.
     */
    public abstract void girarAntiHorario(int quantidade);
}