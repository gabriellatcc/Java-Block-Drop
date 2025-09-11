package org.javablockdrop;
import org.javablockdrop.controller.OutputController;
import org.javablockdrop.model.PartidaModelo;

public class Main {
    public static void main(String[] args) {
        OutputController informacoes= new OutputController();
        informacoes.saudar();

        PartidaModelo partida = PartidaModelo.getInstancia();
        assert partida != null;
        partida.iniciarPartida();

        boolean jogoRodando = true;
        while (jogoRodando) {
            try {
                partida.atualizarCicloDoJogo();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("O loop de jogo foi interrompido.");
                jogoRodando = false;
            }
        }
        System.out.println("Fim de jogo!");
    }
}