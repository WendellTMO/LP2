package documin;

import java.util.*;
/**
 * Objeto atalho 
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Atalho extends ElementsAbstract {
	
	/**
	 * lista de elementos
	 */
	private List<Elementos> elementos;
	
	/**
	 * Construtor de atalho
	 * @param prioridade media da prioridade
	 * @param valor valor do documento que está sendo referenciado
	 * @param elementos coleção com os elementos filtrados
	 */
	public Atalho(int prioridade, String valor, List<Elementos> elementos) {
		super(valor, prioridade);
		this.elementos = elementos;
	}

	/**
	 * repreentaçãoo completa de elementos com sua respectiva prioridade
	 */
	@Override
	public String generateRepresentacaoCompleta() {
		String retorno = "";
		
		for (int i = 0; i < this.elementos.size() - 1; i++) {
			retorno += this.elementos.get(i).generateRepresentacaoCompleta() + "\n";
		}
		retorno += this.elementos.get(elementos.size() - 1).generateRepresentacaoCompleta();
		return retorno;
	}

	/**
	 * representação resumida de elementos com sua respectiva prioridade
	 */
	@Override
	public String generateRepresentacaoResumida() {
		String retorno = "";
		
		for (int i = 0; i < this.elementos.size() - 1; i++) {
			retorno += this.elementos.get(i).generateRepresentacaoResumida() + "\n";
		}
		retorno += this.elementos.get(elementos.size() - 1).generateRepresentacaoResumida();
		
		return retorno;
	}
	
	
	
}
