package documin;
import java.util.*;
/**
 * Elemento Lista
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Lista extends ElementsAbstract {
	
	/**
	 * propriedades propriedades armazena os valores do termo dentro de um hashmap
	 */
	private Map<String, String> propriedades = new HashMap<String, String>();
	
	/**
	 * Construção da lista por meio da sua prioridade, do seu valor, do separador e caractere da lista
	 * @param prioridade prioridade da lista
	 * @param valor valor da lista
	 * @param separador separador da lista
	 * @param charLista charlista da lista
	 */
	public Lista(int prioridade, String valor, String separador, String charLista) {
		super(valor, prioridade);
		this.propriedades.put("charLista", charLista);
		this.propriedades.put("separador", separador);
	}

	/**
	 * Representação completa da lista
	 * 
	 * @return String contendo a representação completa da lista
	 */
	@Override
	public String generateRepresentacaoCompleta() {
		String separador = this.propriedades.get("separador");
		String charLista = this.propriedades.get("charLista");
		
		String retorno = "";
		String[] separando = super.getValor().split(" " + separador + " ");
		
		for (int i = 0; i < separando.length - 1; i++) {
			retorno += charLista + " " + separando[i] + "\n";
		}
		retorno += charLista + " " + separando[separando.length - 1];
		
		return retorno;
	
	}

	/**
	 * Representação resumida da lista
	 * 
	 * @return String contendo a representação resumida da lista
	 */
	@Override
	public String generateRepresentacaoResumida() {
		String separador = this.propriedades.get("separador");
		
		String retorno = "";
		String[] separando = super.getValor().split(" " + separador + " ");
		
		for (int i = 0; i < separando.length - 1; i++) {
			retorno += separando[i] + " " + separador + " ";
		}
		retorno += separando[separando.length - 1];
		
		return retorno;
	}
	
	
	

}
