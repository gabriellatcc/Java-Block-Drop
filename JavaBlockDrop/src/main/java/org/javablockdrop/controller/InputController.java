package org.javablockdrop.controller;

import org.javablockdrop.model.JogadaModelo;
import org.javablockdrop.model.PartidaModelo;

/**
 * Classe responsável pela entrada de dados digitados pelo usuário,
 * ela filtra e utiliza {@code OutputController} se não segue os padrões ou para prosseguir e informar o usuário.
 */
public class InputController {
    private PartidaModelo partidaModelo;

    public OutputController outputController= new OutputController();;

    public InputController(){
        partidaModelo=PartidaModelo.getInstancia();
    }

    /**
     * Obtém a resposta a primeira resposta do usuário para iniciar uma partida.
     * @param resposta pode ser "s" para a partida começar e, caso seja "n", o jogo
     * é encerrado e exibe uma mensagem de despedida e agradecimento para o usuário
     */
    public boolean obterResposta(String resposta){
        String respostaLower= resposta.toLowerCase();
        switch (respostaLower){
            case "s":
                partidaModelo.getTabuleiroModelo().criarTabuleiro();
                outputController.instrucionarUsuario();
                return true;
            case"n":
                outputController.despedirDoUsuario();
                System.exit(0);
                return true;
            default:
                System.out.println("Resposta invalida! ");
                System.exit(0);
                return false;
        }
    }

    /**
     * Obtém a jogada do jogador, filtra e dispara métodos para pausa, retorno e encerramento do jogo.
     * Repassa para outra classe disparar os respectivos métodos para manipular o tabuleiro.
     * @param jogada é a informação da jogada/instrução do jogador.
     */
    public void obterJogada(String jogada) {
        if (jogada == null || jogada.isEmpty()) {
            System.out.println("Resposta inválida! Siga os comandos.");
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
                System.exit(0);
                break;
            default:
                if (jogada.length() == 2 && Character.isLetter(jogada.charAt(0)) && Character.isDigit(jogada.charAt(1))) {
                    try {
                        char letra = jogada.charAt(0);
                        int numero = Character.getNumericValue(jogada.charAt(1));

                        partidaModelo.getListaJogadas().add(new JogadaModelo(letra, numero));
                        for ( int i=0;i<partidaModelo.getListaJogadas().size();i++)
                        {
                            System.out.println(partidaModelo.getListaJogadas().get(i).getMovimento());
                            System.out.println(partidaModelo.getListaJogadas().get(i).getQuantidade());
                            partidaModelo.getListaJogadas().get(i).executar();
                        }
                        outputController.exibirTabuleiro();
                        outputController.repetir();
                    } catch (Exception e) {
                        System.out.println("Erro ao processar a jogada: " + e.getMessage());
                    }
                } else {
                    System.out.println("JogadaModelo inválida! Use o formato LetraNúmero (ex: A4).");
                }
                break;
        }
    }
}