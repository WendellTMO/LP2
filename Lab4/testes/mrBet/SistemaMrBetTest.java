package mrBet;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaMrBetTest {
	private SistemaMrBet mrBet1;

	@BeforeEach
	void setUp() throws Exception {
		this.mrBet1 = new SistemaMrBet();
		mrBet1.incluirTime("250_PB", "Nacional de Patos", "Canário");
		mrBet1.incluirTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mrBet1.incluirTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		mrBet1.incluirTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}

	@Test
	void testAdicionarCampeonato() {
		assertEquals("CAMPEONATO ADICIONADO!", mrBet1.adicionarCampeonato("Brasileirão série A 2023", 0));
		assertEquals("CAMPEONATO JÁ EXISTE!", mrBet1.adicionarCampeonato("Brasileirão série A 2023", 0));
	}

	@Test
	void testIncluirTimeCampeonato() {
		mrBet1.adicionarCampeonato("Brasileirão série A 2023", 5);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO", mrBet1.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO", mrBet1.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO", mrBet1.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"));
		
		assertEquals("TIME NÃO EXISTE!", mrBet1.incluirTimeCampeonato("005_PB", "Brasileirão série A 2023"));
		
		assertEquals("CAMPEONATO NÃO EXISTE!", mrBet1.incluirTimeCampeonato("252_PB", "Brasileirão série D 2023"));
	}
	
	@Test
	void testIncluirTimeCampeonatoLimite() {
		mrBet1.adicionarCampeonato("Brasileirão série A 2023", 1);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO", mrBet1.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", mrBet1.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"));
	}

	@Test
	void testLimiteCampeonato() {
		mrBet1.adicionarCampeonato("Brasileirão série A 2023", 2);
		mrBet1.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		assertFalse(mrBet1.limiteCampeonato("Brasileirão série A 2023"));
		
		mrBet1.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertTrue(mrBet1.limiteCampeonato("Brasileirão série A 2023"));
	}

	@Test
	void testVerificarTimeCampeonato() {
		
		mrBet1.adicionarCampeonato("Copa do Nordeste 2023", 3);
		mrBet1.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", mrBet1.verificarTimeCampeonato("250_PB", "Copa do Nordeste 2023"));

		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", mrBet1.verificarTimeCampeonato("252_PB", "Copa do Nordeste 2023"));
		
		assertEquals("CAMPEONATO NÃO EXISTE!", mrBet1.verificarTimeCampeonato("252_PB", "Brasileirão série D 2023"));
		assertEquals("TIME NÃO EXISTE!", mrBet1.verificarTimeCampeonato("005_PB", "Copa do Nordeste 2023"));
	}

	@Test
	void testCriaAposta() {
		mrBet1.adicionarCampeonato("Copa do Nordeste 2023", 10);
		assertEquals("TIME NÃO EXISTE!", mrBet1.criaAposta("005_PB", "Copa do Nordeste 2023", 2, 50.00));
		assertEquals("CAMPEONATO NÃO EXISTE!", mrBet1.criaAposta("250_PB", "Copa de Recife 2024", 2, 50.00));
		
		assertEquals("APOSTA REGISTRADA!", mrBet1.criaAposta("252_PB", "Copa do Nordeste 2023", 2, 50.00));
		assertEquals("APOSTA REGISTRADA!", mrBet1.criaAposta("252_PB", "Copa do Nordeste 2023", 10, 50.00));
		
		assertEquals("APOSTA NÃO REGISTRADA!", mrBet1.criaAposta("252_PB", "Copa do Nordeste 2023", 15, 50.00));
	}
	
	@Test
	void testHistoricoResumo() {
		
		mrBet1.adicionarCampeonato("Paraibano 2020", 50);
		mrBet1.incluirTimeCampeonato("002_RJ", "Paraibano 2020");
		mrBet1.incluirTimeCampeonato("252_PB", "Paraibano 2020");
		
		mrBet1.adicionarCampeonato("Paraibano 2021", 50);
		mrBet1.incluirTimeCampeonato("002_RJ", "Paraibano 2021");
		mrBet1.incluirTimeCampeonato("252_PB", "Paraibano 2021");
		
		mrBet1.adicionarCampeonato("Paraibano 2022", 50);
		mrBet1.incluirTimeCampeonato("002_RJ", "Paraibano 2022");
		
		mrBet1.criaAposta("002_RJ", "Paraibano 2020", 1, 50.00);
		mrBet1.criaAposta("002_RJ", "Paraibano 2021", 1, 50.00);
		mrBet1.criaAposta("252_PB", "Paraibano 2020", 1, 50.00);
		mrBet1.criaAposta("252_PB", "Paraibano 2021", 2, 50.00);
		
		assertEquals("Participação mais frequente em campeonatos\n"
				+ "[002_RJ] Clube de Regatas do Flamengo / Urubu\n"
				+ "\nAinda não participou de campeonato\n"
				+ "[105_PB] Sociedade Recreativa de Monteiro (SOCREMO) / Gavião\n"
				+ "[250_PB] Nacional de Patos / Canário\n"
				+ "\nPopulariedade em apostas\n"
				+ "Sport Lagoa Seca / 1\n"
				+ "Clube de Regatas do Flamengo / 2\n", mrBet1.historicoResumo());
		
		mrBet1.incluirTimeCampeonato("252_PB", "Paraibano 2022");
		assertEquals("Participação mais frequente em campeonatos\n"
				+ "[252_PB] Sport Lagoa Seca / Carneiro\n"
				+ "[002_RJ] Clube de Regatas do Flamengo / Urubu\n"
				+ "\nAinda não participou de campeonato\n"
				+ "[105_PB] Sociedade Recreativa de Monteiro (SOCREMO) / Gavião\n"
				+ "[250_PB] Nacional de Patos / Canário\n"
				+ "\nPopulariedade em apostas\n"
				+ "Sport Lagoa Seca / 1\n"
				+ "Clube de Regatas do Flamengo / 2\n", mrBet1.historicoResumo());
		
	}

	

}
