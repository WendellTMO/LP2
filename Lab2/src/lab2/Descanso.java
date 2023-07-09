package lab2;

/**
 * Classe que acompanha a rotina de descanso de determinado 
 * aluno no Controle Institucional da Situação Acadêmica. 
 * Assim, ele irá indicar se podemos considerar o aluno descansado,
 * com base nos atributos informados.
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Descanso {
	
	/**
	 * horas Define as horas de descanso do aluno.
	 * 
	 * Atributo 
	 */
	private int horas;
	
	/**
	 * semanas Define o tempo que o aluno está descansando
	 * 
	 * Atributo
	 */
	private int semanas = 1;
	
	/**
	 * Define a quantidade de horas de descanso do aluno.
	 * 
	 * @param horas
	 */
	public void defineHorasDescanso(int horas) {
			this.horas = horas;
	}
	
	/**
	 * Define o número de semanas que está sendo considerado. 
	 * 
	 * @param semanas
	 */
	public void defineNumeroSemanas(int semanas) {
			this.semanas = semanas;
	}
	
	/**
	 * Análise final do aluno, verificando se ele está cansado ou
	 * descansado. Consequentemente, retornando uma String de acordo
	 * com o estado final do aluno
	 * 
	 * @return a representação final da condição do aluno em String.
	 */
	public String getStatusGeral() {
		if((horas / semanas) >= 26)	{
			return "descansado";
			
		}
		return "cansado";
	}

}
