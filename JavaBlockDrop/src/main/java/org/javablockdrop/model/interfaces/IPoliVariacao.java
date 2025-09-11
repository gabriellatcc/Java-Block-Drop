package org.javablockdrop.model.interfaces;

/**
 * Interface para peças com 4 variações de posições no tabuleiro.
 */
public interface IPoliVariacao {
    int quantidadeVariacoes = 4;

    /**
     * Método abstrato que será sobrescrito dependendo da classe de qual peça que terá
     * as coordenadas analisadas nele, de maneira diferente.
     */
    public abstract int definirPosicao();

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