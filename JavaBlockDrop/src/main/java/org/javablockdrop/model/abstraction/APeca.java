package org.javablockdrop.model.abstraction;

import org.javablockdrop.model.CasaModelo;
import org.javablockdrop.model.PartidaModelo;
import org.javablockdrop.model.enumeration.Cor;

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

    public APeca() {
        this.casas= partidaModelo.getTabuleiroModelo().getListaCasas();
    }

    /**
     * Cria a peça definindo a coordenada da casa do tabuleiro que a peça ocupa
     * como ocupada e estabelecendo a cor da peça.
     */
    public void criar(){
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
            partidaModelo.getTabuleiroModelo().gerarPeca();
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
            System.out.printf("Ops, deu erro! A peca não conseguiu descer\n");
            estadoAI = false;
            partidaModelo.getTabuleiroModelo().gerarPeca();
            //chamar outra peca
        }
    }

    // 3 4 11 12 O
    // 3 11	19	20 L
    // 4 12 19 20 J
    // 2 3 4 11 T
    //3 4 10 11 s
    // 2 3 11 12 z
    // 3 11 19 28 I

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

}