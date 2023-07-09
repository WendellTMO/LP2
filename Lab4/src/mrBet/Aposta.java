package mrBet;

/**
 * O sistema faz o registro das apostas que são construídas por essa classe
 * 
 * @author Wendell Tomé Marinho OLiveira - 122110748
 *
 */
public class Aposta {
		/**
		 * Valor da aposta
		 */
		private double valor;
		
		/**
		 * Time que foi feita aposta
		 */
		private Time team;
		
		/**
		 * Campeonato que foi feita aposta
		 */
		private Campeonato camp;
		
		/**
		 * Colocação que foi apostada
		 */
		private int colocacao;
		
		/**
		 * Construtor da aposta 
		 * 
		 * @param team - Time que está sendo feito aposta
		 * @param camp - Campeonato que está sendo feito aposta
		 * @param colocacao - Colocação que está sendo apostada no time
		 * @param valor - Valor que está sendo feito aposta
		 */
		public Aposta(Time team, Campeonato camp, int colocacao, double valor) {
			this.team = team;
			this.camp = camp;
			this.colocacao = colocacao;
			this.valor = valor;
			
		}
		
		/**
		 * Cria em representação em String de aposta 
		 * 
		 * @return - Devolução de aposta e suas informações no formato:
		 * 			"[CÓDIGO_TIME] NOME_DO_TIME / MASCOTE_TIME
		 * 			 NOME_CAMPEONATO
		 * 			 COLOCAÇÃO_APOSTADA / TOTAL_PARTICIPANTES
		 * 			 VALOR DA APOSTA "
		 */
		public String toString() {
			return  team.toString() + "\n" +
					camp.getNome() + "\n" +
					colocacao + "/" + camp.getParticipantes() + "\n" +
					"R$ " + String.format("%.2f", valor) + "\n";
		}
		
		/**
		 * Colocação do time que foi feito a aposta
		 * @return Integer que representa a colocação do time que foi feito a aposta
		 */
		public int getColocacao() {
			return this.colocacao;
		}
		
		/**
		 * Metodo para pegar o objeto de time que foi feito a aposta
		 * @return Objeto Time que foi realizado a aposta
		 */
		public Time getTeam() {
			return team;
		}
		
		/**
		 * Metodo para pegar o nome do time que foi feito a aposta
		 * 
		 * @return String do nome do time
		 */
		public String getNome() {
			return this.team.getNome();
		}
		
		
}
