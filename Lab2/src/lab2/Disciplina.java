package lab2;

import java.util.Arrays;

/**
 * Classe que irá analisar as notas do aluno em determinada
 * disciplina, fazendo o registro delas, e irá definir se o
 * aluno está aprovado ou reprovado nela.
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Disciplina {
	/**
	 * Define o nome da disciplina.
	 * 
	 * Atributo
	 */
	private String nomeDisciplina;
	
	/**
	 * Define as horas de estudo nessa disciplina.
	 * 
	 * Atributo
	 */
	private int horas = 0;
	
	/**
	 * Lista que será responsável por registrar as 4 notas.
	 * 
	 * Atributo
	 */
	private double[] valorNota = new double[] {0, 0, 0, 0};  
	
	/**
	 * Realiza o cálculo da média das notas registradas do aluno nessa disciplina.
	 * 
	 * @return um valor inteiro referente a média das notas.
	 */
	private double calculaMedia() {
		double soma = 0;
		for(int i = 0; i < 4; i++) {
			soma += valorNota[i];
		}
		double media = soma / 4;
		return media;
	}
	
	/**
	 * Define o nome da disciplina.
	 * 
	 * @param nomeDisciplina é o nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;	
	}
	
	/**
	 * Define o registro de horas nessa disciplina.
	 * 
	 * @param horas é a quantidade as horas de estudo na disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * Faz o cadastro no sistema da nota (1, 2, 3 ou 4) e o
	 * seu respectivo valor.
	 * 
	 * @param localNota define em qual local a nota será registrado dentro da lista.
	 * @param valorNota é o valor da nota de fato nessa disciplina.
	 */
	public void cadastraNota(int localNota, double valorNota) {
		this.valorNota[localNota - 1] = valorNota;	
	}
	
	
	/**
	 * Verifica com base no cálculo da média das notas, se o
	 * aluno está aprovado na disciplina.
	 * 
	 * @return Verdadeiro caso o aluno for aprovado. E Falso caso o aluno seja reprovado na disciplina.
	 */
	public Boolean aprovado() {
		if (calculaMedia() >= 7.0) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Resumo dos dados do aluno na disciplina, no formato:
	 * NOME_DISCIPLINA HORAS MÉDIA [AS 4 NOTAS] 
	 * 
	 * @return String com os dados do aluno nessa disciplina.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + calculaMedia() + " " + Arrays.toString(valorNota);
	}
}
