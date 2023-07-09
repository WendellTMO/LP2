package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class TesteLista {

    private Lista lista1;
    @BeforeEach
    void setUp() {
        lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
        new Lista(2, "Teste | termos | Aleatórios", "|", "-");
    }

    @Test
    void testGerarRepresentacaoCompleta() {
        String expected = "- Exemplo\n" +
                          "- de uma lista\n" +
                          "- de 3 termos";
        String actual = lista1.generateRepresentacaoCompleta();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoResumida() {
        String expected = "Exemplo / de uma lista / de 3 termos";
        String actual = lista1.generateRepresentacaoResumida();
        assertEquals(expected, actual);
    }
}
