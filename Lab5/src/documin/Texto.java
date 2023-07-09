package documin;
/**
 * 
 * Elemento texto
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Texto extends ElementsAbstract {

	/**
	 * Construção de um texto por meio da prioridade e valor
	 * @param valor valor do texto
	 * @param prioridade prioridade do texto
	 */
	public Texto (String valor, int prioridade) {
		super(valor, prioridade);
	}
	
	/**
	 * Gera representação completa do texto
	 * @return representação completa em String do texto
	 */
	public String generateRepresentacaoResumida() {
		return super.getValor();
	}
	
	/**
	 * Gera representação resumida do texto
	 * @return representação resumida em String do texto
	 */
	public String generateRepresentacaoCompleta() {
		return super.getValor();
	}
	
}
