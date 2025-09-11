package org.javablockdrop.model.abstraction;

/**
 * Interface para peças com 2 variações de posições no tabuleiro.
 */
public interface IDuplaVariacao {
    int quantidadeVariacoes = 2;

    /**
     * Método abstrato que será sobrescrito dependendo da classe de qual peça que terá
     * as coordenadas analisadas nele, de maneira diferente.
     */
    public abstract void definirPosicao();

    /**
     * Método abstrato que será sobrescrito dependendo da qual peça que terá
     * as coordenadas manipuladas nele.
     */
    public abstract void girar(int qnt);
}
