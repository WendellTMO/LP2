package agenda;

import java.util.Objects;


/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Contato {
	

	/**
	 * Nome do contato.
	 */
	private String nome;
	
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;
	
	/**
	 * Telefone do contatao
	 */
	private String telefone;
	
	/**
	 * Se o contato está favoritado
	 */
	private Boolean favorito;

	/**
	 * Cria um contato
	 * 
	 * @param nome2 - nome do contato que está sendo criado 
	 * @param sobrenome - sobrenome do contato que está sendo criado
	 * @param telefone - telefone do contato que está sendo criado
	 */
	public Contato(String nome2, String sobrenome, String telefone) {
		this.nome = nome2;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.favorito = false;
	}

	/**
	 * Pega o nome do contato
	 * 
	 * @return o nome do contato
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Pega o sobrenome do contato
	 * 
	 * @return o sobrenome do contato
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Pega o telefone do contato
	 * 
	 * @return o telefone do contato 
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * Favorita o contato, transformando a base em boolean para true.
	 */
	public void ehFavorito() {
		this.favorito = true;
	}
	
	/**
	 * Desfavorita o contato, transformando a base em boolean para false.
	 */
	public void desFavorito() {
		this.favorito = false;
	}
	
	/**
	 * Pega o estado atual do contato
	 * 
	 * @return o valor desse contato em boolean
	 * 			True - está favoritado
	 * 			False - NÃO está favoritado
	 */
	public Boolean getFavorito() {
		return this.favorito;
	}
	
	/**
	 * Compara o Objeto passado como parâmetro com contato que chamou o metódo
	 * 
	 * @return True - se ele for igual
	 * 		   False - se ele não for igual
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	

	/**
	 * Cria a representação em String do contato.
	 * 
	 * @return retorna a representação em String do contato, no formato:
	 * 			"{CORAÇÃO, SE FOR FAVORITO} NOME_CONTATO SOBRENOME_CONTATO
	 * 			  TELEFONE_CONTATO"
	 * 
	 */
	@Override
	public String toString() {
		if (favorito) {
			return "❤️ " + nome + " " + sobrenome + "\n" + telefone; 
		}
		return nome + " " + sobrenome + "\n" + telefone;
	}

	
	
	
	
}
