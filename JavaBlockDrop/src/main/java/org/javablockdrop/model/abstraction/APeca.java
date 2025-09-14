package org.javablockdrop.model.abstraction;

import org.javablockdrop.model.CasaModelo;
import org.javablockdrop.model.PartidaModelo;
import org.javablockdrop.model.enumeration.Cor;
import org.javablockdrop.model.implementation.*;

import java.util.List;
import java.util.stream.Stream;

/**
 * Superclasse abstrata de todas as peças, que inicia os atributos de coordenadas que a peça ocupa, cor e estado,
 * os quais tem os valores definidos nas classes filhas (como {@code PecaO})
 */
public abstract class APeca {
    private PartidaModelo partidaModelo=PartidaModelo.getInstancia();
    private List<CasaModelo> casas;

    protected int c1=0;
    protected int c2=0;
    protected int c3=0;
    protected int c4=0;

    protected Cor cor;

    protected boolean estadoAI = true;
    protected int posicao;

    public APeca() {
        this.casas = partidaModelo.getTabuleiroModelo().getListaCasas();
    }

    /**
     * Cria a peça definindo a coordenada da casa do tabuleiro que a peça ocupa
     * como ocupada e estabelecendo a cor da peça.
     */
    public boolean definirCasasOcupadas(){
        boolean colisao = Stream.of(c1, c2, c3, c4)
                .anyMatch(index -> casas.get(index).isOcupada());

        if (colisao) {
            return false;
        }

        casas.get(c1).setOcupada(true);
        casas.get(c1).setCor(this.cor.getDescricao());

        casas.get(c2).setOcupada(true);
        casas.get(c2).setCor(this.cor.getDescricao());

        casas.get(c3).setOcupada(true);
        casas.get(c3).setCor(this.cor.getDescricao());

        casas.get(c4).setOcupada(true);
        casas.get(c4).setCor(this.cor.getDescricao());

        return true;
    }

    public void limparCasasOcupadas() {
        casas.get(c1).setOcupada(false);
        casas.get(c1).setCor(null);

        casas.get(c2).setOcupada(false);
        casas.get(c2).setCor(null);

        casas.get(c3).setOcupada(false);
        casas.get(c3).setCor(null);

        casas.get(c4).setOcupada(false);
        casas.get(c4).setCor(null);
    }

    /**
     * Movimenta a peça para direita n quantidade de vezes somente se nenhuma peça ocupa uma coordenada ao lado ou se
     * ultrapassará a borda do tabuleiro.
     * @param qnt a quantidade de vezes que se moverá para direita.
     */
    public void movimentarD(int qnt) {
        boolean naBorda = Stream.of(c1, c2, c3, c4).anyMatch(index -> (index + 1) % 8 == 0);
        if (naBorda) {
            return;
        }
        limparCasasOcupadas();

        boolean nenhumaOcupada = Stream.of(c1 + qnt, c2 + qnt, c3 + qnt, c4 + qnt)
                .map(index -> casas.get(index))
                .noneMatch(CasaModelo::isOcupada);

        if (nenhumaOcupada) {
            c1 += qnt;
            c2 += qnt;
            c3 += qnt;
            c4 += qnt;
        }
        definirCasasOcupadas();

    }

    /**
     * Movimenta a peça para esquerda n quantidade de vezes somente se nenhuma peça ocupa uma coordenada ao lado ou se
     * ultrapassará a borda do tabuleiro.
     * @param qnt a quantidade de vezes que se movimentará para esquerda.
     */
    public void movimentarE(int qnt) {
        boolean naBorda = Stream.of(c1, c2, c3, c4).anyMatch(index -> index % 8 == 0);
        if (naBorda) {
            return;
        }
        limparCasasOcupadas();
        boolean nenhumaOcupada = Stream.of(c1 - qnt, c2 - qnt, c3 - qnt, c4 - qnt)
                .map(index -> casas.get(index))
                .noneMatch(CasaModelo::isOcupada);

        if (nenhumaOcupada) {
            c1 -= qnt;
            c2 -= qnt;
            c3 -= qnt;
            c4 -= qnt;
        }
        definirCasasOcupadas();

    }

    /**
     * Desloca a peça para baixo automaticamente após uma jogada bem sucedida anterior, se houver
     * uma casa ocupada e a peça não pode deslocar para baixo, então o estado dela é alterado para inativo (false)
     * e outra peça deve ser gerada.
     */
    public void descer() {
        boolean noChao = Stream.of(c1, c2, c3, c4).anyMatch(index -> index >= 56);
        if (noChao) {
            this.estadoAI = false;
            return;
        }
        limparCasasOcupadas();

        boolean nenhumaOcupada = Stream.of(c1 + 8, c2 + 8, c3 + 8, c4 + 8)
                .map(index -> casas.get(index))
                .noneMatch(CasaModelo::isOcupada);

        if (nenhumaOcupada) {
            c1 += 8;
            c2 += 8;
            c3 += 8;
            c4 += 8;
        } else{
            System.out.printf("Ops, deu erro! A peca não conseguiu descer\n");
            estadoAI = false;
        }
        definirCasasOcupadas();

    }

    /**
     * Gera a peça a ser manipulada por meio de um numero aleatorio que cria uma peça aleatória, podendo ser
     * 0, I, L, J, T, S ou Z.
     * @return a nova peça criada e pronta para ser usada.
     */
    public static APeca criarPecaAleatoria() {
        APeca novaPeca = null;
        int r = (int)(Math.random() * 7);

        novaPeca = new PecaL();
        return novaPeca;
    }

    /**
     * Calcula e define a próxima posição da casa ocupada.
     * @param cp1 valor a ser somado a casa 1
     * @param cp2 valor a ser somado a casa 2
     * @param cp3 valor a ser somado a casa 3
     * @param cp4 valor a ser somado a casa 4
     */
    public void definirProximaPosicao(int cp1, int cp2, int cp3, int cp4) {
        this.c1 += cp1;
        this.c2 += cp2;
        this.c3 += cp3;
        this.c4 += cp4;
    }

    /**
     * Métodos de encapsulamento getters e setters
     */
    public boolean isEstadoAI() {return estadoAI;}
    public void setEstadoAI(boolean estadoAI) {this.estadoAI = estadoAI;}

    public Cor getCor() {return cor;}
    public void setCor(Cor cor) {this.cor = cor;}

    public int getPosicao() {return posicao;}
    public void setPosicao(int posicao) {this.posicao = posicao;}
}