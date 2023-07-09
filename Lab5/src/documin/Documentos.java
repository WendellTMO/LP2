package documin;

import java.util.*;

/**
 * Sistema faz armazenamento dos documentos que são criadas com esse objeto
 * 
 * @author Wendell Tomé Marinho Oliveira - 12110748
 *
 */
public class Documentos {
	
	/**
	 * titulo do documento
	 */
	private String titulo;
	
	/**
	 * tamanho max de elementos do documento
	 */
	private int tamanhoMax;
	
	/**
	 * guarda se o documento é um atalho
	 */
	private boolean ehAtalho;
	
	/**
	 * lista de atalhos
	 */
	private List<Atalho> atalhos;
	
	/**
	 * lista de elementos
	 */
	private List<Elementos> elementos;
	
	/**
	 * Construtor de documentos com o seu título e tamanho 	
	 * @param titulo titulo do documento
	 * @param tamanhoMax tamanho maximo de elementos do documento
	 */
	public Documentos(String titulo, int tamanhoMax) {
		this.titulo = titulo;
		this.tamanhoMax = tamanhoMax;
		this.elementos = new ArrayList<Elementos>();
		this.atalhos = new ArrayList<Atalho>();
	}
	
	/**
	 * Construtor de documentos apenas com seu titulo
	 * @param titulo titulo do documentoo
	 */
	public Documentos (String titulo) {
		this.tamanhoMax = -1;
		this.titulo = titulo;
		this.elementos = new ArrayList<Elementos>();
		this.atalhos = new ArrayList<Atalho>();
	}
	
	/**
	 * adiciona um elemento ao documento
	 * @param E elemento que será adicionado dentro do documento
	 * @return posição do elemento dentro do documento
	 */
	public int addElemento(Elementos E) {
		if (this.tamanhoMax == -1) {
			this.elementos.add(E);
		} else if (this.elementos.size() < this.tamanhoMax) {
			this.elementos.add(E);
		} else if (this.elementos.size() == this.tamanhoMax) {
			return -2;
		}
		
		return elementos.size() - 1;
	}
	
	/**
	 * Conta a quantidade de elementos existentes dentro do documento
	 * @return quantidade de elementos existentes dentro do documento
	 */
	public int qtdElementos() {
		
		return elementos.size();
	}
	
	/**
	 * movimenta o elemento uma posição para cima
	 * @param elementoPosi posição do elemento que será movido para cima
	 * @return true caso consiga fazer a movimentação, false caso contrário
	 */
	public boolean moverParaCima(int elementoPosi) {
		if (elementoPosi == 0) {
			return false;
		} else if (elementoPosi >= 0 && elementoPosi < this.elementos.size()) {
			this.elementos.get(elementoPosi - 1);
			Collections.swap(elementos, elementoPosi, elementoPosi - 1);
			return true;
		}
		return false;
	}
	
