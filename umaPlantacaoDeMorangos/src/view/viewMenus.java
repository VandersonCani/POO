package view;

import javax.swing.JComboBox;

import javax.swing.JOptionPane;

public class viewMenus {

	public static int MenuInicial() {
		String opcoes[] = { "Cadastrar Plantação", "Navegar Pela Plantação Cadastrada", "Encerrar Programa" };

		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a Opção Desejada: ", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static int navegacaoPlantacoes() {
			String opcoes[] = { "Movimentar Produção", "Encerrar Programa" };
		
			JComboBox<String> menu = new JComboBox<String>(opcoes);
			JOptionPane.showConfirmDialog(null, menu, "Escolha o que deseja Atualizar", JOptionPane.OK_CANCEL_OPTION);
			return menu.getSelectedIndex();
	}

	public static int movimentarProducao() {
		String opcoes[] = { "Adicionar Produção", "Atualizar Produção", "Remover Produção", "Listar Produção", "Encerrar Programa" };
		
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Escolha o que deseja Atualizar", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
}
