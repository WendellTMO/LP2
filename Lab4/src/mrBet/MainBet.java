package mrBet;

import java.util.Scanner;

/**
 * Interface com menu texto para maipular o sistema do MrBet
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */

public class MainBet {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SistemaMrBet system = new SistemaMrBet();
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, system, scanner);
		}
	}
	
	/**
	 * Exibe o menu e faz a captura do input do usuário
	 * 
	 * @param scanner Captura a opção que o usuário deseja
	 * @return Comondo escolhido pelo usário
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(M)Minha inclusão de times\n" + 
						"(R)Recuperar time\n" + 
						"(.)Adicionar campeonato\n" + 
						"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
						"(E)Exibir campeonatos que o time participa\n" +
						"(T)Tentar a sorte e status\n" +
						"(H) Histórico\n" +
						"(!)Já pode fechar o programa\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida pelo usuário
	 * 
	 * @param opcao		Opção do usuário
	 * @param mrBet		O sistema de apostas que estamos utilizando
	 * @param scanner	Objeto scanner para leitura de outros input
	 */
	private static void comando(String opcao, SistemaMrBet mrBet, Scanner scanner) {
		switch (opcao) {
		case "M":
			minhaInclusao(mrBet, scanner);
			break;
		
		case "R":
			recuperaTime(mrBet, scanner);
			break;
		
		case ".":
			adicionaCampeonato(mrBet, scanner);
			break;
		
		case "B":
			System.out.println("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
			String opcao2 = scanner.nextLine().toUpperCase();
			switch(opcao2) {
			case "I":
				incluirTime(mrBet, scanner);
				break;
			case "V":
				verificarTime(mrBet, scanner);
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
			break;
		
		case "E":
			exibirCampeonato(mrBet, scanner);
			break;
		
		case "T":
			System.out.println("\n(A) Apostar ou (S)Status das apostas? ");
			String opcao3 = scanner.nextLine().toUpperCase();
			switch(opcao3) {
			case "A":
				fazerAposta(mrBet, scanner);
				break;
			case "S":
				statusAposta(mrBet);
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
			break;
		case "H":
			historicoResumo(mrBet);
			break;
			
		case "!":
			sair();
			break;
			
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	

	private static void historicoResumo(SistemaMrBet mrBet) {
		System.out.println(mrBet.historicoResumo());
		
	}

	/**
	 * Inclusão do time em um dos campeonatos
	 * 
	 * @param mrBet		Sistema de apostas que estamos trabalhando
	 * @param scanner	Scanner para leitura de input do usuário
	 */
	private static void incluirTime(SistemaMrBet mrBet, Scanner scanner) {
		System.out.println("\nCódigo: ");
		String codigo = scanner.nextLine();
		
		
		System.out.println("\nCampeonato: ");
		String campeonato = scanner.nextLine();
		
		System.out.println(mrBet.incluirTimeCampeonato(codigo, campeonato.toLowerCase()));
		
	}
	
	
	/**
	 * Verificação se um time está dentro de determinado campeonato
	 * 
	 * @param mrBet		O sistema de apostas
	 * @param scanner	Leitura para analisarmos de qual time estamos querendo saber se está feito o registro
	 */
	private static void verificarTime(SistemaMrBet mrBet, Scanner scanner) {
		System.out.println("\nCódigo: ");
		String codigo = scanner.nextLine();
		
		
		System.out.println("\nCampeonato: ");
		String campeonato = scanner.nextLine();
		
		System.out.println(mrBet.verificarTimeCampeonato(codigo, campeonato.toLowerCase()));
		
	}

	
	/**
	 * Faz o registro de aposta do usuário em um dos times.
	 * 
	 * OBS: No documento do LAB4 não estava especificando como seria a leitura do valor de aposta
	 * 		Dito isso a leitura está sendo feita no formato "R$##,##". O usuário precisa digitar
	 * 		o "R$" e o respectivo valor, o programa irá ler e retirar o "R$" para enviar para que
	 * 		o sistema faça a leitura. O usuário também pode utilizar tanto vírgula quanto ponto, pois
	 * 		ele irá substituir para ponto.
	 * @param mrBet		Sistema de apostas
	 * @param scanner	Leitura de input referente a aposta
	 */
	private static void fazerAposta(SistemaMrBet mrBet, Scanner scanner) {
		System.out.println("\nCódigo: ");
		String codigo = scanner.nextLine();
		
		System.out.println("\nCampeonato: ");
		String campeonato = scanner.nextLine();
		
		System.out.println("\nColocação: ");
		int colocacao = scanner.nextInt();
		
		@SuppressWarnings("unused")
		String ignore = scanner.nextLine();
		
		System.out.println("\nValor da Aposta: ");
		String temp_valor = scanner.nextLine();	
		temp_valor = temp_valor.replaceAll(",", ".");
		double valor = Double.parseDouble(temp_valor.substring(2, temp_valor.length()));
		
		System.out.println(mrBet.criaAposta(codigo, campeonato, colocacao, valor));
		
		
		
	}

	/**
	 * Faz a listagem de todas as apostas registrads no sistema
	 * 
	 * @param mrBet
	 * 
	 */
	private static void statusAposta(SistemaMrBet mrBet) {
		System.out.println(mrBet.listaApostas());
	}

	/**
	 * Faz a exibição de todos os campeonatos que o time participa
	 * 
	 * @param mrBet		Sistema de apostas
	 * @param scanner	Scanner para fazer a leitura de qual time o usuário deseja verificar
	 */
	private static void exibirCampeonato(SistemaMrBet mrBet, Scanner scanner) {
		System.out.println("\nTime: ");
		String codigo = scanner.nextLine();
		
		System.out.println( "\n" + mrBet.exibirTime(codigo));
		
	}

	/**
	 * Adiciona um campeonato no sistema de apostas
	 * 
	 * @param mrBet		Sistema de apostas
	 * @param scanner	Scanner para leitura dos dados do campeonato para realizar seu registro
	 */
	private static void adicionaCampeonato(SistemaMrBet mrBet, Scanner scanner) {
		System.out.println("\nCampeonato: ");
		String nome = scanner.nextLine();
		
		System.out.println("\nParticipantes: ");
		int participantes = scanner.nextInt();
		
		System.out.println(mrBet.adicionarCampeonato(nome, participantes));
		
		@SuppressWarnings("unused")
		String ignore = scanner.nextLine();
		
	}

	/**
	 * Pega a informações de um dos times
	 * 
	 * @param mrBet		Sistema de apostas
	 * @param scanner	Scanner para ler qual time gostaremos de ver as informações
	 */
	private static void recuperaTime(SistemaMrBet mrBet, Scanner scanner) {
		
		System.out.println("\nCódigo: ");
		String codigo = scanner.nextLine();
		
		System.out.println(mrBet.recuperaTime(codigo) + "\n");
	}

	/**
	 * Realiza a inclusão de um time no sistema
	 * 
	 * @param mrBet		Sistema de apostas
	 * @param scanner	Scanner para a leitura dos dados do time que será incluido no sistema.
	 */
	private static void minhaInclusao(SistemaMrBet mrBet, Scanner scanner) {
		
		System.out.println("\nCódigo: ");
		String codigo = scanner.nextLine();
		
		
		System.out.println("\nNome: ");
		String nome = scanner.nextLine();
		
		
		System.out.println("\nMascote: ");
		String mascote = scanner.nextLine();
		
		System.out.println(mrBet.incluirTime(codigo, nome, mascote));
		
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sair() {
		System.out.println("Por hoje é só pessoal!");
		System.exit(0);
	}
	
}
