package org.javablockdrop.model;

import java.util.ArrayList;
import java.util.List;

public final class Jogada {
    private static Jogada instancia;

    private char movimento;
    private int quantidade;

    private List<Jogada> passosJogadaJ;

    public Jogada() {
        passosJogadaJ = new ArrayList<>(100);
    }

    public Jogada(char movimento, int quantidade) {
        passosJogadaJ = new ArrayList<>(100);
        this.movimento = movimento;
        this.quantidade = quantidade;
    }

    public static synchronized Jogada getInstancia() {
        try {
            if (instancia == null) {
                instancia = new Jogada();
            }
            return instancia;
        } catch (Exception e) {
            System.out.println("Erro ao retornar a instância: "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public char getMovimento() {return movimento;}

    public int getQuantidade() {return quantidade;}
}