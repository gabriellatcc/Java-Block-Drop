package org.javablockdrop.model.abstraction;

/**
 * Subclasse abstrata que herda os valores de {@code APeca} direcionada para pecas que
 * podem ter diferentes variações posições dentro do tabuleiro (no mínimo 2 e no máximo 4).
 */
public abstract class APecaMultivariavel extends APeca{
    protected int quantidadeVariacoes;
    protected int posicao;

    /**
     * Método abstrato que será sobrescrito dependendo da classe de qual peça que terá
     * as coordenadas analisadas nele, de maneira diferente.
     */
    public abstract void definirPosicao();
}