package mrBet;

import java.util.*;

/**
 * 
 * @author Wendell Tomé Marinho OLiveira - 122110748
 *
 */
public class Campeonato {
		
	/**
	 * Conjunto de times que vão ser registrados dentro desse campeonato
	 */
	private HashSet<Time> times;
	
	/**
	 * Nome do campeonato
	 */
	private String nome;
	
	/**
	 * Capacidade máxima de participantes nesse campeonato
	 */
	private int participantes;
	
	/**
	 * Construção do campeonato
	 * 
	 * @param nome - Nome do campeonato
	 * @param participantes - N° máximo de participantes desse campeonato
	 */
	public Campeonato(String nome, int participantes) {
		this.nome = nome;
		this.participantes = participantes;
		this.times = new HashSet<Time>();
	}
	
	/**
	 * Quantidade atual de times participantes do campeonato
	 * 
	 * @return - A quantidade de times jogando nesse campeonato
	 */
	public int tamanho() {
		return times.size();
	}
	
	/**
	 * Devolução da capacidade total de participantes nesse campeonato
	 * 
	 * @return - Número máximo de participantes nesse campeonato
	 */
	public int getParticipantes() {
		return participantes;
	}
	
	/**
	 * Devolução do nome do campeonato
	 * 
	 * @return - Nome do campeonato
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Inclusão do time nesse campeonato
	 * @param t - Time que estamos adicionando no campeonato
	 */
	public void incluirTimenoCamp(Time t) {
		times.add(t);
	}
	
	/**
	 * Verifica se determinado time está jogando nesse campeonato
	 * 
	 * @param time - Time que estamos verificando
	 * @return TRUE - Se o time joga nesse campeonato
	 * 		   FALSE - Caso ele não jogue
	 */
	public boolean existeTime(Time time) {
		return times.contains(time);
	}
	
	/**
	 * Representação do campeonato em String
	 * @return - Devolução das informações do campeonato em uma string no formato:
	 * 			" * NOME_CAMPEONATO - QTD_PARTICIPANTES / TOTAL_PARTICIPANTES "
	 */
	public String toString() {
		return "* " + nome + " - " + times.size() + "/" + participantes;
	}
}
