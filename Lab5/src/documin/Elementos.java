package documin;

/**
 * Interface dos elementos
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public interface Elementos {
	
	/**
	 * Generalização da representação completa do elemento
	 * @return representação completa do elemento
	 */
	public String generateRepresentacaoCompleta();
	
	/**
	 * generalização da representação resumida do elemento
	 * @return representação resumida do elemento
	 */
	public String generateRepresentacaoResumida();
	
	/**
	 * generalização que pega a prioridade do elemento
	 * @return a prioridade do elemento
	 */
	public int getPrioridade();
	
	/**
	 * generalização que pega o valor do elemento
	 * @return o valor do elemento
	 */
	public String getValor();
	
	
}
