package org.javablockdrop.model;

import org.javablockdrop.controller.OutputController;
import org.javablockdrop.model.abstraction.APeca;

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
        pecaAtiva = APeca.criarPecaAleatoria();
        pecaAtiva.definirCasas();

        OutputController outputController= new OutputController();

        outputController.exibirTabuleiro();
    }

    public APeca getPecaAtiva() {return pecaAtiva;}
    public void setPecaAtiva(APeca pecaAtiva) {this.pecaAtiva = pecaAtiva;}

    public List<CasaModelo> getListaCasas() {return listaCasas;}
    public void setListaCasas(List<CasaModelo> listaCasas) {this.listaCasas = listaCasas;}
}