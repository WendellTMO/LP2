package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(R)emover Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listarFavoritos(agenda);
			break;
		case "A":
			adicionarFavorito(agenda, scanner);
			break;
		case "R":
			removerFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Listagem dos contatos favoritados
	 * 
	 * @param agenda - Agenda sendo manipulada
	 */
	private static void listarFavoritos(Agenda agenda) {
		System.out.println(agenda.listaFavoritos());
	}

	/**
	 * Adiciona um contato como favorito na agenda
	 * 
	 * @param agenda - Agenda sendo manipulada
	 * @param scanner - Objeto Scanner para capturar as posição para adicionar esse contato
	 */
	private static void adicionarFavorito(Agenda agenda, Scanner scanner) {
		System.out.println("\nContato> ");
		int posicao_contato = scanner.nextInt();
		System.out.println("\nFavorito> ");
		int posicao_favorito = scanner.nextInt();
		System.out.println(agenda.cadastraFavorito(posicao_contato, posicao_favorito));
		
	}
	
	/**
	 * Remove um contato favorito da agenda
	 * 
	 * @param agenda - Agenda sendo manipulada
	 * @param scanner - Objeto Scanner para capturar a posição
	 */
	private static void removerFavorito(Agenda agenda, Scanner scanner) {
		System.out.println("\nPosicao> ");
		int posicao_favorito = scanner.nextInt();
		agenda.removeFavorito(posicao_favorito);
		
	}


	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: \n" + agenda.allContatos());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		System.out.println("Dados do contato:\n" + agenda.puxarContato(posicao));
		
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		
		@SuppressWarnings("unused")
		String ignore = scanner.nextLine();
		
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		
		System.out.print(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
	
	}


	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	


	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
		}
	
	
}
