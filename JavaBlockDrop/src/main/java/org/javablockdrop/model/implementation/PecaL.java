package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IPoliVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IPoliVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, azul.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaL extends APeca implements IPoliVariacao {
    public PecaL() {
        this.c1 = 3;
        this.c2 = 11;
        this.c3 = 19;
        this.c4 = 20;
        this.cor = Cor.AZUL;
    }

    @Override
    public void girarHorario(int quantidade) {
        if (quantidade % 4 == 0) return;

        limparCasasOcupadas();

        int posicaoAtual = definirPosicaoAtual();
        if (posicaoAtual == 0) {
            definirCasasOcupadas();
            return;
        }

        int rotacoesEfetivas = quantidade % 4;
        int posicaoFinal = posicaoAtual+rotacoesEfetivas;
        switch (posicaoAtual){
            case 1: //posicao atual
                switch (posicaoFinal){//proxima posicao
                    case 2 -> definirProximaPosicao(-1,-8,-15,-10);
                    case 3 -> definirProximaPosicao(0,-7,-7,0);
                    case 4 -> definirProximaPosicao(1,-1,-8,-8);
                }
                break;
            case 2:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(1,8,15,10);
                    case 3 -> definirProximaPosicao(1,1,8,10);
                    case 4 -> definirProximaPosicao(2,7,7,2);
                }
                break;
            case 3:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(0,7,7,0);
                    case 2 -> definirProximaPosicao(-1,-1,-8,-10);
                    case 4 -> definirProximaPosicao(1,6,-1,-8);
                }
                break;
            case 4:
                switch (posicaoFinal){
                    case 5 -> definirProximaPosicao(-1,1,8,8);
                    case 2 -> definirProximaPosicao(-2,-7,-7,-2);
                    case 3 -> definirProximaPosicao(-1,-6,1,8);
                }
                break;
            default:
                System.out.println("Peça não girada.");
                return;
        }

        definirCasasOcupadas();
    }

    @Override
    public void girarAntiHorario(int quantidade) {
        if (quantidade % 4 == 0) return;

        limparCasasOcupadas();

        int posicaoAtual = definirPosicaoAtual();
        if (posicaoAtual == 0) {
            definirCasasOcupadas();
            return;
        }

        int rotacoesEfetivas = quantidade % 4;
        int posicaoFinal = posicaoAtual+rotacoesEfetivas;
        switch (posicaoAtual){
            case 1: //posicao atual
                switch (posicaoFinal){//proxima posicao
                    case 2 -> definirProximaPosicao(1,-1,-8,-8);
                    case 3 -> definirProximaPosicao(0,-7,-7,0);
                    case 4 -> definirProximaPosicao(1,-8,-15,-10);
                }
                break;
            case 2:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(-1,1,8,8);
                    case 3 -> definirProximaPosicao(1,8,15,10);//
                    case 4 -> definirProximaPosicao(-2,-7,-7,-2);
                }
                break;
            case 3:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(0,7,7,0);
                    case 2 -> definirProximaPosicao(1,6,-1,-8);
                    case 4 -> definirProximaPosicao(-1,-1,-8,-10);
                }
                break;
            case 4:
                switch (posicaoFinal){
                    case 5 -> definirProximaPosicao(-1,-6,1,8);//troca
                    case 2 -> definirProximaPosicao(2,7,7,2);
                    case 3 -> definirProximaPosicao(1,1,8,10);
                }
                break;
            default:
                System.out.println("Peça não girada.");
                return;
        }
        definirCasasOcupadas();
    }

    @Override
    public int definirPosicaoAtual() {
        if(c1-c2 == -8 && c2-c3 == -8 && c3-c4 == -1 && c4-c1 == 17){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -1 && c2-c3 == -1 && c3-c4 == -6 && c4-c1 == 8){
            setPosicao(2);
            return 2;
        } else if (c1-c2 == -1 && c2-c3 == -8 && c3-c4 == -8 && c4-c1 == 17) {
            setPosicao(3);
            return 3;
        } else if (c1-c2 == -6 && c2-c3 == -1 && c3-c4 == -1 && c4-c1 == 8) {
            setPosicao(4);
            return 4;
        } else {
            System.out.println("A peça está numa posição irreconhecível: "+
                    c1+ " "+c2+ " "+c3+ " "+c4);
            return 0;
        }
    }

    /**
     * Calcula e define a próxima posição da casa ocupada.
     * @param cp1 valor a ser somado a casa 1
     * @param cp2 valor a ser somado a casa 2
     * @param cp3 valor a ser somado a casa 3
     * @param cp4 valor a ser somado a casa 4
     */
    private void definirProximaPosicao(int cp1, int cp2, int cp3, int cp4) {
        this.c1 += cp1;
        this.c2 += cp2;
        this.c3 += cp3;
        this.c4 += cp4;
    }
}