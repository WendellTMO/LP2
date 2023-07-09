package testes;
import agenda.Contato;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
	private Contato contatoBase1;
	private Contato contatoBase2;
	private Contato contatoBase3;
	private Contato contatoFavorito;

    @BeforeEach
    void preparaContatos() {
    	this.contatoBase1 = new Contato("Wendell", "Oliveira", "83 98857-7046");
        this.contatoBase2 = new Contato("Wendell", "Oliveira", "83 98857-7046");
    	this.contatoBase3 = new Contato("Wendell", "Lira", "555-5551");
    	this.contatoFavorito = new Contato("São Paulo", "Futebol Clube", "333-3333");
    }


	@Test
	void testEhFavorito() {
		contatoFavorito.ehFavorito();
		assertTrue(contatoFavorito.getFavorito());
	}

	@Test
	void testDesFavorito() {
		contatoFavorito.desFavorito();
		assertFalse(contatoFavorito.getFavorito());
	}

	@Test
	void testEqualsObject() {
		assertTrue(contatoBase1.equals(contatoBase2), "Esperando que dê verdadeiro");
		assertTrue(contatoBase2.equals(contatoBase1), "Esperando que dê verdadeiro");
		assertFalse(contatoBase1.equals(contatoBase3), "Esperando que dê falso");
	}
	
	@Test
	void testToString() {
		String msg = "Wendell" + " " + "Oliveira\n" + "83 98857-7046";
		assertEquals(msg, contatoBase1.toString());
	}
	
	@Test
	void testToStringFavorito() {
		contatoBase1.ehFavorito();
		String msg = "❤️ Wendell" + " " + "Oliveira\n" + "83 98857-7046";
		assertEquals(msg, contatoBase1.toString());
	}
	

}
