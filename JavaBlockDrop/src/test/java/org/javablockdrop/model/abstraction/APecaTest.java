package org.javablockdrop.model.abstraction;

import org.javablockdrop.model.enumeration.Cor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

interface APecaTest {
    int c4=0;
    Cor cor = null;
    
    @Test
    void definirCasas();

    @Test
    void movimentarD();

    @Test
    void movimentarE();

    @Test
    void descer();

    @Test
    void isEstadoAI();

    @Test
    void setEstadoAI();

    @Test
    void getC1();

    @Test
    void getC2();

    @Test
    void getC3();

    @Test
    void getC4();

    @Test
    void setC1();

    @Test
    void setC2();

    @Test
    void setC3();

    @Test
    void setC4();

    @Test
    void getCor();

    @Test
    void setCor();
}