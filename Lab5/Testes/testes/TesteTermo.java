package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class TesteTermo {

    private Termos termo1;
    private Termos termo2;
    private Termos termo3;

    @BeforeEach
    void setUp() {
        termo1 = new Termos("Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
        termo2 = new Termos("Teste / termos / Aleatórios", 2, "/", "NENHUM");
        termo3 = new Termos("asdas / Teste / termos / Aleatórios / Diferenciador", 4, "/", "TAMANHO");
    }

    @Test
    void testGerarRepresentacaoCompletaAlfabetica() {
        String expected = "Total termos: 3\n-Aleatórios, termos, Teste";
        String actual = termo1.generateRepresentacaoCompleta();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoResumidaAlfabetica() {
        String expected = "Aleatórios / termos / Teste";
        String actual = termo1.generateRepresentacaoResumida();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoCompletaTamanho() {
        String expected = "Total termos: 5\n-Diferenciador, Aleatórios, termos, asdas, Teste";
        String actual = termo3.generateRepresentacaoCompleta();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoResumidaTamanho() {
        String expected = "Diferenciador / Aleatórios / termos / asdas / Teste";
        String actual = termo3.generateRepresentacaoResumida();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoCompletaNenhuma() {
        String expected = "Total termos: 3\n-Teste, termos, Aleatórios";
        String actual = termo2.generateRepresentacaoCompleta();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoResumidaNenhuma() {
        String expected = "Teste / termos / Aleatórios";
        String actual = termo2.generateRepresentacaoResumida();
        assertEquals(expected, actual);
    }
}
