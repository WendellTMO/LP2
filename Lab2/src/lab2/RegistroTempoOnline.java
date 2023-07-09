package lab2;

/**
 * Classe que tem o intuito de fazer o registro e o controle
 * de horas que o aluno tem dedicado em cada disciplina 
 * remota.
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class RegistroTempoOnline {
	/**
	 * tempo Define o registro do tempo gasto na disciplina.
	 * 
	 * Atributo
	 */
	private int tempo;
	
	/**
	 * meta Define as horas que precisam ser executadas nessa
	 * 		disciplina, caso não seja informada o padrão é 120.
	 * 
	 * Atributo
	 */
	private int meta = 120;
	
	/**
	 * registro Realiza a definição do nome da disciplina.
	 * 
	 * Atributo
	 */
	private String registro;
	
	/**
	 * Registro na classe do nome da disciplina e 
	 * da meta de tempo proposta para dedicar 
	 * nessa disciplina.
	 * 
	 * @param registro o nome da disciplina.
	 * @param meta o tempo que é necessário ser gasto na disciplina.
	 */
	public RegistroTempoOnline(String registro, int meta) {
		this.meta = meta;
		this.setRegistro(registro);
	}
	/**
	 * Registro na classe do nome da disciplina.
	 * 
	 * @param registro o nome da disciplina.
	 */
	public RegistroTempoOnline(String registro) {
		this.setRegistro(registro);
	}
	
	/**
	 * Registro do tempo já gasto nessa disciplina.
	 * 
	 * @param tempo valor do tempo já gasto na disciplina.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempo += tempo;
	}
	
	/**
	 * Verificador se o tempo já gasto atingiu o número
	 * de horas necessárias nessa disciplina.
	 * 
	 * @return verdadeiro se a meta proposta foi alcançada,
	 * 			falso caso contrário.
	 */
	public Boolean atingiuMetaTempoOnline() {
		if (tempo >= meta) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRegistro() {
		return registro;
	}

	/**
	 * 
	 * @param registro
	 */
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	/**
	 * Converte os dados analisados e trabalhados do registro
	 * em uma String que resume o nome da disciplina, o tempo 
	 * gasto e o número da meta proposta para ela. No formato:
	 *  "NOME_DA_DISCIPLINA TEMPO_GASTO/META_DA_DISCIPLINA"
	 *  
	 * @return String com os dados da disciplina.
	 */
	public String toString() {
		return this.registro + " " + this.tempo + "/" + this.meta;
	}
}
