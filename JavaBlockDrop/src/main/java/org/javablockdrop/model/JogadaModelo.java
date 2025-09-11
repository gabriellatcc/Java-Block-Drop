package org.javablockdrop.model;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.abstraction.IDuplaVariacao;
import org.javablockdrop.model.abstraction.IPoliVariacao;

/**
 * Nesta classe as jogadas manipulam a peça ativa no tabuleiro, cada jogada é composta por
 * um movimento e a quantidade de vezes em que acontece.
 */
public class JogadaModelo {
    private PartidaModelo partidaModelo=PartidaModelo.getInstancia();;

    private char movimento;
    private int quantidade;

    public JogadaModelo(char movimento, int quantidade) {
        this.movimento = movimento;
        this.quantidade = quantidade;
    }

    /**
     * Recebe a peça ativa do tabuleiro e dependendo da jogada ativa o método, verifica se a peça pertence
     * a uma instancia de classe multivalorada e utiliza a rotação especifica da peça.
     */
    public void executar(){
        APeca pecaAtiva = partidaModelo.getTabuleiroModelo().getPecaAtiva();
        if (pecaAtiva == null || !pecaAtiva.isEstadoAI()) {
            System.out.println("Não há peça ativa para mover.");
            return;
        }

        switch (movimento) {
            case 'd':
                pecaAtiva.movimentarD(quantidade);
                break;
            case 'e':
                pecaAtiva.movimentarE(quantidade);
                break;
            case 'a':
                if (pecaAtiva instanceof IPoliVariacao) {
                    ((IPoliVariacao) pecaAtiva).girarAntiHorario(quantidade);
                } else if (pecaAtiva instanceof IDuplaVariacao) {
                    ((IDuplaVariacao) pecaAtiva).girar(quantidade);
                }
                break;
            case 'h':
                if (pecaAtiva instanceof IPoliVariacao) {
                    ((IPoliVariacao) pecaAtiva).girarHorario(quantidade);
                } else if (pecaAtiva instanceof IDuplaVariacao) {
                    ((IDuplaVariacao) pecaAtiva).girar(quantidade);
                }
                break;
            default:
                System.out.println("Erro: Movimento inválido.");
                break;
        }
    }

    /**
     * Métodos de encapsulamento getters e setters.
     */
    public char getMovimento() {return movimento;}
    public int getQuantidade() {return quantidade;}
}