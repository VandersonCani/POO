package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.ContaBancaria;


public class entradaSaida {

	public static String solicitaNomeTitular() {

		String name = JOptionPane.showInputDialog("Digite o Nome Completo do Titular da Conta");
		return name;
	}

	public static int solicitaTipoDaContaDesejada() {

		int conta = Integer.parseInt(JOptionPane
				.showInputDialog("Qual tipo de Conta Deseja Criar?\n(1) Conta Corrente  \n(2) Conta Poupança"));
		return conta;
	}

	public static int apresentaMenu() {
		String opcoes[] = { "Criar Conta", "Dados do Titular", "Depositar", "Sacar", "Exibir Extrato" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opcão Desejada", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

	public static double solicitarInformacoesDeposito() {
		Double deposito = Double.parseDouble(JOptionPane.showInputDialog("Depósito: EX(10.00)"));
		return deposito;
	}

	public static double solicitarInformacoesSaque() {
		Double saque = Double.parseDouble(JOptionPane.showInputDialog("Saque: EX(10.00)"));
		return saque;
	}

	public static void exibirDadosDaConta() {

	}

	public static void exibirExtratoCompleto() {
		JOptionPane.showMessageDialog(null, "Extrato Completo: ");
	}

	public static void exibirExtratoDeDepositos() {

	}

	public static void exibirExtratoDeSaques() {

	}

	public static void exibeErroContaInexistente(ContaBancaria contabancaria) {
		if (contabancaria.getTitularDaConta() == null || contabancaria.getTitularDaConta().equals("")) {
		} else {
			JOptionPane.showMessageDialog(null,
					"Nenhuma conta foi Criada, primeiro Crie uma conta para poder realizar as operações Necessárias.");
		}
	}

	public static void exibeErroSaldoInsuficiente(double saldo) {
		JOptionPane.showMessageDialog(null, "Saldo Insuficiente, você pode sacar apenas: R$" + saldo);
	}

	public static void exibeSaldPosSaque(double saldo) {
		JOptionPane.showMessageDialog(null, "Saldo Atual: R$" + saldo);
	}

	public static void exibeDados(ContaBancaria contabancaria) {
		String txt = "";
		String titular = contabancaria.getTitularDaConta();

		txt += "Nome: " + titular + "\n";

		if (contabancaria.getTipo() == 1) {
			txt += "Conta Corrente \n";
		} else {
			txt += "Conta Poupança \n";
		}
		JOptionPane.showMessageDialog(null, txt);
	}

	public static int apresentaMenuExtrato() {

		String opcoes[] = { "Extrato Completo", "Extrato Depósitos", "Extrato Saques" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opcão Desejada", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

}
