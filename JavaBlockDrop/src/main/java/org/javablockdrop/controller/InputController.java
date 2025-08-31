package org.javablockdrop.controller;

import org.javablockdrop.model.Cor;
import org.javablockdrop.model.TabuleiroModelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class InputController {
    private TabuleiroModelo tabuleiroModelo;

    public InputController(){
        tabuleiroModelo=TabuleiroModelo.getInstancia();
    }

    public void obterResposta(String resposta){
        if(Objects.equals(resposta, "S") ||Objects.equals(resposta, "s")){
            //executar tabuleiro
            tabuleiroModelo.criarTabuleiro();
            instrucionarUsuario();
        } else if (Objects.equals(resposta, "N")){
            System.out.println("Ok, não jogaremos Tetris.");
        }
    }

    public void instrucionarUsuario(){
        System.out.println(Cor.RESETADO.getDescricao()+ "Para cada tipo de jogada digite o comando correspondente. " +
                "\nVocê pode fazer combinações, como: H2D2, A4 ou A3E2. \n" +
                "H + N -> rodar a peça para o sentido horario x N numero de vezes \n" +
                "A + N -> rodar a peça para o sentido anti-horário  x N numero de vezes \n" +
                "D + N -> deslizar a peça para direita x N numero de vezes \n" +
                "E + N -> deslizar a peça para esquerda  x N numero de vezes \n" +
                "P -> pausar e despausar");

        Scanner e =  new Scanner(System.in);
        String jogada = e.nextLine();
        obterJogada(jogada);
    }

    public void obterJogada(String jogada) {
        if(jogada.length() > 6 || jogada.isEmpty()){
            System.out.println("Resposta inválida! siga os comandos.");
            return;
        } else {
            Map<Integer, Character> mapaPassos = new HashMap<Integer, Character>();
            try{
                int [] digito = new int [10];
                char[] passoJogado = jogada.toCharArray();
                for (int i=0;i<passoJogado.length;i++){
                    if(!Character.isDigit(jogada.charAt(i))){
                        passoJogado[i] = jogada.charAt(i);
                        System.out.println("char: "+passoJogado[i]);
                    } else{
                        digito[i] = Character.getNumericValue(jogada.charAt(i));
                        System.out.println("digito: "+digito[i]);
                        mapaPassos.put(digito[i], passoJogado[i-1]);
                        System.out.println(mapaPassos);
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: "+e.getMessage());
            }
        }
    }
}