	/**
	 * movimenta o elemento uma posição para baixo
	 * @param elementoPosi posição do elemento que será movido para baixo
	 * @return true caso consiga fazer a movimentação, false caso contrário
	 */
	public boolean moverParaBaixo(int elementoPosi) {
		if (elementoPosi == this.elementos.size() - 1) {
			return false;
		} else if (elementoPosi >= 0 && elementoPosi < this.elementos.size()) {
			this.elementos.get(elementoPosi);
			Collections.swap(elementos, elementoPosi, elementoPosi + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * Acessa um dos elementos e pede a sua representação resumida
	 * @param elementoPosi posição do elemento que será acessado para fornecer sua representação resumida
	 * @return representação resumida do elemento
	 */
	public String pegarRepresentacaoResumida(int elementoPosi) {
		Elementos e = this.elementos.get(elementoPosi);
		return e.generateRepresentacaoResumida();
	}
	
	/**
	 * Acessa um dos elementos e pede a sua representação completa
	 * @param elementoPosi posição do elemento que será acessado para fornecer sua representação completa
	 * @return representação completa do elemento
	 */
	public String pegarRepresentacaoCompleta(int elementoPosi) {
		Elementos e = this.elementos.get(elementoPosi);
		return e.generateRepresentacaoCompleta();
	}
	
	/**
	 * Cria um hashcode do documento
	 * 
	 * @return hashcode 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}
	
	/**
	 * Compara se dois objetos de documentos são iguais
	 * 
	 * @return true se os objetos são iguais, false caso sejam diferentes
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documentos other = (Documentos) obj;
		
		return Objects.equals(titulo, other.titulo);
		
	}

	
	/**
	 * Exibição do documento em um Array de string
	 * 
	 * @return a exibição de documento em um array de String
	 */
	public String[] exibirDoc() {
		String[] retorno = new String[this.elementos.size()];
		
		for(int i = 0; i < this.elementos.size() - 1; i++) {
			retorno[i] = this.elementos.get(i).generateRepresentacaoCompleta() + "\n";
		}
		retorno[elementos.size() - 1] = this.elementos.get(elementos.size() - 1).generateRepresentacaoCompleta();		
		
		return retorno;
	}
	
	
	private boolean temElemento(int elementoPosi) {
		if (elementoPosi > this.elementos.size() - 1 || elementoPosi < 0) {
			return false;
		} 
		Elementos e = this.elementos.get(elementoPosi);
		return this.elementos.contains(e);
	}

	/**
	 * Remoção de um elemento do documento
	 *  
	 * @param elementoPosicao posição do elemento que vai fazer a remoção no documento
	 * @return true caso o elemento seja removido, false caso contrário
	 */
	public boolean apagarElemento(int elementoPosicao) {
		if (temElemento(elementoPosicao)) {
			this.elementos.remove(elementoPosicao);
			return true;
		}
		return false;
	}

	/**
	 * Verifica se tem um atalhos
	 * @return true se tiver atalhos, false se nao tiver
	 */
	public boolean temAtalho() {
		return this.atalhos.size() > 0;
	}
	
	/**
	 * define documento como atalho
	 */
	public void setAtalho() {
		this.ehAtalho = true;
	}
	
	/**
	 * verifica se o documento é atalho
	 * @return true se for atalho, false se não for atalho
	 */
	public boolean getEhAtalho() {
		return this.ehAtalho;
	}
	
	/**
	 * pega titulo do documento
	 * @return o titulo do documento
	 */
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * Pega um atalho do documento
	 * @param id posição do atalho que gostaria de recuperar
	 * @return o atalho
	 */
	public Atalho getAtalho(int id) {
		return this.atalhos.get(id);
	}
	
	/**
	 * adiciona um atalho no documento
	 * @param a Atalho que será adicionado
	 * @return posição do atalho dentro do documento
	 */
	public int addAtalho(Atalho a) {
		this.atalhos.add(a);
		return this.atalhos.size() - 1;
	}
	
	/**
	 * Calculo da media da prioridade
	 * 
	 * @return int a media da prioridade
	 */
	public int mediaDaPrioridade() {
		int media = 0;
		for (int i = 0; i < this.elementos.size(); i++) {
			media += this.elementos.get(i).getPrioridade();
		}
		
		if (this.elementos.size() == 0) {
			return media;
		} 
		
		return media / this.elementos.size();
	}
	
	
	/**
	 * Pega os elementos prioritarios com prioridade 4 e 5
	 * @return array com os elementos de prioridade 4 e 5
	 */
	public ArrayList<Elementos> getElementosPrioritarios() {
		ArrayList<Elementos> res = new ArrayList<>();
		
		for (Elementos e : this.elementos) {
			if (e.getPrioridade() >= 4) {
				res.add(e);
			}
		}
		return res;
	}

	/**
	 * Criação de uma visão resumida do documento
	 * 
	 * @return representação em String da visão resumida
	 */
	public String[] criarVisaoResumida() {
		String[] retorno = new String[this.elementos.size()];
		
		for (int i = 0; i < this.elementos.size() - 1; i++) {
			retorno[i] = this.elementos.get(i).generateRepresentacaoResumida() + "\n";
		}
		retorno[this.elementos.size()-1] = this.elementos.get(elementos.size() - 1).generateRepresentacaoResumida();
		
		return retorno;
	}
	
	/**
	 * Criação da visao completa do documento
	 * @return representação em String da visao completa
	 */
	public String[] criarVisaoCompleta() {
		String[] retorno = new String[this.elementos.size()];
		
		for (int i = 0; i < this.elementos.size()-1; i++) {
			retorno[i] = this.elementos.get(i).generateRepresentacaoCompleta() + "\n";
		}
		retorno[this.elementos.size() - 1] = this.elementos.get(elementos.size() - 1).generateRepresentacaoCompleta();
		
		return retorno;
	}
	
	private int qtdPrioridade(int prioridade) {
	    int qtd = 0;
	    
	    for (Elementos elemento : this.elementos) {
	        if (elemento.getPrioridade() >= prioridade) {
	            qtd++;
	        }
	    }
	    
	    return qtd;
	}

	/**
	 * Criação da visao prioritaria do documento
	 * @param prioridade definida para que seja criada a visao prioritara
	 * @return representação em String da visão prioritaria
	 */
	public String[] criarVisaoPrioritaria(int prioridade) {
	    int qtd = qtdPrioridade(prioridade);
	    String[] res = new String[qtd];
	    
	    int j = 0;
	    for (Elementos elemento : this.elementos) {
	        if (elemento.getPrioridade() >= prioridade) {
	            res[j] = elemento.generateRepresentacaoCompleta();
	            if (j < qtd - 1) {
	                res[j] += "\n";
	            }
	            j++;
	        }
	    }
	    
	    return res;
	}

	
	private int qtdTitulo() {
		Integer qtd = 0;
		
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i) instanceof Titulo) {
				qtd++;
			}
		}
		
		return qtd;
	}
	
	/**
	 * Criação da visao titulo do documento
	 * @return representação em String da visao titulo
	 */
	public String[] criarVisaoTitulo() {
		String[] res = new String[qtdTitulo()];
		
		int j = 0;
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i) instanceof Titulo) {
				if (i == this.elementos.size() - 1) {
					res[j] = this.elementos.get(i).generateRepresentacaoResumida();
					j++;
				} else {
					res[j] = this.elementos.get(i).generateRepresentacaoResumida() + "\n";
					j++;
				}
				
			}
		}
		return res;
	} 
	

	

	
	
}
