package org.javablockdrop.model.interfaces;

/**
 * Interface para peças com 2 variações de posições no tabuleiro.
 */
public interface IDuplaVariacao {
    int quantidadeVariacoes = 2;

    /**
     * Método abstrato que será sobrescrito dependendo da classe de qual peça que terá
     * as coordenadas analisadas nele, de maneira diferente.
     */
    public abstract int definirPosicao();

    /**
     * Método abstrato que será sobrescrito dependendo da qual peça que terá
     * as coordenadas manipuladas nele.
     */
    public abstract void girar(int qnt);
}
