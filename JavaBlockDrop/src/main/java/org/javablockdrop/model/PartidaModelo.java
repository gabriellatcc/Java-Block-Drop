package org.javablockdrop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe singleton principal da aplicação, possui a lista de jogadas, quantidade pontos e a
 * instancia do tabuleiro que será utilizada por todo o jogo.
 */
public final class PartidaModelo {
    private static PartidaModelo instancia;

    private TabuleiroModelo tabuleiroModelo= new TabuleiroModelo();

    private List<JogadaModelo> listaJogadaModelos = new ArrayList<>();
    private int pontos=0;

    public PartidaModelo() {}

    /**
     * Retorna a instancia da classe PartidaModelo.
     * @return instancia da classe PatidaModelo
     */
    public static synchronized PartidaModelo getInstancia() {
        try {
            if (instancia == null) {
                instancia = new PartidaModelo();
            }
            return instancia;
        } catch (Exception e) {
            System.out.println("Erro ao retornar a instância: "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Soma os pontos a cada linha de casas ocupadas que o jogador elimina
     * @param pontos a serem somados.
     * @return os pontos somados.
     */
    public int somarPontos(int pontos){
        this.pontos+=pontos;
        return this.pontos;
    }

    /**
     * Métodos de encapsulamento getters e setters
     */
    public TabuleiroModelo getTabuleiroModelo() {return tabuleiroModelo;}
    public List<JogadaModelo> getListaJogadas() {return listaJogadaModelos;}
}