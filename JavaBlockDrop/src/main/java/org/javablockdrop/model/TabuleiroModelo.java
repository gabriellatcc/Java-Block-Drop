package org.javablockdrop.model;
// para jogar, digite:
// pode rodar a peça para o sentido horario (RHN) e anti-horário (RAN) -> rodar no sentido x N numero de vezes
// pode ir para direita (DN) esquerda (EN) -> direcao x N numero de vezes
// pode pausar -> P
// voltar -> V

import java.util.ArrayList;
import java.util.List;

public final class TabuleiroModelo {
    private static TabuleiroModelo instancia;

    //atriputo posicoes composta por posicao modelo
    private List<PosicaoModelo> posicoesLista;

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
            System.out.println("Erro ao retornar a instância:"+e.getMessage());
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
                posicoesLista.add(new PosicaoModelo(i,j));
            }
        }

        //teste
//        posicoesLista.get(1).setOcupado(true);
//        System.out.println(posicoesLista.get(1).getComposicao());

        int r = (int )(Math.random() * 6 + 0);//0 a 6
        Peca p0= new Peca();
        switch (r) {
            case 0 -> p0.criarO();
            case 1 -> p0.criarJ();
            case 2 -> p0.criarL();
            case 3 -> p0.criarT();
            case 4-> p0.criarI();
            case 5 -> p0.criarS();
            case 6 -> p0.criarZ();
            default -> System.out.println("oii dei errado");
        }

        //isso é a impressao do tabuleiro, geracao de pecas vem antes disso
        for (int i = 0; i < posicoesLista.size(); i++) {
            System.out.print(posicoesLista.get(i).getComposicao() + " ");
            if ((i + 1) % 8 == 0) {
                System.out.println(Cor.RESETADO.getDescricao());
            }
        }
    }

    public void iniciarPartida(){
        //randomizar o aparecimento de uma peca, arrray talvez? array de 8 indices para 7 peças
        //a proxima peca não pode ser

    }
    public List<PosicaoModelo> getPosicoesLista() {return posicoesLista;}
    public void setPosicoesLista(List<PosicaoModelo> posicoesLista) {this.posicoesLista = posicoesLista;}
}