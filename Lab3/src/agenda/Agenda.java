package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	/**
	 * Array de contatos.
	 */
	private Contato[] contatos;

	/**
	 * Array dos contatos favoritados
	 */
	private Contato[] favoritos;

	
	/**
	 * Controle privado a respeito se já tem a existência de um contato com as mesmas característas
	 * do contato que estamos buscando colocar na lista.
	 * 
	 * @param nome - Nome do contato que estamos buscando analisar para verificar se ele já foi registrado.
	 * @param sobrenome - Sobrenome do contato que estamos buscando analisar para 
	 * @param type_contato - O tipo de lista que iremos analisar para verificar se já existe.
	 * @return True - Caso já exista esse contato temporário dentro do tipo de array varrido.
	 * 		   Falso - Caso NÃO exista esse contato temporário dentro do tipo de array varrido.	
	 */
	private Boolean existeContato(String nome, String sobrenome, Contato[] type_contato) {
		for (int i = 0; i < type_contato.length; i++) {
			if (type_contato[i] != null) {
				Contato temp_contato = new Contato(nome, sobrenome, "0");
				if(temp_contato.equals(type_contato[i])) {
					return true;
				}
			}
		}
		
		return false;
	}
	

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	private Contato[] getContatos() {
		return contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	private Contato getContato(int posicao) {
		return contatos[posicao];
	}
	
	/**
	 * Acessa todos os contatos que estão dentro do Array e formata ele.
	 * 
	 * @return retorno da lista de todos os contatos registrados no formato:
	 * 			"1 - {CORAÇÃO, CASO SEJA FAVORITO} NOME_CONTATO SOBRENOME_CONTATO
	 * 			 2 - {CORAÇÃO, CASO SEJA FAVORITO} NOME_CONTATO SOBRENOME_CONTATO
	 * 			...
	 * 			 N_CONTATOS - {CORAÇÃO, CASO SEJA FAVORITO} NOME_CONTATO SOBRENOME_CONTATO"
	 */
	public String allContatos() {
		String retorno = "";
		Contato[] contatos = getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getFavorito()) {
					retorno += i + 1 + " - ❤️ " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";
				} else {
					retorno += i + 1 + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";
				}
			}
		}
		return retorno;
	}
	
	/**
	 * Acessa o contato, e puxa um contato específico perante a sua posição dentro do array de Contatos.
	 * 
	 * @param posicao - Posição do contato que se deseja acessar.
	 * @return O contato acessado em STRING.
	 */
	public String puxarContato(int posicao) {
		Contato contato = getContato(posicao - 1);
		return contato.toString();
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao 		Posição do contato.
	 * @param nome 			Nome do contato.
	 * @param sobrenome 	Sobrenome do contato.
	 * @param telefone 		Telefone do contato.
	 * @return Situação correspondente ao cadastro do contato desejado.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if(posicao <= 0 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA!";
		} else if (telefone.equals("") || nome.equals("")) {
			return "CONTATO INVÁLIDO";
		} else if (existeContato(nome, sobrenome, this.contatos)) {
			return "CONTATO JÁ CADASTRADO!";
		} else {
			this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
			return "CADASTRO REALIZADO!";
		}		
	}
	

	/**
	 * Listagem dos contatos que foram favoritados e armazenados dentro do array de favoritos.
	 * 
	 * @return A representação dos contatos favoritados em uma strig, que segue o formato:
	 * 			"1 - ❤️ NOME_CONTATO_FAV SOBRENOME_CONTATO_FAV
	 * 			 2 - ❤️ NOME_CONTATO_FAV SOBRENOME_CONTATO_FAV
	 * 			...
	 * 			 N_CONTATO_FAV - ❤️ NOME_CONTATO_FAV SOBRENOME_CONTATO_FAV"
	 */
	public String listaFavoritos() {
		String retorno = "";
		for(int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				retorno += i + 1 + " - ❤️ " + favoritos[i].getNome() + " " + favoritos[i].getSobrenome() + "\n";
			}
		}
		return retorno;
	}

	
	/**
	 * Adiciona um contato já existente como favorito na=o array de favoritos, ele possui como parâmetro
	 * a posição do contato dentro do array de contatos que vai ser inserido no array de favoritos e em
	 * qual posição ele vai ser inserido no array de favoritos.
	 * 
	 * @param posicao_contato - posição do contato dentro do array de contatos que vai ser favoritada.
	 * @param posicao_favorito - posição do array de favorito que vai ser inserido o contato.
	 * @return Situação do contato que está sendo cadastrado como favorito
	 */
	public String cadastraFavorito(int posicao_contato, int posicao_favorito) {
		if (posicao_contato <= 0 || posicao_contato > 100) { 
			return "POSIÇÃO DE CONTATO INVÁLIDA"; 
		} else if (posicao_favorito <= 0 || posicao_favorito > 10) { 
			return "POSIÇÃO DE FAVORITO INVÁLIDA"; 
		} else if (contatos[posicao_contato - 1] == null) { 
			return "CONTATO INVÁLIDO";
 		} else if (existeContato(contatos[posicao_contato - 1].getNome(), contatos[posicao_contato - 1].getSobrenome(), this.favoritos)) {
			return "CONTATO JÁ FAVORITADO";
		} else {
			if (favoritos[posicao_favorito - 1] != null) {
				favoritos[posicao_favorito - 1].desFavorito();
			}
			contatos[posicao_contato - 1].ehFavorito();
			favoritos[posicao_favorito - 1] = contatos[posicao_contato - 1];
			return "CADASTRO FAVORITADO NA POSIÇÃO " + posicao_favorito;
		}
	}
		
	
	/**
	 * Remove um contato do array de favoritos
	 * 
	 * @param posicao_favorito - posição que vai ser removida do array de favoritos
	 */
	public void removeFavorito(int posicao_favorito) {
		favoritos[posicao_favorito - 1].desFavorito();
		favoritos[posicao_favorito - 1] = null;
		
	}


}
