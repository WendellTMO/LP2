package documin;

/**
 * Controle de tudo
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class Facade {
	
	/**
	 * Chamando o controle de documentos
	 */
	private DocumentoController documentoController;
	
	/**
	 * Construtor da Facade que irá inicializar o controle de documentos
	 */
	public Facade() {
		this.documentoController = new DocumentoController();
	}
	
	/**
	 * Cria um documento por meio do seu titulo
	 * 
	 * @param titulo titulo do documento
	 * @return True se for criado,
	 * 			False caso contrário
	 */
	public boolean criarDocumento(String titulo) {
		return this.documentoController.criarDocumento(titulo);
	}

	/**
	 * Cria um documento por meio do seu titulo com tamanho maximo de elementos
	 * @param titulo titulo do documento
	 * @param tamanhoMaximo tamanho máximo de elementos que o documento poderá armazenar
	 * @return True se for criado,
	 * 			False caso contrário.
	 */
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
	}
	
	/**
	 * Remove o documento do sistema por meio do seu titulo do documento
	 * 
	 * @param titulo titulo do documento
	 */
	public void removerDocumento(String titulo) {
		this.documentoController.removerDocumento(titulo);
	}
	
	/**
	 * Contagem da quantidade de elementos dentro de um documento 
	 * @param titulo titulo do documento
	 * @return int Quantidade de elementos que foram encontrados dentro do documento
	 */
	public int contarElementos(String titulo) {
		return this.documentoController.contarElementos(titulo);
	}
	
	/**
	 * Exibição de um documento no formato de um array
	 * @param titulo titulo do documento
	 * @return String[] a exibição do documento em um array 
	 */
	public String[] exibirDocumento(String titulo) {
		return this.documentoController.exibirDocumento(titulo);
	}
	

	/**
	 * Criação de um elemento de texto que irá ser inserido dentro de um documento, o valor do texto e sua prioridade
	 * 
	 * @param tituloDoc Titulo do documento que o texto será inserido
	 * @param valor valor do texto
	 * @param prioridade prioridade do texto 
	 * @return a posição em que o elemento foi cadastrado dentro do documento
	 */
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		
		return this.documentoController.addTexto(tituloDoc, valor, prioridade);
	}
	
	/**
	 * Criação de um elemento de título que irá ser inserido dentro de um coumento, contendo o seu valor,
	 * sua prioridade, seu nível e linkável
	 * 
	 * @param tituloDoc titulo do documento que irá receber o título
	 * @param valor valor do título
	 * @param prioridade prioridade do título
	 * @param nivel nível do título
	 * @param linkavel linkavel do título, valor booleano
	 * 
	 * @return a posição em que o elemento foi cadastrado dentro do documento
	 */
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		return this.documentoController.addTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
		
	}
	
	/**
	 * Criação de um elemente de lista que irá ser inserido dentro de um documento, contendo o seu valor, sua prioridade, o separador e o caractere da lista
	 * 
	 * @param tituloDoc titulo do documento que irá receber a lista
	 * @param valorLista valor da lista
	 * @param prioridade prioridade da lista
	 * @param separador nível da lista
	 * @param charLista caractere da lista
	 * 
	 * @return a posição em que o elemento foi cadastrado dentro do documento
	 */
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		return this.documentoController.addLista(tituloDoc, valorLista, prioridade, separador, charLista);
	}
	
	/**
	 * Criação de um elemento de termos que irá ser inserido dentro de um documento, contendo seu valor, sua prioridade, separador e a sua ordem
	 * 
	 * @param tituloDoc titulo do documento que irá receber o termo
	 * @param valorTermos valor do termo
	 * @param prioridade prioridade do termo
	 * @param separador separador do term o
	 * @param ordem ordem do termo
	 * 
	 * @return a posição em que o elemento foi cadastrado dentro do documento 
	 */
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		return this.documentoController.addTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
	}
	
	/**
	 * Irá pegar a representação completa de um elemento, por meio do título do documento e a posição que este elemento está localizado dentro do documento
	 * @param tituloDoc titulo do documento
	 * @param elementoPosicao posição do elemento que queremos acessar a sua representação
	 * @return String representação completa do elemento
	 */
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		return this.documentoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
	}
	
	/**
	 * Irá pegar a representação resumida de um elemento, por meio do título do documento e a posição que este elemento está localizado dentro do documento
	 * @param tituloDoc titulo do documento
	 * @param elementoPosicao posição do elemento que queremos acessar a sua representação
	 * @return String representação resumida do elemento
	 */
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		return this.documentoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
	}
	
	/**
	 * Método que irá apagar um elemento dentro do documento
	 * 
	 * @param tituloDoc titulo do documento
	 * @param elementoPosicao posição do elemento que iremos remover
	 * @return true caso o elemento seja removido, false se ele não for removido
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		return this.documentoController.apagarElemento(tituloDoc, elementoPosicao);
	}
	
	/**
	 * mover o elemento uma posição pra cima dentro do documento
	 * @param tituloDoc titulo do documento
	 * @param elementoPosicao posicao do elemento que vamos mover um para cima
	 */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
	}
	
	/**
	 * mover o elemente uma posição para baixo dentro do documento
	 * @param tituloDoc titulo do documento
	 * @param elementoPosicao posicao do elemento que vamos mover um para baixo
	 */
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		 this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
	}
	
	/**
	 * Criação de um atalho a partir do titulo e do titulo referenciado
	 * 
	 * @param tituloDoc Documento que vai receber o atalho
	 * @param tituloDocReferenciado titulo referenciado
	 * @return posição do atalho criado
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
	}
	
	/**
	 * Criação da visão a partir do título do documento
	 * @param tituloDoc titulo do documento onde vai ser criado a visão completa
	 * @return a posição da visão completa que foi criada
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		return this.documentoController.criarVisaoCompleta(tituloDoc);
	}
	
	/**
	 * Criação da vaisão a partir do título do documento
	 * @param tituloDoc titulo do documento onde vai ser criado a visão resumida
	 * @return a posição da visão resumida que foi criada
	 */
    public int criarVisaoResumida(String tituloDoc) {
    	return this.documentoController.criarVisaoResumida(tituloDoc);
    }
    
    /**
     * Criação da visão a partir do título do documento
     * @param tituloDoc título do documento onde vai ser criado a visão prioritária
     * @param prioridade prioridade escolhida para que seja criada a visão
     * @return a posição da visão com base na prioridade que foi criada
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }
    
    /**
     * Criação da visão a partir do titulo do documento
     * @param tituloDoc titulo do documento que vai ser criado a visão do título
     * @return a posição da visão do titulo que foi criada
     */
    public int criarVisaoTitulo(String tituloDoc) {
    	return this.documentoController.criarVisaoTitulo(tituloDoc);
    }
    
    /**
     * Exibição da visão criada a partir do id da visão
     * 
     * @param visaoId posição da visão
     * 
     * @return a visão sendo representada em um array de string
     */
    public String[] exibirVisao(int visaoId) {
    	return this.documentoController.exibirVisao(visaoId);
    }
    
	
	
	
	
}
