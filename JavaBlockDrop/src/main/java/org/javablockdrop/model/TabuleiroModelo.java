package org.javablockdrop.model;

import org.javablockdrop.controller.OutputController;

import java.util.ArrayList;
import java.util.List;

public final class TabuleiroModelo {
    private static TabuleiroModelo instancia;
    private final int r = (int )(Math.random() * 6 + 0);

    private List<CoordenadaModelo> posicoesLista;

    public TabuleiroModelo(){
        posicoesLista = new ArrayList<>(64);
    }

    public static synchronized TabuleiroModelo getInstancia() {
        try {
            if (instancia == null) {
                instancia = new TabuleiroModelo();
            }
            return instancia;
        } catch (Exception e) {
            System.out.println("Erro ao retornar a instância: "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //isso inicializa a criacao do tabuleiro e cria sua composicao
    public void criarTabuleiro(){
        System.out.println("====== Tabuleiro ======");
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                String [][] posicao = new String[8][8];
                posicoesLista.add(new CoordenadaModelo(i,j));
            }
        }

        Peca p0= new Peca();
        switch (r) {
            case 0 -> p0.criarO();
            case 1 -> p0.criarJ();
            case 2 -> p0.criarL();
            case 3 -> p0.criarT();
            case 4-> p0.criarI();
            case 5 -> p0.criarS();
            case 6 -> p0.criarZ();
        }
        OutputController outputController= new OutputController();;

        outputController.exibirTabuleiro();
    }

    public List<CoordenadaModelo> getPosicoesLista() {return posicoesLista;}
    public void setPosicoesLista(List<CoordenadaModelo> posicoesLista) {this.posicoesLista = posicoesLista;}
}