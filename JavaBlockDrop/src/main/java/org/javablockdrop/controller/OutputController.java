package org.javablockdrop.controller;

import org.javablockdrop.model.Cor;
import org.javablockdrop.model.TabuleiroModelo;

import java.util.Scanner;

public class OutputController {
    private TabuleiroModelo tabuleiroModelo;

    public OutputController() {
        tabuleiroModelo=TabuleiroModelo.getInstancia();
    }

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

        InputController inputController=new InputController();
        inputController.obterResposta(resposta);
    }

    public void instrucionarUsuario(){
        Scanner e =  new Scanner(System.in);

        System.out.println(Cor.RESETADO.getDescricao()+ "Para cada tipo de jogada digite o comando correspondente. " +
                "\nVocê pode fazer combinações, como: H2D2, A4 ou A3E2. \n" +
                "H + N -> rodar a peça para o sentido horario  x  N numero de vezes\n" +
                "A + N -> rodar a peça para o sentido anti-horário  x  N numero de vezes\n" +
                "D + N -> deslizar a peça para direita  x  N numero de vezes\n" +
                "E + N -> deslizar a peça para esquerda  x  N numero de vezes\n" +
                "P -> pausar e despausar\n"+
                "S -> sair e encerrar");
        String jogada = e.nextLine();

        InputController inputController=new InputController();
        inputController.obterJogada(jogada);
    }

    public void exibirTabuleiro(){
        for (int i = 0; i < tabuleiroModelo.getPosicoesLista().size(); i++) {
            System.out.print(tabuleiroModelo.getPosicoesLista().get(i).getComposicao() + " ");
            if ((i + 1) % 8 == 0) {
                System.out.println(Cor.RESETADO.getDescricao());
            }
        }
    }

    public void repetir(){
        Scanner e =  new Scanner(System.in);

        System.out.println("Continue digitando jogadas e as peças se deslocam 1 para baixo.");
        String jogada = e.nextLine();

        InputController inputController=new InputController();
        inputController.obterJogada(jogada);
    }

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

        InputController inputController=new InputController();
        inputController.obterJogada(jogada);
    }

    public void oferecerTentar(){
        Scanner e =  new Scanner(System.in);

        System.out.println("Que pena! Quer tentar de novamente?");
        String jogada = e.nextLine();

        InputController inputController=new InputController();
        inputController.obterResposta(jogada);
    }

    public void despedirDoUsuario() {
        System.out.println(Cor.NEGRITO.getDescricao()+
                "\nObrigada por visitar o jogo!" +
                "\n"+Cor.ROXO.getDescricao()+"\u001b[30m"+"@gabriellatcc - GITHUB       "+Cor.RESETADO.getDescricao()+
                "\n"+Cor.AZUL.getDescricao()+"\u001b[30m"+"@gabriellatccorrea - LINKEDIN"+Cor.RESETADO.getDescricao());
    }
}