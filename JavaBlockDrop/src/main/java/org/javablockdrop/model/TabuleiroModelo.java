package org.javablockdrop.model;

import org.javablockdrop.controller.OutputController;
import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.implementation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cria o tabuleiro e sua composição e a peca ativa.
 */
public class TabuleiroModelo {
    private List<CasaModelo> listaCasas;
    private APeca pecaAtiva;

    public TabuleiroModelo(){
        listaCasas = new ArrayList<>(64);
    }

    /**
     * Método que inicializa a criação do tabuleiro e cria sua composição com instancias da classe CasaModelo
     */
    public void criarTabuleiro(){
        System.out.println("====== Tabuleiro ======");
        for(int i=0;i<64;i++){
                CasaModelo casaModelo=new CasaModelo();
                casaModelo.setLinha(i);
                listaCasas.add(casaModelo);
        }
        pecaAtiva = gerarPeca();
//        pecaAtiva.filtrar(pecaAtiva);

        OutputController outputController= new OutputController();

        outputController.exibirTabuleiro();
    }

    /**
     * Gera a peça a ser manipulada por meio de um numero aleatorio que cria uma peça aleatória, podendo ser
     * 0, I, L, J, T, S ou Z.
     * @return a peça.
     */
    public APeca gerarPeca() {
        int r = (int )(Math.random() * 6 + 0);

        APeca pecaEmMovimento;
        switch (r) {
            case 0:
                pecaEmMovimento =new PecaO();
                pecaEmMovimento.criar();
                return pecaEmMovimento;
            case 1:
                pecaEmMovimento =new PecaMultiL();
                pecaEmMovimento.criar();
                return pecaEmMovimento;
            case 2:
                pecaEmMovimento =new PecaMultiJ();
                pecaEmMovimento.criar();
                return pecaEmMovimento;
            case 3:
                pecaEmMovimento =new PecaMultiT();
                pecaEmMovimento.criar();
                return pecaEmMovimento;
            case 4:
                pecaEmMovimento =new PecaMultiZ();
                pecaEmMovimento.criar();
                return pecaEmMovimento;
            case 5:
                pecaEmMovimento =new PecaMultiS();
                pecaEmMovimento.criar();
                return pecaEmMovimento;
            case 6:
                pecaEmMovimento =new PecaMultiI();
                pecaEmMovimento.criar();
                return pecaEmMovimento;
            default:
                System.out.printf("Erro?");
                return null;
        }
    }

    public APeca getPecaAtiva() {return pecaAtiva;}
    public void setPecaAtiva(APeca pecaAtiva) {this.pecaAtiva = pecaAtiva;}

    public List<CasaModelo> getListaCasas() {return listaCasas;}
    public void setListaCasas(List<CasaModelo> listaCasas) {this.listaCasas = listaCasas;}
}