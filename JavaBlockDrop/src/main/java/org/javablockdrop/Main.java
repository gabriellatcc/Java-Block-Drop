package org.javablockdrop;
import org.javablockdrop.controller.InputController;
import org.javablockdrop.model.Cor;
import org.javablockdrop.model.TabuleiroModelo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        TabuleiroModelo.getInstancia();
//o nivel é baseado na quantidade de pontos
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
        InputController entrada=new InputController();
        entrada.obterResposta(resposta);
    }
}