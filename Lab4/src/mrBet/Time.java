package mrBet;

/**
 * O sistema faz o registro do time que essa classe realiza a construção
 * 
 * @author Wendell Tomé Marinho OLiveira - 122110748
 *
 */
public class Time {
	
	/**
	 * Nome do time
	 */
	private String nome;
	
	/**
	 * Nome do mascote do time
	 */
	private String mascote;
	
	/**
	 * Código do time
	 */
	private String codigo;
	
	/**
	 * Construtor de time
	 * 
	 * @param codigo - Código do time
	 * @param nome - Nome do time
	 * @param mascote - Mascote do time
	 */
	public Time(String codigo, String nome, String mascote) {
		this.nome = nome;
		this.mascote = mascote;
		this.codigo = codigo;
	}

	/**
	 * Método para recuperar o nome do time
	 * 
	 * @return - Nome do time
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @return - Devolução de time em uma String no formato:
	 * 			" [CÓDIGO_TIME] NOME_TIME / MASCOTE_TIME "
	 */
	public String toString() {
		return "[" + codigo + "] " + nome + " / " + mascote;
	}
	
	
}
