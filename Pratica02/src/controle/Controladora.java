package controle;

import java.util.ArrayList;

import model.ContaBancaria;
import visualizacao.entradaSaida;

public class Controladora {
	public void exibeMenu() {
		int opcoes;
		boolean encerrarSessao = false;
		ArrayList<ContaBancaria> listaDeConta = new ArrayList<ContaBancaria>();
		
		ContaBancaria contabancaria = new ContaBancaria();
		
		

		do {
			opcoes = entradaSaida.apresentaMenu();
			switch (opcoes) {

			case 0:
				contabancaria.setTitularDaConta(entradaSaida.solicitaNomeTitular());
				contabancaria.setTipo(entradaSaida.solicitaTipoDaContaDesejada());
				listaDeConta.add(contabancaria);
				break;

			case 1:
				entradaSaida.exibeDados(contabancaria);
				break;

			case 2:
				System.out.println(contabancaria.getSaldo());
				contabancaria.depositar(entradaSaida.solicitarInformacoesDeposito());
				System.out.println(contabancaria.getSaldo());
				break;

			case 3:
				System.out.println(contabancaria.getSaldo());
				contabancaria.saque(entradaSaida.solicitarInformacoesSaque());
				System.out.println(contabancaria.getSaldo());
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
		} while (encerrarSessao != true);
	}
}
