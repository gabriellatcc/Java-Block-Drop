package org.javablockdrop.controller;

import org.javablockdrop.model.PartidaModelo;
import org.javablockdrop.model.enumeration.Cor;

import java.util.Scanner;

/**
 * Nesta classe os principais métodos de explicação para o usuário são utilizados para
 * manifestar o tabuleiro, agradecimento e projetar pausa do jogo.
 */
public class OutputController {
    private PartidaModelo partidaModelo;
    private InputController inputController;

    public OutputController() {
        partidaModelo=PartidaModelo.getInstancia();
    }

    /**
     * Imprime a mensagem inicial que apresenta o jogo e chama a classe InputController para receber
     * a resposta de permissão para iniciar o jogo.
     */
    public void saudar() {
        Scanner e = new Scanner(System.in);
        System.out.println(
                "================ " + Cor.NEGRITO.getDescricao() + "BEM-VINDO AO BLOCKDROP" + Cor.RESETADO.getDescricao() + " ================\n" +
                        "Baseado no clássico Tetris de 1984, esta é uma versão do\n" +
                        "jogo é uma versão em que você interage com os tetraminós\n" +
                        "por meio de turnos para girá-los e movê-los. O objetivo\n" +
                        "é eliminar uma ou mais linhas na horizontal para ganhar\n" +
                        "pontos e aumentar o nível! Tome muito cuidado para não\n" +
                        "travar o tabuleiro. Vamos jogar?" +
                        "\n S -> para jogar e consultar as instruções" +
                        "\n N -> para não jogar");
        String resposta = e.nextLine();

        this.inputController.obterResposta(resposta);
    }

    /**
     * Informa o usuário os possíveis comandos a serem utilizados para manipular o tabuleiro,
     * como o modo em que se gira ou move uma peça e a forma de pausar e retornar ao jogo.
     */
    public void instrucionarUsuario(){
        Scanner e =  new Scanner(System.in);

        System.out.println(Cor.RESETADO.getDescricao()+ "Para cada tipo de jogada digite o comando correspondente. " +
                "\nVocê pode fazer combinações, como: H2D2, A4 ou A3E2. \n" +
                "H + N -> rodar a peça para o sentido horario  x  N numero de vezes\n" +
                "A + N -> rodar a peça para o sentido anti-horário  x  N numero de vezes\n" +
                "D + N -> deslizar a peça para direita  x  N numero de vezes\n" +
                "E + N -> deslizar a peça para esquerda  x  N numero de vezes\n" +
                "CA -> passar o turno e deixar a peça cair \n" +
                "P -> pausar e despausar\n"+
                "S -> sair e encerrar");
        String jogada = e.nextLine();

        this.inputController.obterJogada(jogada);
    }

    /**
     * Exibe o tabuleiro por meio da impressão da lista de suas casas em loop e quebra de linha a cada 8 casas,
     * formando um tabuleiro de 64 casas.
     */
    public void exibirTabuleiro(){
        for (int i = 0; i < partidaModelo.getTabuleiroModelo().getListaCasas().size(); i++) {
            System.out.print(partidaModelo.getTabuleiroModelo().getListaCasas().get(i).getComposicao() + " ");
            if ((i + 1) % 8 == 0) {
                if (i == 7) {
                    partidaModelo.getLinhasLimpas();
                    System.out.print(Cor.RESETADO.getDescricao()+"    "+Cor.PADRAO.getDescricao()+" PONTUAÇÃO TOTAL: " + partidaModelo.getPontos()+" ");
                }
                System.out.println(Cor.RESETADO.getDescricao());
            }
      }
    }

    /**
     * Repete para o usuário digitar mais jogadas para que o jogo continue e aguarda a jogada por meio
     * da classe InputController.
     */
    public void repetir(){
        Scanner e =  new Scanner(System.in);

        System.out.println("Continue digitando jogadas e as peças se deslocam 1 para baixo.");
        String jogada = e.nextLine();

        this.inputController.obterJogada(jogada);
    }

    /**
     * Exibe a mensagem de "O JOGO ESTÁ PAUSADO" personalizada que tem as mesmas proporcões que o tabuleiro ocupa.
     */
    public void pausar(){
        Scanner e =  new Scanner(System.in);
        String vazio = "                        ";
        System.out.println(Cor.PADRAO.getDescricao()+
                vazio+Cor.RESETADO.getDescricao()+"\n"+
                Cor.PADRAO.getDescricao()+
                vazio+Cor.RESETADO.getDescricao()+"\n"+
                Cor.PADRAO.getDescricao()+
                vazio+Cor.RESETADO.getDescricao()+"\n"+
                Cor.NEGRITO.getDescricao()+Cor.PADRAO.getDescricao()+
                "         O JOGO         "+Cor.RESETADO.getDescricao()+
                "\n"+Cor.NEGRITO.getDescricao()+Cor.PADRAO.getDescricao()+
                "          ESTÁ          "+ Cor.RESETADO.getDescricao()+
                "\n"+Cor.NEGRITO.getDescricao()+Cor.PADRAO.getDescricao()+
                "         PAUSADO        "+ Cor.RESETADO.getDescricao()+
                vazio+Cor.RESETADO.getDescricao()+"\n"+
                Cor.PADRAO.getDescricao()+
                vazio+Cor.RESETADO.getDescricao()+"\n"+
                Cor.PADRAO.getDescricao()+
                vazio+Cor.RESETADO.getDescricao()+"\n"+
                Cor.PADRAO.getDescricao()+
                vazio+Cor.RESETADO.getDescricao()+"\n"+
                Cor.NEGRITO.getDescricao()+"V -> para retomar");
        String jogada = e.nextLine();

        this.inputController.obterJogada(jogada);
    }

    /**
     * Informa uma mensagem de agradecimento ao usuário quando o jogo encerra.
     */
    public void despedirDoUsuario() {
        System.out.println(Cor.NEGRITO.getDescricao()+
                "\nObrigada por visitar o jogo!" +
                "\n"+Cor.ROXO.getDescricao()+"\u001b[30m"+"@gabriellatcc - GITHUB       "+Cor.RESETADO.getDescricao()+
                "\n"+Cor.AZUL.getDescricao()+"\u001b[30m"+"@gabriellatccorrea - LINKEDIN"+Cor.RESETADO.getDescricao());
    }

    public void setInputController(InputController inputController) {
        this.inputController = inputController;
    }
}