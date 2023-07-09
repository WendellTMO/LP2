package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class TesteTexto {
    
    private Texto texto1;
    private Texto texto2;

    @BeforeEach
    void setUp() {
        texto1 = new Texto("Exemplo1", 3);
        texto2 = new Texto("Exemplo2", 4);
    }

    @Test
    void testGerarRepresentacaoCompleta() {
        String expected = "Exemplo1";
        String actual = texto1.generateRepresentacaoCompleta();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoResumida() {
        String expected = "Exemplo2";
        String actual = texto2.generateRepresentacaoResumida();
        assertEquals(expected, actual);
    }
}
