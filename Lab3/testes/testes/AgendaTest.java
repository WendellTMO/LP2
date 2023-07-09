package testes;
import agenda.Agenda;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	
	private Agenda agenda = new Agenda();
	private Agenda agenda1;
	private Agenda agenda2;
	private Agenda agenda3;
	private Agenda agenda4;
	
	@BeforeEach
	public void startAgenda() {
	     this.agenda1 = new Agenda();
	     agenda1.cadastraContato(1, "Wendell", "Tomé", "8398857-7046");
	     
	     this.agenda2 = new Agenda();
	     agenda2.cadastraContato(1, "Primo", "Feio", "1010-1010");
	     agenda2.cadastraContato(2, "Primo", "Arrumadinho", "2020-2020");
	     agenda2.cadastraContato(3, "Primo", "MenosFeio", "3030-3030");
	     
	     this.agenda3 = new Agenda();
	     agenda3.cadastraContato(1, "Primo", "Feio", "1010-1010");
	     agenda3.cadastraContato(2, "Primo", "Arrumadinho", "2020-2020");
	     agenda3.cadastraContato(3, "Primo", "MenosFeio", "3030-3030");
	     
	     this.agenda4 = new Agenda();
	     agenda4.cadastraContato(1, "Primo", "Feio", "1010-1010");
	     agenda4.cadastraContato(2, "Primo", "Arrumadinho", "2020-2020");

	}
	

	@Test
	void testAllContatos() {
			assertEquals("1 - Wendell Tomé\n", agenda1.allContatos());
	}
	
	
	@Test
	void testAllContatosTres() {
		assertEquals("1 - Primo Feio\n" + 
					 "2 - Primo Arrumadinho\n" +
					 "3 - Primo MenosFeio\n", agenda2.allContatos());
	}
	
	@Test
	void testAllContatosVazio() {
		assertEquals("", agenda.allContatos());
	}
	
	@Test
	void TestAllContatosFavorito() {
		agenda2.cadastraFavorito(1, 1);
		assertEquals("1 - ❤️ Primo Feio\n" + 
				 "2 - Primo Arrumadinho\n" +
				 "3 - Primo MenosFeio\n", agenda2.allContatos());
	}

	@Test
	void testPuxarContato() {
		agenda.cadastraContato(1, "Wendell", "Marinho", "4002-8922");
		assertEquals("Wendell Marinho\n"
				   + "4002-8922", agenda.puxarContato(1));
	}
	
	@Test
	void testPuxarContatoLimiteSuperior() {
		assertThrows(IndexOutOfBoundsException.class, () -> agenda.puxarContato(101));
	}
	
	@Test
	void testPuxarContatoLimiteInferior() {
		assertThrows(IndexOutOfBoundsException.class, () -> agenda.puxarContato(0));
	}
	
	@Test
	void testPuxarContatoVazio() {
		assertThrows(NullPointerException.class, () -> agenda.puxarContato(100));
	}
	
	@Test
	void testPuxaContatoFavorito() {
		String msg = "❤️ Wendell Tomé\n" + "8398857-7046";
		agenda1.cadastraFavorito(1, 1);
		assertEquals(msg, agenda1.puxarContato(1));
	}
	
	@Test
	void testCadastraContato() {
		assertEquals("CADASTRO REALIZADO!", agenda.cadastraContato(1, "Wendell", "Marinho", "4002-8422"));
	}
	
	@Test
	void testCadastraContatoJaExiste() {
		agenda.cadastraContato(1, "Jonatas", "Corinthiano", "0000-0000");
		assertEquals("CADASTRO REALIZADO!", agenda.cadastraContato(1, "Wendell", "Marinho", "4002-8422"));
	}
	
	@Test
	void testJahCadastrado() {
		agenda.cadastraContato(1, "Wendell", "SãoPaulino", "30940909");
		assertEquals("CONTATO JÁ CADASTRADO!", agenda.cadastraContato(3, "Wendell", "SãoPaulino", "30940909"));
	}
	
	@Test
	void testPosicaoLimiteSuperior() {
		assertEquals("CADASTRO REALIZADO!", agenda.cadastraContato(100, "Wendell", "SãoPaulino", "30940909"));
	}
	
	@Test
	void testPosicaoAcimaDoLimiteSuperior() {
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.cadastraContato(101, "Wendell", "SãoPaulino", "30940909"));
	}
	
	@Test
	void testPosicaoLimiteInferior() {
		assertEquals("CADASTRO REALIZADO!", agenda.cadastraContato(1, "Wendell", "SãoPaulino", "30940909"));
	}
	
	@Test
	void testPosicaoAbaixoDoLimiteInferior() {
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.cadastraContato(0, "Wendell", "SãoPaulino", "30940909"));
	}
	
	@Test
	void testNomeVazio() {
		assertEquals("CONTATO INVÁLIDO", agenda.cadastraContato(1, "", "SãoPaulino", "30940909"));
	}
	
	@Test
	void testTelefoneVazio() {
		assertEquals("CONTATO INVÁLIDO", agenda.cadastraContato(1, "Wendell", "SãoPaulino", ""));
	}

	@Test
	void testListaFavoritos() {
		agenda3.cadastraFavorito(1, 1);
		agenda3.cadastraFavorito(2, 5);
		assertEquals("1 - ❤️ Primo Feio\n" + 
				 	 "5 - ❤️ Primo Arrumadinho\n", agenda3.listaFavoritos());
	}
	
	void testListaFavoritosVazio() {
		assertEquals("", agenda3.listaFavoritos());
	}

	@Test
	void testCadastraFavorito() {
		assertEquals("CADASTRO FAVORITADO NA POSIÇÃO 1", agenda4.cadastraFavorito(1, 1));
	}
	
	@Test
	void testCadastraFavoritoPosicaoFavoritoLimiteInferior() {
		assertEquals("POSIÇÃO DE FAVORITO INVÁLIDA", agenda4.cadastraFavorito(1, 0));
	}
	
	@Test
	void testCadastraFavoritoPosicaoFavoritoLimiteSuperior() {
		assertEquals("POSIÇÃO DE FAVORITO INVÁLIDA", agenda4.cadastraFavorito(1, 11));
	}
	
	@Test
	void testCadastraFavoritoPosicaoContatoLimiteInferior() {
		assertEquals("POSIÇÃO DE CONTATO INVÁLIDA", agenda4.cadastraFavorito(0, 1));
	}
	
	@Test
	void testCadastraFavoritoPosicaoContatoLimiteSuperior() {
		assertEquals("POSIÇÃO DE CONTATO INVÁLIDA", agenda4.cadastraFavorito(101, 1));
	}
	
	@Test
	void testCadastraFavoritoPosicaoContatoNull() {
		assertEquals("CONTATO INVÁLIDO", agenda4.cadastraFavorito(10, 1));
	}


	@Test
	void testRemoveFavorito() {
		agenda4.cadastraFavorito(2, 3);
		String msg = "❤️ Primo Arrumadinho\n" + "2020-2020";
		assertEquals(msg, agenda4.puxarContato(2));
		
		agenda4.removeFavorito(3);
		String msg1 = "Primo Arrumadinho\n" + "2020-2020";
		assertEquals(msg1, agenda4.puxarContato(2));
	}
	
	void testRemoveFavoritoAbaixo() {
		assertThrows(IndexOutOfBoundsException.class, () -> agenda4.removeFavorito(-1));
	}
	
	void testRemoveFavoritoAcima() {
		assertThrows(IndexOutOfBoundsException.class, () -> agenda4.removeFavorito(11));
	}
	
	void testRemoveFavoritoNull() {
		assertThrows(IllegalArgumentException.class, () -> agenda4.removeFavorito(10));
	}

	
	
}
