package org.javablockdrop.controller;

import org.javablockdrop.model.Jogada;
import org.javablockdrop.model.TabuleiroModelo;

import java.util.*;

public class InputController {
    private TabuleiroModelo tabuleiroModelo;
    private Jogada jogada;
    private List<Jogada> listaJogadas = new ArrayList<>();
    public OutputController outputController= new OutputController();;

    public InputController(){
        jogada=Jogada.getInstancia();
        tabuleiroModelo=TabuleiroModelo.getInstancia();
    }

    public void obterResposta(String resposta){
        String respostaLower= resposta.toLowerCase();
        switch (respostaLower){
            case "s":
                tabuleiroModelo.criarTabuleiro();
                outputController.instrucionarUsuario();
                break;
            case"n":
                outputController.despedirDoUsuario();
                break;
        }
    }

    public void obterJogada(String jogada) {
        if (jogada == null || jogada.isEmpty()) {
            System.out.println("Resposta inválida! Siga os comandos.");
            return;
        }

        String jogadaLower = jogada.toLowerCase();

        switch (jogadaLower) {
            case "p":
                outputController.pausar();
                break;
            case "v":
                outputController.exibirTabuleiro();
                outputController.repetir();
                break;
            case "s":
                outputController.despedirDoUsuario();
                break;
            default:
                if (jogada.length() == 2 && Character.isLetter(jogada.charAt(0)) && Character.isDigit(jogada.charAt(1))) {
                    try {
                        char letra = jogada.charAt(0);
                        int numero = Character.getNumericValue(jogada.charAt(1));

                        listaJogadas.add(new Jogada(letra, numero));

                        outputController.exibirTabuleiro();
                        outputController.repetir();
                    } catch (Exception e) {
                        System.out.println("Erro ao processar a jogada: " + e.getMessage());
                    }
                } else {
                    System.out.println("Jogada inválida! Use o formato LetraNúmero (ex: A4).");
                }
                break;
        }
    }
}