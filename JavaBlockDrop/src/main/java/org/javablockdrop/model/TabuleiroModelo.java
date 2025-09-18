package org.javablockdrop.model;

import org.javablockdrop.controller.OutputController;
import org.javablockdrop.model.abstraction.APeca;
import org.javablockdrop.model.enumeration.Cor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Classe que cria o tabuleiro e sua composição e a peca ativa.
 */
public class TabuleiroModelo {
    private List<CasaModelo> listaCasas;
    private APeca pecaAtiva;

    public TabuleiroModelo(){
        listaCasas = new ArrayList<>();
    }

    /**
     * Inicializa a criação do tabuleiro e cria sua composição com instancias da classe CasaModelo
     */
    public void criarTabuleiro(){
        System.out.println("====== Tabuleiro ======");
        int tamanhoTotalDoTabuleiro = 64;
        listaCasas.clear();
        ((ArrayList<CasaModelo>) listaCasas).ensureCapacity(tamanhoTotalDoTabuleiro);
        for(int i=0;i<tamanhoTotalDoTabuleiro;i++){
                CasaModelo casaModelo=new CasaModelo();
                casaModelo.setLinha(i);
                listaCasas.add(casaModelo);
        }
        pecaAtiva = APeca.criarPecaAleatoria();
        pecaAtiva.definirCasasOcupadas();

        new OutputController().exibirTabuleiro();
    }

    /**
     * Verifica todas as linhas do tabuleiro de baixo para cima, se encontrar uma linha completa,
     * ele a limpa, anima e desce as linhas superiores.
     */
    public int verificarEProcessarLinhasCompletas() {
        final int largura = 8;
        if (listaCasas.isEmpty() || listaCasas.size() % largura != 0) {
            return 0;
        }
        int altura = listaCasas.size() / largura;

        int linhasLimpas = 0;
        for (int linha = altura - 1; linha >= 0; linha--) {
            boolean linhaCompleta = true;
            for (int coluna = 0; coluna < largura; coluna++) {
                int indice = (linha * largura) + coluna;
                if (!listaCasas.get(indice).isOcupada()) {
                    linhaCompleta = false;
                    break;
                }
            }

            if (linhaCompleta) {
                linhasLimpas++;
                animarLinha(linha, largura);
                limparLinhaEDescer(linha, largura);
                linha++;
            }
        }
        return linhasLimpas;
    }

    /**
     * Pinta a linha completa com a cor PONTUADO e redesenha o tabuleiro.
     * @param linha o índice da linha a ser animada (0 a 7).
     */
    private void animarLinha(int linha, int largura) {
        for (int coluna = 0; coluna < largura; coluna++) {
            int indice = (linha * largura) + coluna;
            listaCasas.get(indice).setCor(Cor.PONTUADO.getDescricao());
        }

        new OutputController().exibirTabuleiro();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Rremove a linha, copiando o estado de todas as linhas de cima
     * para uma posição abaixo.
     * @param linhaApagada o índice da linha que foi completada.
     */
    private void limparLinhaEDescer(int linhaApagada, int largura) {
        for (int l = linhaApagada; l > 0; l--) {
            for (int c = 0; c < largura; c++) {
                int indiceAtual = (l * largura) + c;
                int indiceDeCima = ((l - 1) * largura) + c;

                CasaModelo casaAtual = listaCasas.get(indiceAtual);
                CasaModelo casaDeCima = listaCasas.get(indiceDeCima);

                casaAtual.setOcupada(casaDeCima.isOcupada());
                casaAtual.setCor(casaDeCima.getCor());
            }
        }

        for (int c = 0; c < 8; c++) {
            CasaModelo casaTopo = listaCasas.get(c);
            casaTopo.setOcupada(false);
            casaTopo.setCor(Cor.PADRAO.getDescricao());
        }
    }
    public APeca getPecaAtiva() {return pecaAtiva;}
    public void setPecaAtiva(APeca pecaAtiva) {this.pecaAtiva = pecaAtiva;}

    public List<CasaModelo> getListaCasas() {return listaCasas;}
    public void setListaCasas(List<CasaModelo> listaCasas) {this.listaCasas = listaCasas;}
}