package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class TesteAtalho {

	private DocumentoController controller;
	
	@BeforeEach
	void inicia() {
		this.controller = new DocumentoController();
		this.controller.criarDocumento("Teste");
		this.controller.criarDocumento("Teste2");
		this.controller.criarDocumento("Teste3");
		this.controller.criarDocumento("Teste4", 4);
		this.controller.addLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.controller.addTexto("Teste2", "Exemplo de texto", 4);
		this.controller.addTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");

	}
	
	@Test
	void testGetTituloReferenciada() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documentos documento = this.controller.getDocumento("Teste");
		Atalho atalho = documento.getAtalho(0);
		assertEquals("Teste2", atalho.getValor());
	}

	@Test
	void testMediaPrioridade() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documentos documento = this.controller.getDocumento("Teste2");
		assertEquals(3, documento.mediaDaPrioridade());
	}
	
	@Test
	void testRepresentacaoCompleta() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documentos documento = this.controller.getDocumento("Teste");
		Atalho atalho = documento.getAtalho(0);
		String saida = "- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ "Exemplo de texto";
		assertEquals(saida, atalho.generateRepresentacaoCompleta());
	}
	
	@Test 
	void testRepresentacaoResumida() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documentos documento = this.controller.getDocumento("Teste");
		Atalho atalho = documento.getAtalho(0);
		String saida = "Exemplo / de uma lista / de 3 termos\n"
				+ "Exemplo de texto";
		assertEquals(saida, atalho.generateRepresentacaoResumida());
	}
	
	@Test
	void criaAtalhos() {
		assertEquals(0, this.controller.criarAtalho("Teste", "Teste2"));
		assertEquals(1, this.controller.criarAtalho("Teste", "Teste3"));
	}
	
	@Test
	void criaAtalhoExceptionJaEhAtalho2() {
		this.controller.criarAtalho("Teste", "Teste2");
		try {
			this.controller.criarAtalho("Teste2", "Teste3");
		} catch (IllegalStateException ise) {
			
		}
	}
	
	@Test
	void criaAtalhoExceptionTemAtalhoArmazenado() {
		this.controller.criarAtalho("Teste", "Teste2");
		try {
			this.controller.criarAtalho("Teste3", "Teste");
		} catch (IllegalStateException ise) {
			
		}
	}
	
	
	

}