package documin;

/**
 * Abstração de elementos
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public abstract class ElementsAbstract implements Elementos {

	/**	
	 * prioridade prioridade abstraída
	 */
	private int prioridade;
	/**
	 * valor valor abstraido
	 */
	private String valor;
	
	/**
	 * COnstrução da abstração de elementos por meio da prioridade e valor
	 * @param valor valor abstraído
	 * @param prioridade prioridade abstraída
	 */
	public ElementsAbstract(String valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
		
	}
	
	/**
	 * ABstração que gera a representação completa do elemento
	 * 
	 * @return A representação completa do elemento
	 */
	public abstract String generateRepresentacaoCompleta();
	
	/**
	 * Abstração que gera a representação resumida do elemento
	 * 
	 * @return A representação resumida do elemento
	 */
	public abstract String generateRepresentacaoResumida();
	
	/**
	 * pega a prioridade
	 * @return prioridade
	 */
	public int getPrioridade() {
		return this.prioridade;
	}
	
	/**
	 * pega o valor
	 * @return valor em string
	 */
	public String getValor() {
		return this.valor;
	}

}
