package documin;

import java.util.*;
/**
 * Elemento titulo
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Titulo extends ElementsAbstract {
	
	/**
	 * propriedades proriedades que irá armazenas os valores do título em um HashMap
	 */
	private Map<String, String> propriedades = new HashMap<String, String>();
	
	/**
	 * Construtor do elemento titulo com sua prioridade, seu valor, seu nivel e linkavel
	 * @param prioridade prioridade do titulo
	 * @param valor valor do titulo
	 * @param nivel nivel do titulo
	 * @param linkavel linkavel do titulo
	 */
	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(valor, prioridade);
		String levelString = String.valueOf(nivel);
		this.propriedades.put("nivel", levelString);
		String linkavelString = String.valueOf(linkavel);
		this.propriedades.put("linkavel", linkavelString);
	}
	
	/**
	 * Método que realiza a representação completa do titulo, vendo se ele é linkavel, caso seja irá fazer uma representação diferente caso não seja
	 * 
	 * @return uma representaçãoo completa em String do titulo
	 */
	public String generateRepresentacaoCompleta() {
		String linkavel = this.propriedades.get("linkavel");
		String nivel = this.propriedades.get("nivel");
		
		if(linkavel.equals("true")) {
			return nivel + ". " + super.getValor() + " -- " + nivel + "-" + super.getValor().replace(" ", "").toUpperCase();
		} else {
			return nivel + ". " + super.getValor();
		}
	}
	
	/**
	 * Método que realiza a representação resumida do titulo
	 * 
	 * @return representação resumida em String do titulo
	 */
	public String generateRepresentacaoResumida() {
		String linkavel = this.propriedades.get("linkavel");
		String nivel = this.propriedades.get("nivel");
		
		if (linkavel.equals("true")) {
			String first = super.getValor().split(" ")[0];
			return nivel + ". " + first;
		} else {
			return nivel + ". " + super.getValor();
		}
		
	}

}
