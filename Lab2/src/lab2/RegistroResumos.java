package lab2;


/**
 * Classe que faz o registro de resumos a partir do tema e resumos registrados.
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */

public class RegistroResumos {
	
	/**
	 * Lista que irá conter os temas da disciplina.
	 * 
	 * Atributo
	 */
	private String[] tema;
	
	/**
	 * lista que irá conter os temas e resumos da disciplina.
	 * 
	 * Atributo
	 */
	private String[] temaNresumo;

	/**
	 * Índice para controle do registro de temas e resumos,
	 * para que quando o número máxima de registros seja 
	 * alcançado, ele consiga ser zerado novamente e sobreescrever
	 * aqueles que já estão registrados na classe.
	 * 
	 * Atributo
	 */
	private int indice = 0;
	
	/**
	 * Construtor responsável pelo tamanho máximo de registros
	 * que podemos realizar de Temas e Resumos no nosso sistema.
	 * 
	 * @param numeroDeResumos valor do limite de Temas e Resumos.
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.tema = new String[numeroDeResumos];
		this.temaNresumo = new String[numeroDeResumos];
	}
	
	/**
	 * Responsável por verificar se o limite de registro de resumos foi atingido.
	 * Caso atinja o limite ele irá zerar o índice para que o sistema sobreescreva
	 * os primeiros registros.
	 */
	private void limiteResumo() {
		if (this.indice == this.tema.length) {
			indice = 0;
		}
	}
	
	
	/**
	 * Responsável por ir registrando o tema e o resumo no sistema.
	 * O tema é guardado de maneira independente em uma lista dele. 
	 * E também é guardado o tema junto com seu respectivo resumo no formato:
	 * "TEMA: RESUMO_DO_TEMA"
	 * 
	 * @param tema é o tema que está sendo registrado na lista.
	 * @param resumo é o resumo do tema que está sendo registrado na lista.
	 */
	public void adiciona(String tema, String resumo) {
			limiteResumo();
			this.tema[indice] = tema;
			this.temaNresumo[indice] = tema + ": " + resumo;
			indice++;
	}
	
	/**
	 * Contador de temas e resumos que foram registrados no sistema.
	 * 
	 * @return o número de temas e resumos que estão guardados no sistema.
	 */
	public int conta() {
		int contaResumo = 0;
		for(int i = 0; i < this.tema.length; i++) {
			if (this.tema[i] == null) {
				break;
			}
			else {
				contaResumo++;
			}
		}
		return contaResumo;
	}
	
	/**
	 * Faz o retorno dos temas em conjunto com seus respectivos resumo, no formato:
	 * "TEMA: RESUMO_DO_TEMA"
	 * 
	 * @return uma lista contendo o tema e seu resumo.
	 */
	public String[] pegaResumos() {
		return this.temaNresumo;
	}
	
	/**
	 * Vericador responsável por encontrar determinado tema no sistema.
	 * 
	 * @param tema que estamos em busca dentro do sistema.
	 * @return Verdadeiro se o tema estiver no sistema. Falso caso não consiga encontrar o tema registrado no sistema.
	 */
	public Boolean temResumo(String tema) {
		for(int i = 0; i < conta(); i++) {
			if (this.tema[i].equals(tema)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Realização do resumo dos dados trabalhados e registrados dentro desse sistema, no formato:
	 * "- NUMERO_RESUMO resumo(s) cadastrado(s)
	 * 	- 'tema1' | 'tema2' | '...' | 'temaN' "
	 * 
	 * @return String com o resumo dos dados
	 */
	public String imprimeResumos() {
		String resumoTema = "";
		for(int i = 0; i < conta() - 1; i++) {
			resumoTema += this.tema[i] + " | ";
		}
		resumoTema += this.tema[conta() -1];
		
		return "- " + conta() + " resumo(s) cadastrado(s)" + "\n" + "- " + resumoTema;
	}
}
