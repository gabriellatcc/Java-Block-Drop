package org.javablockdrop.model.implementation;

import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.interfaces.IPoliVariacao;
import org.javablockdrop.model.enumeration.Cor;

/**
 * Subclasse que herda os métodos e atributos das classes {@code APeca}, {@code APecaMultivariavel} e
 * {@code IPoliVariacao}, que redefine os valores das coordenadas da peca e a cor que deve ser e, neste caso, roxo.
 * Também herda os métodos de rotação que funcionam diferentemente de outras peças.
 */
public class PecaT extends APeca implements IPoliVariacao {
    public PecaT() {
        this.c1 = 2;
        this.c2 = 3;
        this.c3 = 4;
        this.c4 = 11;
        this.cor = Cor.ROXO;
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
        int posicaoFinal = ((posicaoAtual - 1 + rotacoesEfetivas) % 4) + 1;
        switch (posicaoAtual){
            case 1: //posicao atual
                switch (posicaoFinal){//proxima posicao
                    case 2 -> definirProximaPosicao(2,8,8,9);
                    case 3 -> definirProximaPosicao(1,7,7,1);
                    case 4 -> definirProximaPosicao(1,8,8,8);
                }
                break;
            case 2:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(-2,-8,-8,-9);
                    case 3 -> definirProximaPosicao(-1,-1,-1,-8);
                    case 4 -> definirProximaPosicao(-1,0,0,-1);
                }
                break;
            case 3:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(-1,-7,-7,-1);
                    case 2 -> definirProximaPosicao(1,1,1,8);
                    case 4 -> definirProximaPosicao(0,1,1,7);
                }
                break;
            case 4:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(-1,-8,-8,-8);
                    case 2 -> definirProximaPosicao(1,0,0,1);
                    case 3 -> definirProximaPosicao(0,-1,-1,-7);
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
        int posicaoFinal = ((posicaoAtual - 1 + rotacoesEfetivas) % 4) + 1;
        switch (posicaoAtual){
            case 1: //posicao atual
                switch (posicaoFinal){//proxima posicao
                    case 2 -> definirProximaPosicao(1,8,8,8);
                    case 3 -> definirProximaPosicao(1,7,7,1);
                    case 4 -> definirProximaPosicao(2,8,8,9);
                }
                break;
            case 2:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(-1,-8,-8,-8);
                    case 3 -> definirProximaPosicao(-2,-8,-8,-9);//
                    case 4 -> definirProximaPosicao(1,0,0,1);
                }
                break;
            case 3:
                switch (posicaoFinal){
                    case 1 -> definirProximaPosicao(-1,-7,-7,-1);
                    case 2 -> definirProximaPosicao(0,1,1,7);
                    case 4 -> definirProximaPosicao(1,1,1,8);
                }
                break;
            case 4:
                switch (posicaoFinal){
                    case 3 -> definirProximaPosicao(0,-1,-1,-7);//
                    case 2 -> definirProximaPosicao(1,0,0,1);
                    case 1 -> definirProximaPosicao(-1, -8, -8, -8);
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
        if(c1-c2 == -1 && c2-c3 == -1 && c3-c4 == -7 && c4-c1 == 9){
            setPosicao(1);
            return 1;
        } else if (c1-c2 == -7 && c2-c3 == -1 && c3-c4 == -8 && c4-c1 == 16){
            setPosicao(2);
            return 2;
        } else if (c1-c2 == -7 && c2-c3 == -1 && c3-c4 == -1 && c4-c1 == 9) {
            setPosicao(3);
            return 3;
        } else if (c1-c2 == -8 && c2-c3 == -1 && c3-c4 == -7 && c4-c1 == 16) {
            setPosicao(4);
            return 4;
        } else {
            return 0;
        }
    }
}