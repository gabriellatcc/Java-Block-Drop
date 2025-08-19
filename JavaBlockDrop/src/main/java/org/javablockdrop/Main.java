package org.javablockdrop;
import org.javablockdrop.controller.InputController;
import org.javablockdrop.model.TabuleiroModelo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        TabuleiroModelo.getInstancia();
//o nivel é baseado na quantidade de pontos
        System.out.println(
                "=============================   BEM-VINDO AO TETRIS   ============================= \n" +
                "Baseado no clássico Tetris de 1984, este jogo é uma versão em que você interage com \n" +
                "os tetraminós por meio de turnos para girá-los e movê-los. O objetivo é eliminar \n" +
                "uma ou mais linhas na horizontal para ganhar pontos e aumentar o nível! Tome muito \n" +
                "cuidado para não travar o tabuleiro. Vamos jogar?" +
                "\n S -> para jogar e consultar as instruções" +
                "\n N -> para não jogar");
        String resposta = e.nextLine();
        InputController entrada=new InputController();
        entrada.obterResposta(resposta);
    }
}