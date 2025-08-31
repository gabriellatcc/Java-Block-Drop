package org.javablockdrop;
import org.javablockdrop.controller.OutputController;
import org.javablockdrop.model.TabuleiroModelo;

public class Main {
    public static void main(String[] args) {
        TabuleiroModelo.getInstancia();
        String preto="\u001b[30m";
        String brancoc="\u001b[47m";
        System.out.println(preto+brancoc+"testecor");
        String brancoe="\u001b[107m";
        System.out.println(preto+brancoe+"testecor\u001b[0m");
        OutputController informacoes= new OutputController();
        informacoes.saudar();
    }
}