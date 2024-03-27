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
				contabancaria.setTipoCo(entradaSaida.solicitaTipoDaContaDesejada());
				listaDeConta.add(contabancaria);
				break;

			case 1:
				entradaSaida.exibeDados(contabancaria);
				break;

			case 2:
				contabancaria.depositar(entradaSaida.solicitarInformacoesDeposito());
				break;

			case 3:
				contabancaria.saque(entradaSaida.solicitarInformacoesSaque());
				break;

			case 4:
				opcoes = entradaSaida.apresentaMenuExtrato();
				String txt;
				switch (opcoes) {
				
				case 0:
					txt = ContaBancaria.exibirExtratoCompleto();
					System.out.println(txt);
					break;

				case 1:
					txt = ContaBancaria.exibirExtratoDeDepositos();
					System.out.println(txt);					
					break;

				case 2:
					txt = ContaBancaria.exibirExtratoDeSaques();
					System.out.println(txt);
					break;
				}
			}
		} while (encerrarSessao != true);
	}
}
