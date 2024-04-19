package view;

import javax.swing.JOptionPane;

public class viewCadastroPlantacao {

	public static String solicitaNomeDono() {
		String nome = JOptionPane.showInputDialog("Digite o nome do Dono da plantacao: ");
		return nome;
	}

	public static String solicitaEndereco() {
		String endereco = JOptionPane.showInputDialog("Digite o endereço da plantacao: ");
		return endereco;
	}

	public static String solicitaMetragem() {
		String metragem = JOptionPane.showInputDialog("Digite a metragem da plantacao: ");
		return metragem;
	}

	public static String solicitaData() {
		String data = JOptionPane.showInputDialog("Digite a data de Cadastro: ");
		return data;
	}

	public static String solicitaPlantacaoDesejada(String exibeTexto) {
		String plantacaoSelecionada = JOptionPane.showInputDialog(
				exibeTexto + "\n\nDigite o nome referente a plantacao que deseja atualizar: ");

		return plantacaoSelecionada;
	}
}
