package documin;

import java.util.*;


/**
 * Classe que irá controlar todas as operações que envolvam os documentos
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class DocumentoController {
	
	/**
	 * Map que irá guardar todos os documentos, a chave para acessar é o seu título
	 */
	private Map<String, Documentos> documentos;
	
	/**
	 * Lista de todas as visões
	 */
	private List<String[]> visoes;
	
	/**
	 * Construtor do controlador de documentos
	 */
	public DocumentoController() {
		this.documentos = new HashMap<>();
		this.visoes = new ArrayList<>();
	}

	/**
	 * Método privado para verificar se o título é válido, e lanãr Exception caso não seja
	 * @param titulo titulo do documento
	 */
	private void lancaIllegalArgumentException(String titulo) {
		if (titulo.equals("") || verificaEspaco(titulo)) {
			throw new IllegalArgumentException("Titulo Invalido");
		} 
	}
	
	/**
	 * Méetodo privado para verificar se o documento existe e lançar Exception caso não seja
	 * @param titulo titulo do documento
	 */
	private void lancaNoSuchElementException(String titulo) {
		if (!verificaDocumentoExiste(titulo)) {
			throw new NoSuchElementException("Titulo Inexistente");
		}
	}
	
	/**
	 * Verificação se o documento existe
	 * @param titulo titulo do documento
	 * @return true se existir, false se não existir
	 */
	private boolean verificaDocumentoExiste(String titulo) {
		return documentos.containsKey(titulo);
	}
	
	/**
	 * verifica se o titulo é composto apenas por espaço
	 * @param titulo titulo do documento
	 * @return true caso seja, false caso não seja
	 */
	private boolean verificaEspaco(String titulo) {
		String temp_titulo = titulo.replace(" ", "");
		if (temp_titulo.equals("")) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Cria e adiciona o documento que só contém o seu título
	 * @param titulo titulo do documento
	 * @return true caso o documento seja criado e adicionado dentro do controle, false caso contrário
	 */
	public boolean criarDocumento(String titulo) {
		lancaIllegalArgumentException(titulo);
		
		if (!verificaDocumentoExiste(titulo)) {
			Documentos doc = new Documentos(titulo);
			documentos.put(titulo, doc);
			return true;
		}
		return false;
	}

	/**
	 * Cria e adiciona o documento que contém o título e o tamanho máximo de elementos
	 * @param titulo titulo do documento
	 * @param tamanhoMaximo tamanho maximo de elementos do documento
	 * @return true caso o documento seja criado e adicionado dentro do controle, false caso contrário
	 */
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		lancaIllegalArgumentException(titulo);

		if (tamanhoMaximo <= 0) {
			throw new IllegalArgumentException("Tamanho Inválido");
		}
		
		if (!verificaDocumentoExiste(titulo)) {
			Documentos doc = new Documentos(titulo, tamanhoMaximo);
			
			documentos.put(titulo, doc);
			return true;
		}
		return false;
	}

	/**
	 * Método que informa a quantidade de documentos já criados no sistema
	 * @return int contendo a quantidade de documentos dentro do sistema
	 */
	public int qtdDoc() { 
		return documentos.size(); 
	}
	
	/**
	 * Faz a remoção de um documento do sistema
	 * @param titulo titulo do documento que vai ser removido
	 */
	public void removerDocumento(String titulo) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		documentos.remove(titulo);
		
	}

	
	/**
	 * Faz a contagem de elementos existentes dentro do documento
	 * @param titulo titulo do documento que iremos contar
	 * @return int contendo a quantidade de elementos dentro do documento
	 */
	public int contarElementos(String titulo) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		int retorno = documentos.get(titulo).qtdElementos();
		return retorno;
	}

	
	/**
	 * Exibição de um documento no formato de Array
	 * @param titulo titulo do documento que vamos exibir
	 * @return a exibição do documento em um Array
	 */
	public String[] exibirDocumento(String titulo) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		return documentos.get(titulo).exibirDoc();
	}

	/**
	 * Criação da representação completa de um elemento, acessando o documento por meio do seu título e buscando o elemento em determinado posição dentro do documento
	 * @param titulo titulo do documento
	 * @param elementoPosi posição do elemento
	 * @return representação completa de determinado elemento
	 */
	public String pegarRepresentacaoCompleta(String titulo, int elementoPosi) {
		lancaNoSuchElementException(titulo);
		Documentos d = this.documentos.get(titulo);
		return d.pegarRepresentacaoCompleta(elementoPosi);
	}
	
	/**
	 * Criação da representação resumida de um elemento, acessando o documento por meio do seu título e buscando o elemento em determinada posição dentro do documento
	 * @param titulo titulo do documento
	 * @param elementoPosi posição do elemento
	 * @return representação resumida de determinado elemento
	 */
	public String pegarRepresentacaoResumida(String titulo, int elementoPosi) {
		lancaNoSuchElementException(titulo);
		Documentos d = this.documentos.get(titulo);
		return d.pegarRepresentacaoResumida(elementoPosi);
	}

	/**
	 * 
	 * Criação de um elmento texto por meio do titulo do documento onde ele será inserido como elemento, prioridade do elemento e respectivo valor
	 * 
	 * @param titulo titulo do documento
	 * @param valor valor do texto
	 * @param prioridade prioridade do texto
	 * @return posição no qual o texto foi adicionado dentro do documento
	 */
	public int addTexto(String titulo, String valor, int prioridade) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		Elementos E = new Texto(valor, prioridade);
		
		return documentos.get(titulo).addElemento(E);
	}
	
	/**
	 * Criação de um elmento lista por meio do titulo do documento onde ele será inserido como elemento, sua prioridade, seu respectivo valor, seu separador e o caractere da lista.
	 * 
	 * @param titulo titulo do documento
	 * @param valorLista valor da lista
	 * @param prioridade prioridade da lista
	 * @param separador separador da lista
	 * @param charLista caractere da lista
	 * @return posição no qual a lista foi adicionada dentro do documento
	 */
	public int addLista(String titulo, String valorLista, int prioridade, String separador, String charLista) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		Elementos E = new Lista(prioridade, charLista, separador, valorLista);
				
		return documentos.get(titulo).addElemento(E);
	}
	
	
	/**
	 * Criação de um elemento termos por meio do titulo do documento onde ele será inserido como elemento, sua prioridade, seu respectivo valor, seu separador e a ordem que terá que ser ordenado
	 * 
	 * @param titulo titulo do documento
	 * @param valorTermos valor do termo
	 * @param prioridade prioridade do termo
	 * @param separador separador do termo
	 * @param ordem ordem do termo
	 * @return posição no qual o termo foi adicionado dentro do documento
	 */
	public int addTermos(String titulo, String valorTermos, int prioridade, String separador, String ordem) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		Elementos E = new Termos(valorTermos, prioridade, separador, ordem);
		
		return documentos.get(titulo).addElemento(E);
	}
	
	/**
	 * Criação de um elemento titulo por meio do titulo do documento onde ele será inserido como elemento, sua prioridade, seu respectivo valor, seu nivel e se ele é linkavel
	 * 
	 * @param titulo titulo do documento
	 * @param valor valor do titulo
	 * @param prioridade prioridade do titulo
	 * @param nivel nivel do titulo
	 * @param linkavel true se ele for linkavel, false caso contrário
	 * @return posição no qual o titulo foi adicionado dentro do documento
	 */
	public int addTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		Elementos E = new Titulo(nivel, valor, prioridade, linkavel);
		
		return documentos.get(titulo).addElemento(E);
	}

	/**
	 * Irá apagar um elemento dentro de um documento
	 * @param tituloDoc titulo do documento
	 * @param elementoPosicao posição do elemento que deve ser apagado
	 * @return true caso o elemento seja apagado com sucesso, false se o elemento não for apagado
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		lancaIllegalArgumentException(tituloDoc);
		lancaNoSuchElementException(tituloDoc);
		
		return this.documentos.get(tituloDoc).apagarElemento(elementoPosicao);
	}
	
	/**
	 * 
	 * Troca de posicao de um elemento para uma posição para cima
	 * 
	 * @param titulo titulo do documento onde vamos subir a posição do elemento
	 * @param elementoPosicao posição do elemento que vai subir uma posição
	 * @return true caso consiga subir uma posição, false caso contrário
	 */
	public boolean moverParaCima(String titulo, int elementoPosicao) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		return this.documentos.get(titulo).moverParaCima(elementoPosicao);
	}
	
	/**
	 * 
	 * TRoca de posicao de um elemento para uma posição para baixo
	 * 
	 * @param titulo titulo do documento onde vamos descer a posição do elemento
	 * @param elementoPosicao posição do elemento que vai descer uma posição
	 * @return true caso consiga descer uma posição, false caso contrário
	 */
	public boolean moverParaBaixo(String titulo, int elementoPosicao) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		
		return this.documentos.get(titulo).moverParaBaixo(elementoPosicao);
	}
	
	/**
	 * Criação de um atalho por meio do titulo do documento e o titulo referenciado
	 * 
	 * @param titulo titulo do documento que bai receber o atalho
	 * @param tituloRefer titulo referenciado.
	 * @return posição do atalho que foi criado
	 */
	public int criarAtalho(String titulo, String tituloRefer) {
		lancaIllegalArgumentException(titulo);
		lancaNoSuchElementException(titulo);
		lancaIllegalArgumentException(tituloRefer);
		lancaNoSuchElementException(tituloRefer);
		
		Documentos doc = this.documentos.get(titulo);
		Documentos docRef = this.documentos.get(tituloRefer);
		int posi = -1;
		if(!docRef.temAtalho() && !doc.getEhAtalho()) {
			int prioridade = docRef.mediaDaPrioridade();
			String tituloDocRef = docRef.getTitulo();
			ArrayList<Elementos> elementosPrioRef = docRef.getElementosPrioritarios();
			Atalho atalho = new Atalho(prioridade, tituloDocRef, elementosPrioRef);
			posi = doc.addAtalho(atalho);
			docRef.setAtalho();
		} else {
			throw new IllegalStateException();
		}
		return posi;
	
	}
	
	/**
	 * Criação da visão por meio do titulo do documento
	 * 
	 * @param tituloDoc titulo do documento que vai ser craiada a visão completa
	 * @return a posição da visão que foi criada
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		lancaNoSuchElementException(tituloDoc);
		lancaIllegalArgumentException(tituloDoc);
		this.visoes.add(this.documentos.get(tituloDoc).criarVisaoCompleta());
		return this.visoes.size() - 1;
	}

	/**
	 * Criação da visão por meio do titulo do documento
	 * 
	 * @param tituloDoc titulo do documento que vai ser criada a visão resumida
	 * @return a posição da visão que foi criada
	 */
	public int criarVisaoResumida(String tituloDoc) {
		lancaNoSuchElementException(tituloDoc);
		lancaIllegalArgumentException(tituloDoc);
		this.visoes.add(this.documentos.get(tituloDoc).criarVisaoResumida());
		return this.visoes.size() - 1;
	}
	
	/**
	 * Criação da visão por meio do titulo do documento e prioridade escolhida para sua criação
	 * @param tituloDoc titulo do documento que vai ser criada a visão prioritaria
	 * @param prioridade prioridade escolhida para criação da visão
	 * @return a posição da visão criada
	 */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		lancaNoSuchElementException(tituloDoc);
		lancaIllegalArgumentException(tituloDoc);
		this.visoes.add(this.documentos.get(tituloDoc).criarVisaoPrioritaria(prioridade));
		return this.visoes.size() - 1;
		
	}
	
	/**
	 * Criação da visão por meio do tituo do documento
	 * @param tituloDoc titulo do documento que vai ser criada a visao
	 * @return posicao da visao criada
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		lancaNoSuchElementException(tituloDoc);
		lancaIllegalArgumentException(tituloDoc);
		this.visoes.add(this.documentos.get(tituloDoc).criarVisaoTitulo());
		return this.visoes.size() - 1;
		
	}
	
	/**
	 * Representação da visão em um array de Strings
	 * @param visaoId posicao da visao 
	 * @return a representação da visao 
	 */
	public String[] exibirVisao(int visaoId) {
		int tam = this.visoes.size() - 1;
		if(visaoId <= tam && visaoId >= 0) {
			return this.visoes.get(visaoId);
		}
		String[] res = {"Visão Não Existe"};
		return res;
	}

	/**
	 * Método que irá acessar um documento dentro do Map e vai devolver seu objeto
	 * @param titulo titulo do documento que queremos obter
	 * @return Documento o objeto de documento que foi acessado dentro do map
	 */
	public Documentos getDocumento(String titulo) {
		return this.documentos.get(titulo);
	}
	



}
