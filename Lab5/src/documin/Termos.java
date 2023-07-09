package documin;

import java.util.*;
/**
 * Elemento termos
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Termos extends ElementsAbstract{

	/**
	 * proriedades prorpriedades armazena os valores do termo dentro do hashmap
	 * 
	 */
	private Map<String, String> propriedades = new HashMap<String, String>();
	
	/**
	 * valor do termo em um Array
	 */
	private String[] valueArray;
	
	/**
	 * Construtor do termo por meio do valor, prioridade, separador e ordem
	 * @param valor valor do termo
	 * @param prioridade prioridade do termo
	 * @param separador separador do termo
	 * @param ordem ordem para fazer a ordenação do termo
	 */
	public Termos(String valor, int prioridade, String separador, String ordem) {
		super(valor, prioridade);
		this.valueArray = super.getValor().trim().replaceAll(" ", "").split(separador);
		this.propriedades.put("separador", separador);
		this.propriedades.put("ordem", ordem);
		
	}
	
	/**
	 * Método que gera a representação completa do termo
	 * 
	 * @return Representação completa do termo em uma string 
	 */
	@Override
	public String generateRepresentacaoCompleta() {
		ordena();
		String retorno = "-";
		for(int i = 0; i < qtdTermos(); i++) {
			if (i == qtdTermos() - 1) {
				retorno += this.valueArray[i];
			} else {
				retorno += this.valueArray[i] + ", ";
			}
			
		}
		
		return "Total termos: " + qtdTermos() + "\n" + retorno;
	}
	
	/**
	 * Mpetodo que gera a representação resumida do termo
	 * 
	 * @returnRepresentação resumida do termo em uma string
	 */
	@Override
	public String generateRepresentacaoResumida() {
		ordena();
		String separador = this.propriedades.get("separador");
		String retorno = "";
		
		for (int i = 0; i < qtdTermos(); i++) {
			if (i == qtdTermos() - 1) {
				retorno += this.valueArray[i];
			} else {
				retorno += this.valueArray[i] + " " + separador + " ";
			}
		}
		
		return retorno;
	}
	
	/**
	 * Conta quantidade de termos com base no valor
	 * @return a quantidade de termos como int
	 */
	private int qtdTermos() {
		String separador = this.propriedades.get("separador");
		int qtdTermos = super.getValor().split(separador).length;
		return qtdTermos;
	}
	
	/**
	 * realiza a ordenação do valor de acordo com a ordem especificada do termo
	 */
	private void ordena() {
		String ordem = this.propriedades.get("ordem");
		if (ordem.equals("TAMANHO")) {
			Arrays.sort(this.valueArray, new OrdemTamanho());
		} else if (ordem.equals("ALFABÉTICA")) {
			Arrays.sort(this.valueArray, new OrdemAlfabetica());
		}
	}
	
}
