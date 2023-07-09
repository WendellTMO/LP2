package mrBet;

import java.util.*;
import java.util.Map.Entry;

/**
 * Sistema de aposta que realiza o registro de times e campeonatos, além de realizar a aposta em determinado time dentro de determinado campeonato
 * 
 * @author Wendell Tomé Marinho OLiveira - 122110748
 *
 */
public class SistemaMrBet {

	/**
	 * Conjunto de times que associa elementos "ID DO TIME" ao respectivo valor de Time
	 */
	private HashMap<String, Time> mapaTimes = new HashMap<>();
	
	/**
	 * Conjunto de times que associa elementos "NOME DO CAMPEONATO" ao respectivo valor do Campeonato
	 */
	private HashMap<String, Campeonato> mapaCampeonatos = new HashMap<>();
	
	
	/**
	 * Lista de Apostas ordenadas registradas no sistema
	 */
	private ArrayList<Aposta> listaApostas = new ArrayList<Aposta>();
	
	
	/**
	 * Construtor da classe sistema 
	 */
	public SistemaMrBet() {
		
	}
	
	/**
	 * Realiza a inclusão do time no sistema, 
	 * 
	 * @param codigo - Codigo do time que irá referenciar ele dentro do código
	 * @param nome - O nome do time que está sendo registrado no sistema
	 * @param mascote - O nome do mascote que estamos registrando no sistema
	 * @return "TIME JÁ EXISTE" - Caso o time já esteja inluso no sistema.
	 * 			"INLUSÃO REALIZADO" - Caso o time seja incluido no sistema
	 */
	public String incluirTime(String codigo, String nome, String mascote) {
		
		if (timeNoSistema(codigo)) {
			return "TIME JÁ EXISTE!";
		}
		
		Time t = new Time(codigo, nome, mascote);
		this.mapaTimes.put(codigo, t);
		return "INCLUSÃO REALIZADA!";
			
	}
	
	/**
	 * Irá pegar o determinado time que o usuário solicitou, e devolver as informações dele
	 * @param codigo - Código que irá referenciar de qual time iremos pegar as informações
	 * @return - String representando a informação do time. No formato:
	 * 				[CÓDIGO TIME] - NOME_DO_TIME / MASCOTE_DO_TIME
	 */
	public String recuperaTime(String codigo) {
		if (timeNoSistema(codigo)) {
			Time t = mapaTimes.get(codigo);
			return t.toString();
			
		} else {
			return "TIME NÃO EXISTE!";
		}
	}
	
	/**
	 * Realiza a adição do campeonato no sistema
	 * 
	 * @param campeonato - Nome do campeonato
	 * @param participantes - Número de participantes do campeonato
	 * @return - Status do campeonato, se ele foi adicionado ou se ele já está registrado dentro do sistema
	 */
	public String adicionarCampeonato(String campeonato, int participantes) {
		
		if(campeonatoNoSistema(campeonato)) {
			return "CAMPEONATO JÁ EXISTE!";
		} 
		
		Campeonato c = new Campeonato(campeonato, participantes);
		this.mapaCampeonatos.put(campeonato.toLowerCase(), c);
		return "CAMPEONATO ADICIONADO!";
		
	}

	/**
	 * Faz a inclusão de um time já registrado dentro de um campeonato
	 * 
	 * @param codigo - O codigo que irá referenciar o time que será registrado dentro do campeonato
	 * @param campeonato - O campeonato no qual o time será inserido dentro
	 * @return - O status da inclusão do time, se foi adicionado com sucesso ou se falhou
	 */
	public String incluirTimeCampeonato(String codigo, String campeonato) {
		
		Campeonato c = mapaCampeonatos.get(campeonato.toLowerCase());
		Time t = mapaTimes.get(codigo);
		
		if (!timeNoSistema(codigo)) {
			return "TIME NÃO EXISTE!";
		}
		
		if(!campeonatoNoSistema(campeonato)) {
			return "CAMPEONATO NÃO EXISTE!";
		}
		
		if(limiteCampeonato(campeonato.toLowerCase())) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}
		
