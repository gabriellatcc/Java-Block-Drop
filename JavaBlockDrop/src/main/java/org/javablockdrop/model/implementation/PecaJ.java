package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IPoliVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IPoliVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, laranja
 * ou vermelho claro.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaJ extends APeca implements IPoliVariacao {
    public PecaJ() {
        this.c1 = 4;
        this.c2 = 12;
        this.c3 = 19;
        this.c4 = 20;
        this.cor = Cor.LARANJA;
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
                    case 2 -> definirProximaPosicao(-2,-2,-8,-8);
                    case 3 -> definirProximaPosicao(-1,-8,-8,-1);
                    case 4 -> definirProximaPosicao(-2,-9,-15,-8);
                }
                break;
            case 2:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(2,2,8,8);
                    case 3 -> definirProximaPosicao(1,-6,0,7);
                    case 4 -> definirProximaPosicao(0,-7,-7,0);
                }
                break;
            case 3:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(1,8,8,1);
                    case 2 -> definirProximaPosicao(-1,6,0,-7);
                    case 4 -> definirProximaPosicao(-1,-1,-7,-7);
                }
                break;
            case 4:
                switch (posicaoFinal){
                    case 5 -> definirProximaPosicao(2,9,15,8);
                    case 2 -> definirProximaPosicao(0,7,7,0);
                    case 3 -> definirProximaPosicao(1,1,7,7);
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
                    case 2 -> definirProximaPosicao(-2,-9,-15,-8);
                    case 3 -> definirProximaPosicao(-1,-8,-8,-1);
                    case 4 -> definirProximaPosicao(-2,-2,-8,-8);
                }
                break;
            case 2:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(2,9,15,8);
                    case 3 -> definirProximaPosicao(2,2,8,8);//estao trocados
                    case 4 -> definirProximaPosicao(0,7,7,0);
                }
                break;
            case 3:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(1,8,8,1);
                    case 2 -> definirProximaPosicao(-1,-1,-7,-7);
                    case 4 -> definirProximaPosicao(-1,6,0,-7);
                }
                break;
            case 4:
                switch (posicaoFinal){
                    case 5 -> definirProximaPosicao(1,1,7,7);// estao trocados
                    case 2 -> definirProximaPosicao(0,-7,-7,0);
                    case 3 -> definirProximaPosicao(1,-6,0,7);
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
        if(c1-c2 == -8 && c2-c3 == -7 && c3-c4 == -1 && c4-c1 == 16){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -8 && c2-c3 == -1 && c3-c4 == -1 && c4-c1 == 10){
            setPosicao(2);
            return 2;
        } else if (c1-c2 == -1 && c2-c3 == -7 && c3-c4 == -8 && c4-c1 == 16) {
            setPosicao(3);
            return 3;
        } else if (c1-c2 == -1 && c2-c3 == -1 && c3-c4 == -8 && c4-c1 == 10) {
            setPosicao(4);
            return 4;
        } else {
            System.out.println("A peça não está e nenhuma posição conhecida!");
            return 0;
        }
    }
}