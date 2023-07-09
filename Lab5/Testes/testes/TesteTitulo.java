package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class TesteTitulo {

    private Titulo titulo1;
    private Titulo titulo2;

    @BeforeEach
    void setUp() {
        titulo1 = new Titulo(3, "Documentos Texto", 1, true); 
        titulo2 = new Titulo(4, "Elementos simples", 3, false); 
    }

    @Test
    void testGerarRepresentacaoCompletaLinkableTrue() {
        String expected = "1. Documentos Texto -- 1-DOCUMENTOSTEXTO";
        String actual = titulo1.generateRepresentacaoCompleta();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoCompletaLinkableFalse() {
        String expected = "3. Elementos simples";
        String actual = titulo2.generateRepresentacaoCompleta();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoResumidaLinkableTrue() {
        String expected = "1. Documentos";
        String actual = titulo1.generateRepresentacaoResumida();
        assertEquals(expected, actual);
    }

    @Test
    void testGerarRepresentacaoResumidaLinkableFalse() {
        String expected = "3. Elementos simples";
        String actual = titulo2.generateRepresentacaoResumida();
        assertEquals(expected, actual);
    }
}