		if (sistemaExisteTimeCamp(codigo, campeonato)) {
			return "TIME INCLUÍDO NO CAMPEONATO";
		}
		
		c.incluirTimenoCamp(t);

		
		return "TIME INCLUÍDO NO CAMPEONATO";
	}
	

	/**
	 * Método privado que verifica se determinado time está dentro de determinado campeonato
	 * 
	 * @param codigo - O time que desejamos encontrar
	 * @param campeonato - O campeonato que estamos verificando
	 * @return TRUE - Caso o time exista dentro do campeonato
	 * 		   FALSE - Caso contrário.
	 */
	private boolean sistemaExisteTimeCamp(String codigo, String campeonato) {
		Campeonato c = mapaCampeonatos.get(campeonato.toLowerCase());
		Time t = mapaTimes.get(codigo);
		
		return c.existeTime(t);
	}
	
	/**
	 * Método para verificar se o limite de participantes do campeonato foi atingido
	 * 
	 * @param campeonato - O Campeonato que estamos verificando o limite
	 * @return TRUE - Se o limite foi atingido
	 * 			FALSE - Caso contrário.
	 */
	public boolean limiteCampeonato(String campeonato) {
		Campeonato c = mapaCampeonatos.get(campeonato.toLowerCase());
		if (c.getParticipantes() == c.tamanho()) {
			return true;
		}
		return false;
	}

	/**
	 * Método público que pede a verificação para o metódo privado "sistemaExisteTimeCamp" 
	 * e que retorna uma string com o determinado status.
	 * 
	 * @param codigo - Time que estamos verificando
	 * @param campeonato - Campeonato utilizado para buscar se contém o time
	 * @return String de acordo com o STATUS da verificação
	 */
	public String verificarTimeCampeonato(String codigo, String campeonato) {
		if (!timeNoSistema(codigo)) {
			return "TIME NÃO EXISTE!";
		}
		
		if(!campeonatoNoSistema(campeonato)) {
			return "CAMPEONATO NÃO EXISTE!";
		}
		
		if (sistemaExisteTimeCamp(codigo, campeonato)) {
			return "O TIME ESTÁ NO CAMPEONATO!";
		}
		return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		
	}
	
	
	/**
	 * Exibição dos campeonatos que o time participa
	 * 
	 * @param codigo - Time que desejamos ver os campeonatos que estão disputando
	 * @return String contendo os campeonatos que o time está participando, no formato:
	 * 			" Campeonatos do NOME_DO_TIME:
	 * 			  * NOME_DO_CAMPEONATO - PARTICIPANTES_ATUAIS / TOTAL_PARTICIPANTES "
	 * 		
	 */
	public String exibirTime(String codigo) {
		if (!timeNoSistema(codigo)) {
			return "TIME NÃO EXISTE";
		}
		Time t = mapaTimes.get(codigo);
		String retorno = "Campeonatos do " + t.getNome() + ":";
		
		for (Campeonato campeonato : this.mapaCampeonatos.values()) {
			if (campeonato.existeTime(t)) {
				retorno += "\n" + campeonato.toString();
			}
		}
		
		
		return retorno + "";
	}

	/**
	 * Criação de uma aposta em um time especifico em determinado campeonato, além de realizar
	 * seu registro no sistema
	 * 
	 * @param codigo - Time que deseja realizar a aposta
	 * @param campeonato - Campeonato que deseja apostar
	 * @param colocacao - Colocação que está realizando a aposta no time em campeonato X
	 * @param valor - Valor da aposta
	 * @return Status da realização da aposta
	 */
	public String criaAposta(String codigo, String campeonato, int colocacao, double valor) {
		if (!timeNoSistema(codigo)) {
			return "TIME NÃO EXISTE!";
		}
		
		if(!campeonatoNoSistema(campeonato)) {
			return "CAMPEONATO NÃO EXISTE!";
		}
		
		Campeonato c = mapaCampeonatos.get(campeonato.toLowerCase());
		if(colocacao > c.getParticipantes()) {
			return "APOSTA NÃO REGISTRADA!";
		}
		
		Time t = mapaTimes.get(codigo);
		Aposta a = new Aposta(t, c, colocacao, valor);
		listaApostas.add(a);
		
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Listagem de todas apostas registradas no sistema
	 * 
	 * @return String com todas apostas no formato ordenado:
	 * 		"	Apostas:
	 * 			N°_APOSTA. [CÓDIGO_TIME] NOME_DO_TIME / MASCOTE_TIME
	 * 			NOME_CAMPEONATO
	 * 			COLOCAÇÃO_APOSTADA / TOTAL_PARTICIPANTES
	 * 			VALOR DA APOSTA "
	 * 
	 */
	public String listaApostas() {
		String retorno = "Apostas:" + "\n";
		int posi = 1;
		for (Aposta a : this.listaApostas) {
			retorno += posi +". " + a.toString() + "\n";
			posi++;
		}
		
		return retorno;
		
	}
	
	/**
	 * Metódo que realiza toda a construção de histórico, contendo time com
	 * participação mais frequente em campeonato, times que ainda não participaram
	 * de campeonatos e os times com a popularidade em apostas que estão colocados
	 * como 1° lugar
	 *  
	 * @return String contendo o resumo de histórico
	 */
	public String historicoResumo() {
		HashMap<Time, Integer> participaCampeonato = new HashMap<>();
		
		String retorno1 = "Participação mais frequente em campeonatos\n";
		String retorno2 = "Ainda não participou de campeonato\n";
		
		int maior_participacao = 0;
		for (Time t : this.mapaTimes.values()) {
			int participacao_time = 0;
			for (Campeonato campeonato : this.mapaCampeonatos.values()) {
				if (campeonato.existeTime(t)) {
					participacao_time++;
				}
			}
			if (maior_participacao < participacao_time) {
				maior_participacao = participacao_time;
			}
			participaCampeonato.put(t, participacao_time);
		}
		
		for (Entry<Time, Integer> entry : participaCampeonato.entrySet() ) {
			Time t = entry.getKey();
			if (entry.getValue() == maior_participacao) {
				retorno1 += t.toString() + "\n";
			} else if (entry.getValue() == 0) {
				retorno2 += t.toString() + "\n";
			}
		}
		
		String retorno3 = "Populariedade em apostas\n";
		
		HashMap<Time, Integer> pop_aposta = new HashMap<>();
		
		for (int i = 0; i < listaApostas.size(); i++ ) {
			Aposta a = listaApostas.get(i);
			if (a.getColocacao() == 1) {
				if (!pop_aposta.containsKey(a.getTeam())) {
					pop_aposta.put(a.getTeam(), 0);
				}
				
				int x = pop_aposta.get(a.getTeam()) + 1;
				pop_aposta.put(a.getTeam(), x);
			}
		}
		
		for (Entry<Time, Integer> entry : pop_aposta.entrySet()) {
			Time b = entry.getKey();
			retorno3 += b.getNome() + " / " + entry.getValue() + "\n";
		}
		
		return 	retorno1 + "\n" +
				retorno2 + "\n" +
				retorno3;
	}
	
	/**
	 * Metódo privado para verificar se determinado time está registrado no sistema
	 * 
	 * @param codigo - verificação se o time está registrado no sistema
	 * @return TRUE - Caso o time esteja registrado no sitstema
	 * 			FALSE - Caso contrário.
	 */
	private boolean timeNoSistema(String codigo) {
		return mapaTimes.containsKey(codigo);
	}
	
	
	/**
	 * Método privado para verificar se determinado campeonato está registrado no sistema
	 * 
	 * @param campeonato - O campeonato que estamos verificando
	 * @return True - Se o campeonato esteja registrado no sistema
	 * 			False - Caso contrário
	 */
	private boolean campeonatoNoSistema(String campeonato) {
		return mapaCampeonatos.containsKey(campeonato.toLowerCase());
	}
	
	
}
