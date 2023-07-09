package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class TesteDocumentoController {

	
	private DocumentoController controller1;
	@BeforeEach
	void inicia() {
		
		this.controller1 = new DocumentoController();
		this.controller1.criarDocumento("Teste");
		this.controller1.criarDocumento("Teste2", 2);
		this.controller1.criarDocumento("Teste3");
		
		new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");

		new Termos("Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		
		new Texto("Exemplo de texto", 3);
		
		new Titulo(3, "Documentos Texto", 1, true);

	}
	
	@Test
	void testConstrutor() { 
		this.controller1.criarDocumento("Teste");
		this.controller1.criarDocumento("Test2", 2);
	}
	
	@Test
	void testCriarListaDocumento() { 
		this.controller1.addLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		String saida = "- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarTermosDocumento() {
		this.controller1.addTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		String saida = "Total termos: 3\n"
				+ "-Aleatórios, termos, Teste";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarTextoDocumento() {
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		String saida = "Exemplo de texto";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarTituloDocumento() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		String saida = "3. Documentos Texto -- 3-DOCUMENTOSTEXTO";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testAdicionarElementoJaCadastrado() {
		assertFalse(this.controller1.criarDocumento("Teste"));
		assertFalse(this.controller1.criarDocumento("Teste2", 2));
	}
	
	@Test
	void testMoverParaCimaLimiteInferior() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaCima("Teste2", 0);
		assertFalse(saida);
	}
	
	@Test
	void testMoverParaCima() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaCima("Teste2", 1);
		assertTrue(saida);
	}
	
	@Test
	void testMoverParaBaixoLimiteSuperior() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaBaixo("Teste2", 1);
		assertFalse(saida);
	}
	
	
	@Test
	void testMoverParaBaixoLimite() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaBaixo("Teste2", 0);
		assertTrue(saida);
	}
	
	@Test
	void testContarElementos() {
		assertEquals(0, controller1.contarElementos("Teste2"));
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		assertEquals(1, controller1.contarElementos("Teste2"));
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		assertEquals(2, controller1.contarElementos("Teste2"));
	}
	
	@Test
	void testApagaElemento() {
		assertEquals(0, controller1.contarElementos("Teste2"));
		this.controller1.addTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		assertEquals(1, controller1.contarElementos("Teste2"));
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		assertEquals(2, controller1.contarElementos("Teste2"));

		assertTrue(this.controller1.apagarElemento("Teste2", 1));
		assertEquals(1, controller1.contarElementos("Teste2"));
		assertFalse(this.controller1.apagarElemento("Teste2", 2));
		assertEquals(1, controller1.contarElementos("Teste2"));
	}
	
	@Test
	void testApagaDocumento() {
		assertEquals(3, this.controller1.qtdDoc());
		this.controller1.removerDocumento("Teste2");
		assertEquals(2, this.controller1.qtdDoc());
	}
	
	@Test
	void testPegarRepresentacaoCompleta() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		String saida = "3. Documentos Texto -- 3-DOCUMENTOSTEXTO";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testPegarRepresentacaoResumida() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		String saida = "3. Documentos";
		assertEquals(saida, this.controller1.pegarRepresentacaoResumida("Teste2", 0));
	}
	
	@Test 
	void testExibirDocumento() {
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		String saida = "[3. Documentos Texto -- 3-DOCUMENTOSTEXTO\n"
				+ ", Exemplo de texto]";
		assertEquals(saida, Arrays.toString(this.controller1.exibirDocumento("Teste2")));
	}
	
	
	
	@Test
	void testCriarListaDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		try {
			this.controller1.addLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTermosDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		try {
			this.controller1.addTermos("Test2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTextoDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		try {
			this.controller1.addTexto("Test2", "Exemplo de texto", 3);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTituloDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		try {
			this.controller1.addTitulo("Test2", "Documentos Texto", 3, 1, true);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}

	@Test
	void testMoverParaBaixoTituloDocumentoNaoExistente() { 
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		String saida = "Titulo Inexistente";
		try {
			this.controller1.moverParaBaixo("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testMoverParaCimaTituloDocumentoNaoExistente() { 
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		String saida = "Titulo Inexistente";
		try {
			this.controller1.moverParaCima("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testPegarRepresentacaoCompletaTituloDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.pegarRepresentacaoCompleta("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testPegarRepresentacaoResumidaTituloDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.pegarRepresentacaoResumida("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}	
	
	@Test
	void testExibirDocumentoTituloDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.exibirDocumento("Test");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	
	@Test
	void testApagarElementoTituloDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.apagarElemento("Test", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarAtalhoDocTituloDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.criarAtalho("Test", "Teste");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarAtalhoDocReferenciadoTituloDocumentoNaoExistente() { 
		String saida = "Titulo Inexistente";
		this.controller1.addTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.criarAtalho("Teste", "Test");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarVisaoCompleta() { 
		this.controller1.addLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos"); 
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		String saida = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", Exemplo de texto]";
		this.controller1.criarVisaoCompleta("Teste2");
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}
	 
	@Test
	void testCriarVisaoCompletaException() {
		String saida = "Titulo Inexistente";
		try {
			this.controller1.criarVisaoCompleta("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
	}
	}
	
	@Test 
	void testCriarVisaoResumida() { 
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		this.controller1.addLista("Teste2", "/", 4, "-", "Exemplo / de uma lista / de 3 termos");
		this.controller1.addTitulo("Teste2", "Documentos Texto", 3, 1, true);
		String saida = "[Exemplo de texto\n"
				+ ", Exemplo / de uma lista / de 3 termos]";
		this.controller1.criarVisaoResumida("Teste2");
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}
	
	@Test
	void testCriarVisaoResumidaException() {
		String saida = "Titulo Inexistente";
		try {
			this.controller1.criarVisaoResumida("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
	}
	}
	
	@Test
	void criaAtalhoExceptionJaEhAtalho2() {
		this.controller1.criarAtalho("Teste", "Teste2");
		try {
			this.controller1.criarAtalho("Teste2", "Teste3");
		} catch (IllegalStateException ise) {
		}
	}
	
	@Test
	void criaAtalhoExceptionTemAtalhoArmazenado() {
		this.controller1.criarAtalho("Teste", "Teste2");
		try {
			this.controller1.criarAtalho("Teste3", "Teste");
		} catch (IllegalStateException ise) {
		}
	}
	
	
	@Test
	void testCriarVisaoPrioritaria() {
		this.controller1.addLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.controller1.addTexto("Teste2", "Exemplo de texto", 3);
		String saida = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", Exemplo de texto]";
		this.controller1.criarVisaoPrioritaria("Teste2", 3);
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}
	
	@Test
	void testCriarVisaoPrioritariaException() {
		String saida = "Titulo Inexistente";
		try {
			this.controller1.criarVisaoPrioritaria("Test2", 3);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}

	
	@Test
	void testCriarVisaoTitulo() {
		this.controller1.addTitulo("Teste2", "Teste p/ Documento", 3, 1, true);
		this.controller1.addTitulo("Teste2", "Documentos Texto", 4, 0, false);	
		String saida = "[3. Teste\n"
				+ ", 4. Documentos Texto]";
		this.controller1.criarVisaoTitulo("Teste2");
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}

	@Test
	void testCriarVisaoTituloException() {
		String saida = "Titulo Inexistente"; 
		try {
			this.controller1.criarVisaoTitulo("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testTituloVazio() {
		String saida = "Titulo Invalido";
		try {
			new Documentos("");
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage());
		}
	}
	
	@Test
	void testTituloVazioComTamanho() {
		String saida = "Titulo Invalido";
		try {
			new Documentos("", 10);
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage()); 
		}
	}
	
	@Test
	void testTituloEspacoComTamanho() {
		String saida = "Titulo Invalido";
		try {
			new Documentos("   ", 10);
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage());
		}
	}
	
	
	
	
}