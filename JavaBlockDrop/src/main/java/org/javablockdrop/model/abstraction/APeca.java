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
        this.casas= partidaModelo.getTabuleiroModelo().getListaCasas();
    }

    /**
     * Cria a peça definindo a coordenada da casa do tabuleiro que a peça ocupa
     * como ocupada e estabelecendo a cor da peça.
     */
    public void definirCasas(){
        casas.get(c1).setOcupado(true);
        casas.get(c1).setCor(this.cor.getDescricao());

        casas.get(c2).setOcupado(true);
        casas.get(c2).setCor(this.cor.getDescricao());

        casas.get(c3).setOcupado(true);
        casas.get(c3).setCor(this.cor.getDescricao());

        casas.get(c4).setOcupado(true);
        casas.get(c4).setCor(this.cor.getDescricao());
    }

    /**
     * Movimenta a peça para direita n quantidade de vezes somente se nenhuma peça ocupa uma coordenada ao lado ou se
     * ultrapassará a borda do tabuleiro.
     * @param qnt a quantidade de vezes que se moverá para direita.
     */
    public void movimentarD(int qnt) {
        boolean nenhumaOcupada = Stream.of(c1 + qnt, c2 + qnt, c3 + qnt, c4 + qnt)
                .map(index -> casas.get(index))
                .noneMatch(CasaModelo::isOcupado);

        if (nenhumaOcupada) {
            c1 += qnt;
            c2 += qnt;
            c3 += qnt;
            c4 += qnt;
        } else{
            System.out.printf("Ops, deu erro! A peca não pode movimentar para direita\n");
        }
    }

    /**
     * Movimenta a peça para esquerda n quantidade de vezes somente se nenhuma peça ocupa uma coordenada ao lado ou se
     * ultrapassará a borda do tabuleiro.
     * @param qnt a quantidade de vezes que se movimentará para esquerda.
     */
    public void movimentarE(int qnt) {
        boolean nenhumaOcupada = Stream.of(c1 - qnt, c2 - qnt, c3 - qnt, c4 - qnt)
                .map(index -> casas.get(index))
                .noneMatch(CasaModelo::isOcupado);

        if (nenhumaOcupada) {
            c1 -= qnt;
            c2 -= qnt;
            c3 -= qnt;
            c4 -= qnt;
        } else{
            System.out.printf("Ops, deu erro! A peca não conseguiu descer\n");
            estadoAI = false;
            criarPecaAleatoria();
        }
    }

    /**
     * Desloca a peça para baixo automaticamente após uma jogada bem sucedida anterior, se houver
     * uma casa ocupada e a peça não pode deslocar para baixo, então o estado dela é alterado para inativo (false)
     * e outra peça deve ser gerada.
     */
    public void descer() {
        boolean nenhumaOcupada = Stream.of(c1 + 8, c2 + 8, c3 + 8, c4 + 8)
                .map(index -> casas.get(index))
                .noneMatch(CasaModelo::isOcupado);

        if (nenhumaOcupada) {
            c1 += 8;
            c2 += 8;
            c3 += 8;
            c4 += 8;
        } else{
            System.out.println(c1+c2+c3+c4);
            System.out.printf("Ops, deu erro! A peca não conseguiu descer\n");
            estadoAI = false;
            criarPecaAleatoria();
        }
    }

    /**
     * Gera a peça a ser manipulada por meio de um numero aleatorio que cria uma peça aleatória, podendo ser
     * 0, I, L, J, T, S ou Z.
     * @return a nova peça criada e pronta para ser usada.
     */
    public static APeca criarPecaAleatoria() {
        APeca novaPeca = null;
        int r = (int)(Math.random() * 7);
        System.out.println("Número sorteado para peça: " + r);

        switch (r) {
            case 0:
                novaPeca = new PecaO();
                break;
            case 1:
                novaPeca = new PecaL();
                break;
            case 2:
                novaPeca = new PecaJ();
                break;
            case 3:
                novaPeca = new PecaT();
                break;
            case 4:
                novaPeca = new PecaZ();
                break;
            case 5:
                novaPeca = new PecaS();
                break;
            case 6:
                novaPeca = new PecaI();
                break;
            default:
                System.out.println("Erro: número aleatório fora do esperado. Criando PeçaO padrão.");
                novaPeca = new PecaO();
                break;
        }
        novaPeca.definirCasas();
        return novaPeca;
    }

    /**
     * Métodos de encapsulamento getters e setters
     */
    public boolean isEstadoAI() {return estadoAI;}
    public void setEstadoAI(boolean estadoAI) {this.estadoAI = estadoAI;}

    public int getC1() {return c1;}
    public int getC2() {return c2;}
    public int getC3() {return c3;}
    public int getC4() {return c4;}

    public void setC1(int c1) {this.c1 = c1;}
    public void setC2(int c2) {this.c2 = c2;}
    public void setC3(int c3) {this.c3 = c3;}
    public void setC4(int c4) {this.c4 = c4;}

    public Cor getCor() {return cor;}
    public void setCor(Cor cor) {this.cor = cor;}

    public int getPosicao() {return posicao;}
    public void setPosicao(int posicao) {this.posicao = posicao;}
}