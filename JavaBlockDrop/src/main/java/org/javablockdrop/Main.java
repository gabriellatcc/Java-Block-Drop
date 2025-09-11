package org.javablockdrop;
import org.javablockdrop.controller.InputController;
import org.javablockdrop.controller.OutputController;
import org.javablockdrop.model.PartidaModelo;

public class Main {
    public static void main(String[] args) {
        PartidaModelo partida = PartidaModelo.getInstancia();
        OutputController outputController = new OutputController();
        InputController inputController = new InputController();

        outputController.setInputController(inputController);
        inputController.setOutputController(outputController);

        outputController.saudar();
    }
}