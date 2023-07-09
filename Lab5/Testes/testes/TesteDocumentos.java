package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.*;

class TesteDocumentos {
	private Documentos documento1;
	private Documentos documento2;
	private Lista lista1; 
	private Termos termo1;
	private Texto texto1;
	private Titulo titulo1;
	
	private Termos termo2;
	
	@BeforeEach
	void inicia() {
		
		this.documento1 = new Documentos("Teste");
		this.documento2 = new Documentos("Teste2", 2);
		new Documentos("Teste");
		
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
		this.documento1.addElemento(lista1);
		
		this.termo1 = new Termos("Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		this.documento1.addElemento(termo1);
		
		this.texto1 = new Texto("Exemplo de texto", 3);
		this.documento1.addElemento(texto1);
		
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, true);
		this.documento1.addElemento(titulo1);
		
		this.termo2 = new Termos("Teste / termos / Aleatórios", 3, "/", "TAMANHO");
		this.documento2.addElemento(termo2);
		
	}
	
	
	@Test
	void testLimiteTamanho() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false);
		int posicao = this.documento2.addElemento(titulo1);
		assertEquals(1, posicao);
		
		this.texto1 = new Texto("Exemplo de texto", 3);
		int posicao2 = this.documento2.addElemento(texto1);
		assertEquals(-2, posicao2);
	}
	
	@Test
	void testApagaElemento() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false);
		int posicao = this.documento2.addElemento(titulo1);
		assertEquals(1, posicao);
		
		this.documento2.apagarElemento(1);
		
		this.texto1 = new Texto("Exemplo de texto", 3);
		int posicao2 = this.documento2.addElemento(texto1);
		assertEquals(1,posicao2);
	}
	
	@Test
	void testApagaElementoNaoExistente() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false);
		int posicao = this.documento2.addElemento(titulo1);
		assertEquals(1, posicao);
		
		this.documento2.apagarElemento(1);
		boolean saida = this.documento2.apagarElemento(1);
		assertFalse(saida);

	}
	
	
	
	@Test
	void testMoverElementoUmaPosicaoAcima() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false);
		int posicao = this.documento2.addElemento(titulo1);
		boolean saida = this.documento2.moverParaCima(posicao);
		assertTrue(saida);
	}
	
	@Test
	void testMoverElementoUmaPosicaoAcimaLimiteInferior() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false);
		boolean saida = this.documento2.moverParaCima(0);
		assertFalse(saida);
	}
	
	
	@Test
	void testMoverElementoUmaPosicaoAbaixoLimiteSuperior() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false);
		int posicao = this.documento2.addElemento(titulo1);
		boolean saida = this.documento2.moverParaBaixo(posicao);
		assertFalse(saida);
	}
	
	@Test
	void testExibirDocumento() {
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
		this.documento2.addElemento(lista1);
		String saida = "[Total termos: 3\n" 
				+ "-Aleatórios, termos, Teste\n"
				+ ", - Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos"
				+ "]";
		assertEquals(saida, Arrays.toString(this.documento2.exibirDoc()));
	}
	

	@Test
	void testGerarRepresentacaoCompletaDeUmElemento() {
		String saida = "Total termos: 3\n" +
				"-Aleatórios, termos, Teste";
		assertEquals(saida, this.documento2.pegarRepresentacaoCompleta(0));
	}
	
	@Test
	void testGerarRepresentacaoResumidaDeUmElemento() {
		String saida = "Aleatórios / termos / Teste";
		assertEquals(saida, this.documento2.pegarRepresentacaoResumida(0));
	}
	
	

}

