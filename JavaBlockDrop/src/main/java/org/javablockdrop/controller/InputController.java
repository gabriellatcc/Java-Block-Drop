package org.javablockdrop.controller;

import org.javablockdrop.model.Cor;
import org.javablockdrop.model.TabuleiroModelo;

import java.util.Objects;
import java.util.Scanner;

public class InputController {
    private TabuleiroModelo tabuleiroModelo;

    public InputController(){
        tabuleiroModelo=TabuleiroModelo.getInstancia();
    }

    public void obterResposta(String resposta){
        try{
            if(Objects.equals(resposta, "S") ||Objects.equals(resposta, "s")  ){
                //executar tabuleiro
                tabuleiroModelo.criarTabuleiro();
                instrucionarUsuario();
            } else if (Objects.equals(resposta, "N")){
                System.out.println("Ok, não jogaremos Tetris.");
        }} catch (Exception e){
            System.out.println("Erro: a resposta não chegou.");
            return;
        }
    }
    public void instrucionarUsuario(){
        System.out.println(Cor.RESETADO.getDescricao()+ "Para cada tipo de jogada digite o comando correspondente. " +
                "\nVocê pode fazer combinações, como: RH2D2, RA4 ou RA3E4. \n" +
                "RHN -> rodar a peça para o sentido horario x N numero de vezes \n" +
                "RAN -> rodar a peça para o sentido anti-horário  x N numero de vezes \n" +
                "DN -> deslizar a peça para direita x N numero de vezes \n" +
                "EN -> deslizar a peça para esquerda  x N numero de vezes \n" +
                "P0 -> pausar e despausar\n");

        Scanner e =  new Scanner(System.in);
        String jogada = e.nextLine();
        obterJogada(jogada);
    }
    public void obterJogada(String jogada){


    }
}