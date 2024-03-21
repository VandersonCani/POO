package controle;

import model.ContaBancaria;
import model.Movimentacao;
import visualizacao.entradaSaida;

public class Controladora {
	public void exibeMenu() {
		int opcoes;
		boolean encerrarSessao = false;

		ContaBancaria contabancaria = new ContaBancaria();

		opcoes = entradaSaida.apresentaMenu();

		do {
			switch (opcoes) {

			case 0:
				contabancaria.setTitularDaConta(entradaSaida.solicitaNomeTitular());
				contabancaria.setTipo(entradaSaida.solicitaTipoDaContaDesejada());
				break;

			case 1:
				entradaSaida.exibeDados(contabancaria);
				break;

			case 2:
				double deposito = entradaSaida.solicitarInformacoesDeposito();
				Movimentacao movimentacao = new Movimentacao();
				
				movimentacao.setMovimentacao(contabancaria.setDeposito(deposito));
				
				
							
				break;

			case 3:
				break;

			case 4:
				opcoes = entradaSaida.apresentaMenuExtrato();
				switch (opcoes) {
				
				case 0:
					entradaSaida.exibirExtratoCompleto();
				break;
				
				case 1:
					entradaSaida.exibirExtratoDeDepositos();
				break;
				
				case 2:
					entradaSaida.exibirExtratoDeSaques();
				break;
				}
			}
			opcoes = entradaSaida.apresentaMenu();
		} while (encerrarSessao != true);
	}
}
